import info.gridworld.actor.Actor;
//Beau Heffron

public class AgeActor extends Actor implements Comparable
{
	private int myAge;
	public AgeActor()
	{
		myAge = 0;
	}
	public void act()
	{
		myAge++;
	}
	public int getAge()
	{
		return myAge;
	}
	public int compareTo(Object o)
	{
		AgeActor e = ((AgeActor)o);
		if (myAge> e.getAge())
		{
			return 1;
		}else if(myAge==e.getAge())
		{
			return 0;
		}

		return -1;
	}
}
