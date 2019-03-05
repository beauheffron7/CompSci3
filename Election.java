import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

//Beau Heffron
//CompSci3

public class Election 
{
	private static Set<String> candidates;
	private static Map<Integer,List<String>> ballots;
	private static Map<List<String>,Integer> prefBallots;

	public static void main(String args[])
	{
		try
		{
		
		HashMap<Integer,List<String>> ballots = new HashMap<Integer,List<String>>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("What file would you like to examine?");
		String file = sc.nextLine();
		Scanner inFile = new Scanner(new File(file));
		
		//create Candidates
		System.out.println("a");
		candidates = new TreeSet<String>();
		String q = sc.nextLine();
		int count=0;
		int c=0;
		for(int x = 0;x<q.length();x++)
		{
			if(q.charAt(x) == (' '))
			{
				c=x;
				candidates.add(q.substring(count, c));
				count = c;
			}
		}
		System.out.println("a");
		//CREATE BALLOT
		int x = 0;
		while(sc.hasNextLine()) {
			List<String> list = new LinkedList<String>(Arrays.asList(sc.nextLine().split("\\s+")));
			list.remove(0);
			
			ballots.put(++x,list);
		}
		System.out.println("a");
		System.out.println(ballots);
		
		//CREATE PREF
		prefBallots = new HashMap<List<String>,Integer>();
		for(int i : ballots.keySet())
		{
			prefBallots.put(ballots.get(i),(prefBallots.containsKey(ballots.get(i)) ? prefBallots.get(ballots.get(i)) : 0) + 1);
		}
		
		//System.out.println(plurality());
		
		}catch(FileNotFoundException e)
		{
			System.out.println("BAD FILE!");
		}
	}
	public static Set<String> plurality()
	{
		Map<String,Integer> b = new HashMap<String,Integer>();
		HashSet<String> winners = new HashSet<String>();
		for(List<String> w : prefBallots.keySet())
		{
			if(b.containsKey(w.get(0)))
			{
				b.put(w.get(0),b.get(w.get(0))+prefBallots.get(w));
			}else{
				b.put(w.get(0),0+prefBallots.get(w));
			}
		}
		int v = -1;
		for(String x: b.keySet())
		{
			if(b.get(x)>v)
			{
				v = b.get(x);
			}
		}
		for(String x: b.keySet())
		{
			if(b.get(x)==v)
			{
				winners.add(x);
			}
		}
		return winners;
		
	}
	public Set<String> Majority(HashMap<String,Integer> b)
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		Set<String> winners = new TreeSet<String>();
		int x = 0;
		int y = -1;
		for(List<String> z : prefBallots.keySet())
		{
			map.put(z.get(0),(map.containsKey(z.get(0)) ? map.get(z.get(0)) : 0) + prefBallots.get(z));
		}
		
		for(String i : map.keySet()) 
		{
				y = map.get(i) > y ? map.get(i) : y;
				x += map.get(i);
		}
		
		for(String i : map.keySet())
		{
			if (map.get(i) > x/2)
			{
				winners.add(i);
			}
		}
		
		return winners;
	}
	public Set<String> Borda(HashMap<String,Integer> b)
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		Set<String> winners = new TreeSet<String>();
			
		for(List<String> x : prefBallots.keySet())
		{
			for (int c = x.size(),s = 0;s < x.size();s++,c--)
			{
				map.put(x.get(s),(map.containsKey(x.get(s)) ? map.get(x.get(s)) : 0) + c);
			}
		}
		
		int y = -1;
		for(String q : map.keySet())
		{
				y = map.get(q) > y ? map.get(q) : y;
		}
		
		for(String z : map.keySet())
		{
			if (map.get(z) == y)
			{
				winners.add(z);
			}
		}
		
		return winners;
	}
	public Set<String> Hares(HashMap<String,Integer> b)
	{
		Map<List<String>,Integer> map = new HashMap<List<String>,Integer>(prefBallots);
		Map<String,Integer> m;
		Set<String> winners = new TreeSet<String>();
		Set<String> c = new TreeSet<String>(candidates);

		for (int x = 0;x < candidates.size();x++) 
		{
			m = new HashMap<String,Integer>();
			for (Entry<List<String>,Integer> entry : map.entrySet()) 
			{
			//	String q = String.join(",",entry.getKey());
			//	m.put(q,(m.containsKey(q) ? m.get(q) : 0) + entry.getValue());
			}
			map = new HashMap<List<String>,Integer>();
			for (Entry<String,Integer> entry : m.entrySet()) 
			{
				map.put(new LinkedList<String>(Arrays.asList(entry.getKey().split(","))),entry.getValue());
			}
			
			Map<String,Integer> w = new HashMap<String,Integer>();
			
			for (String r : c)
			{
				w.put(r,0);
			}
			
			for(List<String> r : map.keySet())
			{
				w.put(r.get(0),(w.containsKey(r.get(0)) ? w.get(r.get(0)) : 0) + map.get(r));
			}
			int t = Integer.MAX_VALUE;
			
			for(String r : w.keySet())
					t = w.get(r) < t ? w.get(r) : t;
			
			for(List<String> r : map.keySet())
			{
				for(int q = 0;q < r.size();q++)
				{
					if (w.get(r.get(q)) == t) 
					{
						if (r.size() == 1) 
						{
							winners.add(r.get(q));
							return winners;
						} else if (r.size() == 2 && w.get(r.get(q + 1)) == t) {
							winners.add(r.get(q + 1));
							winners.add(r.get(q));
							return winners;
						} else 
						{
							c.remove(r.get(q));
							r.remove(q--);
						}
					} else if (r.size() == 1) 
					{
						winners.add(r.get(0));
						return winners;
					}
				}
			}
						
		}
		
		return winners;
	}public Set<String> PairWise(HashMap<String,Integer> b)
	{
		HashSet winners = new HashSet<String>();
		return winners;
	}
	
}
