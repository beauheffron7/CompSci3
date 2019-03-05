import java.util.ArrayList;

//Beau Heffron
//AP_HEAP
//DUE WEDNESDAYYY!?!?!?!
public class ApHeap
{
	public static ArrayList<Comparable> maxHeapify(ArrayList<Comparable> arr)
	{

		ArrayList<Comparable> temp = new ArrayList();
		temp.add(null);
		for (int p=0;p<arr.size();p++)
		{
			temp.add(arr.get(p));
		}



		int q=(temp.size())/2;


		for(int x=temp.size()-1;x>1;x--)
		{
			//System.out.println(temp);
			if(temp.get(x).compareTo(temp.get(x/2))>0)
			{
				Comparable t = temp.get(x);
				Comparable w = temp.get(x/2);
				temp.set((x/2),t);
				temp.set(x,w);
			}

		}
		temp.remove(0);
		return temp;

	}


	public static Comparable[] minHeapify(Comparable[] arr)
	{
		Comparable[] temp = new Comparable[arr.length+1];
		for (int x = 1;x<temp.length;x++)
		{
			temp[x]=(arr[(x-1)]);
		}

		int q=(temp.length)/2;

		for(int x=temp.length-1;x>1;x--)
		{
			//System.out.println(temp);
			if(temp[x].compareTo(temp[x/2])<0)
			{
				Comparable t = temp[x];
				Comparable w = temp[(x/2)];
				temp[x/2]=t;
				temp[x]=w;
			}

		}
		Comparable[] done = new Comparable[temp.length-1];
		for (int m=0;m<done.length;m++)
		{
			done[m]=temp[m+1];
		}

		System.out.println();
		/*for(int u = 0;u<done.length;u++)
		{

			System.out.print(done[u] +",");
		}*/



		return done;

	}


	public static ArrayList<Comparable> maxHeapSort(ArrayList<Comparable> arr)
	{
		int p = arr.size();
		ArrayList<Comparable> r = new ArrayList();
		while(r.size()!=p)
		{
			arr=maxHeapify(arr);
			
			r.add(0,arr.get(0));
			arr.remove(0);

		}
		return r;

	}


	public static Comparable[] minHeapSort(Comparable[] arr)
	{

		Comparable[] done = new Comparable[arr.length];


		while(done[done.length-1]==null)
		{
			//Step 1: heapify
			arr = minHeapify(arr);
			//Step 2: add first value to finished array
			for(int x=0;x<arr.length;x++)
			{
				if(done[x]==null)
				{
					done[x]=arr[0];
					arr[0]=Integer.MAX_VALUE;
					break;
				}
			}
			//Step 3: remove value	
		}


		for(int u = 0;u<done.length;u++)
		{
			System.out.print(done[u] +",");

		}

		return done;

	}







}
