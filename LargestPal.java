
public class LargestPal 
{
	public static void main(String args[])
	{	
		System.out.println(stuff());
	}
	public static String stuff() 
	{
		int max = -1;
		for (int x = 100; x < 1000; x++)
		{
			for (int y = 100; y < 1000; y++)
			{
				int prod = x * y;
				if (isPalindrome(prod) && prod > max)
				{
					max = prod;
				}
			}
		}
		return Integer.toString(max);
	}
	public static boolean isPalindrome(int x) 
	{
		return Integer.toString(x).equals(reverse(Integer.toString(x)));
	}
	public static String reverse(String s) 
	{
		return new StringBuilder(s).reverse().toString();
	}
}
