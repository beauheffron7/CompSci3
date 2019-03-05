
public class SumSquare {
	public static void main(String args[])
	{
		System.out.println(stuff());
	}
private static final int N = 100;
	
	public static String stuff() 
	{
		int sum = 0;
		int sum2 = 0;
		for (int i = 1; i <= N; i++) 
		{
			sum += i;
			sum2 += i * i;
		}
		return Integer.toString(sum * sum - sum2);
	}
}
