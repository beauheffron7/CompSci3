//Beau Heffron
//Comp Sci-3
public class LinkedListCount {
		private CountNode myListHead;
		public int add(Object o)
		{
			CountNode z= new CountNode(o);
			if (myListHead.getMyNode()==null)
			{
				myListHead.setMyNode(z);
			}else
			{
				CountNode temp = myListHead.getMyNode();
				CountNode temp2 = myListHead;
				while(temp!=null)
				{
					temp2= temp;
					temp = temp.getMyNode();
				}
				temp2.setMyNode(z);
			}
			return z.getMyCount();
		}
		public Object remove(Object o)
		{
			CountNode before = myListHead;
			CountNode tempNode = myListHead.getMyNode();
			CountNode after = tempNode.getMyNode();
			while(tempNode!=null)
			{
				before = tempNode;
				tempNode = after;
				after=after.getMyNode();
				if(tempNode.getMyObject()==o && tempNode.getMyCount()>1)
				{
					int count =tempNode.getMyCount()-1;
					tempNode.setMyCount(count);
					return count;
				}else if(tempNode.getMyObject()==o&& tempNode.getMyCount()<=1 )
				{
					Object x = tempNode.getMyObject();
					before.setMyNode(after);
					return x;
				}
			}
			return null;

		}
		
		public int Count()
		{
			int count=0;
			count +=myListHead.getMyCount();
			CountNode temp = myListHead.getMyNode();
			while(temp!=null)
			{
				temp = temp.getMyNode();
				count+=temp.getMyCount();
			}
			return count;

		}
		public boolean removeAll(Object o)
		{
			CountNode before = myListHead;
			CountNode tempNode = myListHead.getMyNode();
			CountNode after = tempNode.getMyNode();
			while(tempNode!=null)
			{
				tempNode = after;
				after=after.getMyNode();
				if(tempNode.getMyObject()==o)
				{
					before.setMyNode(after);
					return true;
				}
			}
			return false;

		}
		public String toString()
		{
			CountNode tempNode;
			tempNode = myListHead;
			String nodes="";
			while(tempNode.getMyNode()!= null)
			{
				nodes+=tempNode.toString();
			}
			return nodes;
		}

			public class CountNode
			{
				private Object myObject;
				private CountNode myNode;
				private int myCount;
				public CountNode(Object o)
				{

				}
				public Object getMyObject()
				{
					return myObject;
				}
				public int getMyCount()
				{
					return myCount;
				}
				public CountNode getMyNode()
				{
					return myNode;
				}
				public Object setMyObject(Object newObject)
				{
					return myObject = newObject;
				}
				public int setMyCount(int newCount)
				{
					return myCount=newCount;
				}
				public CountNode setMyNode(CountNode NextNode)
				{
					return myNode = NextNode;
				}
				public String toString()
				{
					return " ["+myObject + myCount+"]=======>";
				}

			}
		

}
