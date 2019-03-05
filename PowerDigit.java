import java.math.BigInteger;

public class PowerDigit 
{
	public static void main(String args[])
	{
		System.out.println(stuff());
	}
	
	public static String stuff() 
	{
		int sum = 0;
		String s = BigInteger.ONE.shiftLeft(1000).toString();

		for (int x = 0; x < s.length(); x++)
		{
			sum += s.charAt(x) - '0';
		}
		return Integer.toString(sum);
	}
}
