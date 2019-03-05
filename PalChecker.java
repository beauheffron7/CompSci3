import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//Beau Heffron
public class PalChecker
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("What pal would you like to check?");
		String x = sc.nextLine();
		Stack<Character> stck = new Stack<Character>();
		Queue que = new Queue();
		for(int q = 0;q<x.length();q++)
		{
			stck.push(x.charAt(q));
			que.add(x.charAt(q));
			
		}
		boolean t = true;
		for(int p = 0;p<x.length();p++)
		{
			if(stck.pop()!=que.remove())
			{
				t = false;
				break;
			}
		}
		System.out.println(t);
	}
	public static class Queue
	{
		private ArrayList<Character> a = new ArrayList<Character>();
		public Queue()
		{
		}
		public void add(Character b)
		{
			a.add(b);
		}
		public Character remove()
		{
			return a.remove(0);
		}
	}

}
