//Beau Heffron
//Comp Sci 3
// Friday 16
public class AreaHelper {
	public static void main(String[] args)
	{
		double[] a ={1,-5,2};
		System.out.println(synSub(a,2));
	}

	public static double synSub(double[] arr, double x)
	{
		double y = arr[0];
		for(int q=1;q<arr.length;q++)
		{
			y = y * x + arr[q];
		}
		return y;
	}
	public static double rRAM(double poly[],int numRects, double start, double end)
	{
		double sum= 0;
		double interval = (end-start)/numRects;
		for(int x=0;x<numRects;x++)
		{
			sum += (synSub(poly,start+ interval * (x+1)))*(interval);
		}
		return sum;
	}
	public static double lRAM(double poly[],int numRects, double start, double end)
	{
		double sum= 0;
		double interval = (end-start)/numRects;
		for(int x=0;x<numRects;x++)
		{
			sum += (synSub(poly,start + interval*x))*(interval);
		}
		return sum;
	}
	public static double mRAM(double poly[],int numRects, double start, double end){
		double sum= 0;
		double interval = (end-start)/numRects;
		for(int x=0;x<numRects;x++)
		{
			sum += (synSub(poly,((start+interval/2)+interval*x)));
		}
		return sum;

	}
	public static double trap(double poly[],int numRects, double start, double end)
	{
		double sum= 0;
		double interval = (end-start)/numRects;
		for(int x=0;x<numRects;x++)
		{
			sum += ((synSub(poly,start + interval*x)+synSub(poly,start+ interval * (x+1))/2))*(interval);
		}
		return sum;
	}
}
