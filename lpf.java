
public class lpf 
{
	public static void main(String[] args)
	{
		
	    long x=600851475143L;
	    long biggest=0L;
	    for(long y=2L; y<=x; y++)
	    {
	        for(long q=1L; q<=Math.sqrt(y); q++)
	        {
	            if(q%y==0)
	            {
	                break;
	            } else{
	            	
	                while(x%y==0)
	                {
	                    x=x/y;
	                    biggest =y;
	                }
	            }
	        }
	    }
	    System.out.println(biggest);
	}
}