//Beau Heffron
public class Tree
{
	public static void main(String args[])
	{
		Tree t = new Tree();
		t.add(999);
		t.add(123);
		t.add(555);
		t.add(5555);
		t.add(6666);
		t.add(788);
		t.add(5666);
		t.add(1000);
		System.out.println(t.maxNode().getValue());
		System.out.println(t.minNode().getValue());
		System.out.println(t.successor().getValue());
		System.out.println(t.remove(999));
		System.out.println(t.remove(4534));
	}
	private class TreeNode
	{
		private Comparable value;
		private TreeNode left;
		private TreeNode right;
		private TreeNode parent;
		public TreeNode(Comparable init)
		{
			value = init;
			left = null;
			right = null;
		}
		public Comparable getValue()
		{
			return value;
		}
		public TreeNode getLeft()
		{
			return left;
		}
		public TreeNode getRight()
		{
			return right;
		}
		public TreeNode getParent()
		{
			return parent;
		}
		public void setValue(Comparable newComp)
		{
			value = newComp;
		}
		public void setLeft(TreeNode newLeft)
		{
			left = newLeft;
		}
		public void setRight(TreeNode newRight)
		{
			right = newRight;
		}
		public void setParent(TreeNode p)
		{
			parent = p;
		}


	}
	private TreeNode root;
	public Tree()
	{
		root = null;
	}
	private TreeNode minNode()
	{
		return minNode(this.root);
	}
	private TreeNode minNode(TreeNode x)
	{
		TreeNode min = x;
		while(min.getLeft()!=null)
		{
			min=min.getLeft();
		}
		return min;

	}
	private TreeNode maxNode()
	{
		return maxNode(this.root);
	}
	private TreeNode maxNode(TreeNode x)
	{
		TreeNode max = x;
		while(max.getRight()!=null)
		{
			max=max.getRight();
		}
		return max;

	}
	private boolean verifyParentLinks()
	{
		return verifyParentLinksHelper(root,null);
	}
	private boolean verifyParentLinksHelper(TreeNode x, TreeNode parent)
	{
		return(x==null||x.getParent()==parent&&verifyParentLinksHelper(x.getLeft(),x)&&verifyParentLinksHelper(x.getRight(),x));
	}
	private TreeNode successor()
	{
		return successor(this.root);
	}
	private TreeNode successor(TreeNode s)
	{
		if (s==null)
		{
			return null;
		}
		TreeNode right = s.getRight();
		if(right!=null)
		{
			return minNode(right);
		}
		TreeNode parent = s.getParent();
		while(parent!=null&&parent.getRight()==s)
		{
			s=parent;
			parent = s.getParent();
		}
		return parent;
	}
	public boolean add(Comparable c)
	{	
		TreeNode wee = new TreeNode(c);
		if(root==null)
		{
			root=wee;
		}
		TreeNode current = root;
		boolean x = false;
			while(x==false)
			{
				if(c.compareTo(current.getValue())==0)
				{
					return false;
				}
				if(c.compareTo(current.getValue())>0)
				{
					if(c.compareTo(current.getValue())==0)
					{
						return false;
					}
					if(current.getRight()==null)
					{
						current.setRight(wee);
						x=true;
					}else
					{
						current = current.getRight();
					}
				}
				if(c.compareTo(current.getValue())<0)
				{
					if(c.compareTo(current.getValue())==0)
					{
						return false;
					}
					if(current.getLeft()==null)
					{
						current.setLeft(wee);
						x=true;
					}else
					{
						current = current.getLeft();
					}


				}
			}
			return x;
	}
	public boolean remove(Comparable c)
	{
		//check if tree is empty
		if(root.getValue()==null)
		{
			return false;
		}
		//Find it
		boolean exists=false;
		TreeNode ish = root;
		while(!exists)
		{
			if(ish.getValue().compareTo(c)==0)
			{
				exists = true;
			}
			if(ish.getValue().compareTo(c)>0)
			{
				if(ish.getRight()==null)
				{
					return false;
				}
				ish=ish.getRight();

			}else if(ish.getValue().compareTo(c)<0)
			{
				if(ish.getLeft()==null)
				{
					return false;
				}
				ish = ish.getLeft();
			}
		}

		//Only has right child
		if(ish.getRight()!=null&&ish.getLeft()==null)
		{
			ish=ish.getRight();
			return true;
		}
		
		
		//Only has Left child
		if(ish.getLeft()!=null&&ish.getRight()==null)
		{
			ish=ish.getLeft();
			return true;
		}
		// else
		if(ish.getRight()!=null&&ish.getRight()!=null)
		{
			ish.setValue(successor(ish).getValue());
		}


		
		if(root.getRight()!=null&&root.getRight()!=null)
		{
			root.setValue(successor(root).getValue());
		}
		if(root.getLeft()!=null&&root.getLeft()!=null)
		{
			root.setValue(successor(root).getValue());
		}
		//If it is parent
		if(root.getValue()==c)
		{
			root.setValue(successor(root).getValue());
			return true;
		}
	
		
		return false;
	}
}
