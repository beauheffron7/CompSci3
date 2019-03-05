//Beau Heffron

import java.util.Scanner;
import java.util.Stack;
public class BinConv
{

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stck = new Stack();
		System.out.println("What Bianary would you like to convert?");
		String x = sc.nextLine();
		for (int y = 0;y<x.length();y++)
		{
			stck.push((int)(x.charAt(y))-48);
		}
		System.out.println(stck);
		double j = 0;
		for(int s=0;s<x.length();s++)
	   {
			if(stck.pop()!=0)
			{
				j+= Math.pow(2,s);
				
			}
	    }
	    System.out.println(j);

	}
}
	
