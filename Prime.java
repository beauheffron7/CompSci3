
public class Prime 
{
	public static void main (String args[])
	{
		System.out.println(stuff());
	}
	
	
	
	public static String stuff() 
	{
		for (int i = 2, count = 0; ; i++) {
			if (isPrime(i)) {
				count++;
				if (count == 10001)
					return Integer.toString(i);
			}
		}
	}
	
	
	public static boolean isPrime(int x) 
	{
		if (x == 0 || x == 1)
		{
			return false;
		}
		else if (x == 2)
		{
			return true;
		}
		else 
		{
			if (x % 2 == 0)
			{
				return false;
			}
			for (int i = 3, end = sqrt(x); i <= end; i += 2) 
			{
				if (x % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}
		public static int sqrt(int x) 
		{
			int y = 0;
			for (int i = 32768; i != 0; i >>>= 1) 
			{
				y |= i;
				if (y > 46340 || y * y > x)
					y ^= i;
			}
			return y;
		}
}
