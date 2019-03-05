
public class SmallestMultiple {
	public static void main(String args[])
	{
		System.out.println(stuff());
	}
	public static int stuff() 
	{
	    int i = 2520;
	    boolean x = false;
	    while (!x) 
	    {
	        i += 2520;
	        boolean divis = true;
	        for (int j = 11; j <= 20; j++)
	        {
	            if (i % j != 0) 
	            {
	                divis = false;
	                break;
	            }
	        }
	        if (divis) 
	        {
	            x = true;
	        }
	    }
	    return i;
	}
}
