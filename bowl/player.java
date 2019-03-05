import java.util.ArrayList;


public class player {
	private String score;
	private String name;
	private boolean boo=true;
	private ArrayList<Integer> framed = new ArrayList<>();
	public player(String line, String n)
	{
		score = line;
		name = n;
	}
	public void setboo(boolean x)
	{
		boo=x;
	}
	public String getScore()
	{
		return score;
	}
	public String getName()
	{
		return name;
	}
	public boolean getboo()
	{
		return boo;
	}
	public void add(int c)
	{
		framed.add(c);
	}
	public Integer getF(int c)
	{
		return framed.get(c);
	}
	public int getSize()
	{
		return framed.size();
	}


}
