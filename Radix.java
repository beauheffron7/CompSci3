import java.util.ArrayList;


public class Radix {
	private static int place;
	private static ArrayList<Integer> arr;
	public static void main(String args[])
	{
		arr = new ArrayList<Integer>();
		arr.add(944);
		arr.add(904);
		arr.add(147);
		arr.add(121);
		arr.add(2422);
		arr.add(99871);
		System.out.println(radixSort(arr));
	}
	public static ArrayList<Integer> radix(ArrayList<Integer> x)
	{	
		ArrayList<Integer> q = new ArrayList<Integer>();
		while(x.size()>0)
		{
			int num = -1;
			int c =Integer.MAX_VALUE;
			for(int w = 0;w<x.size();w++)
			{
				if(String.valueOf(x.get(w)).length()>place)
				{
					int p = digit((x.get(w)));
					if(p<c)
					{
						c = p;
						num = x.get(w);
						
					}
				}else
				{
					int p = 0;
					if(p<c)
					{
						c=p;
						num = x.get(w);
					}
					
				}
			}
			for(int w=0;w<x.size();w++)
			{
				if(x.get(w)==num)
				{
					
					q.add(x.get(w));
					x.remove(w);
					
					break;
				}
			}
			
		}
		place++;	
		return q;
	}
	public static int digit(int x)
	{
		String q = Integer.toString(x);
		
		return (Integer.parseInt(q.substring(q.length()-place-1,q.length()-place)));
	}
	public static ArrayList<Integer> radixSort(ArrayList<Integer> x)
	{
		int num = 0;
		for (int q=0;q<x.size();q++)
		{
			if( x.get(q) > num)
			{
				num = x.get(q);
			}
		}
		while(place<String.valueOf(num).length()-1)
		{
			x = radix(x);
		}
		return x;
	}
}
