
public class EvenFib {
public static void main(String args[])
{
	System.out.println(stuff());
}
public static String stuff()
{
	int sum = 0;
	int x = 1; 
	int y = 2; 
	while (x <= 4000000) {
		if (x % 2 == 0)
			sum += x;
		int z = x + y;
		x = y;
		y = z;
	}
	return Integer.toString(sum);
}
}
