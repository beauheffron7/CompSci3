
public class ThreeAndFive {
	public static void main(String args[])
	{
		System.out.println(stuff(1000));
	}
public static int stuff(int num)
{
	int swer = 0;
	for (int x = 0;x<num;x++)
	{
		if(x%3==0)
		{
			swer+=x;
		}else if(x%5==0)
		{
			swer+=x;
		}
	}	
	return swer;
}
}
