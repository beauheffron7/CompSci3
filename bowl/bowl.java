
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class bowl
{
	private static ArrayList<player> players = new ArrayList<player>();

	public static void main(String args[])
	{
		try
		{
		Scanner sc = new Scanner(System.in);
		//S:\HS\COMPSCI3\REPOSITORY\BowlTest
		String file =("S:\\HS\\COMPSCI3\\COMPSCI3-SEC1\\bheffron8781\\BOWL.txt");
		//System.out.println("What file would you like to examine?");
		//String file = sc.nextLine();
		Scanner inFile = new Scanner(new File(file));
		System.out.println(inFile.nextLine());

		String q="";
			while (inFile.hasNextLine())
			{
				q = inFile.nextLine();
				split(q);
			}
			printScores();
			printStuff();


		}catch(FileNotFoundException e)
		{
			System.out.println("BAD FILE!");
		}


	}
	public static void split(String q)
	{
		String name="";
		String score="";
		int w=0;
		for (int x = 1;x< q.length()-1  ;x++)
		{
			if(q.charAt(x)!='*')
			{
				name += q.charAt(x);
			}else{
				w=x;
				break;
			}

		}
		for (int y=w+1; y<q.length()-1;y++)
		{
			if(q.charAt(y)!='*')
			{
				score += (q.charAt(y));
			}else{
				break;
			}
		}
		player p = new player(score,name);
		System.out.println(p.getName());
		players.add(p);

	}
	public static void printScores()
	{

		for (int x=0;x<players.size();x++)
		{
			int score=0;
				if (players.get(x).getScore().length()>13 || players.get(x).getScore().length()<10)
				{
					System.out.println(players.get(x).getName()+": INVALID SCORE");
					players.get(x).setboo(false);
					break;
				}else
				{
					for (int frames = 0;frames<=players.get(x).getScore().length()-2;frames++)
					{
						boolean strike = false;
						boolean spare = false;
						if (players.get(x).getScore().charAt(frames)=='X')
						{
							strike = true;
						}else if(players.get(x).getScore().charAt(frames)=='/')
						{
							spare=true;
						}
						if (strike!= true&& spare!=true)
						{
							score+=((int)players.get(x).getScore().charAt(frames));
							players.get(x).add(score);
						}
						if (strike==true)
						{

							score+=10;
							if (players.get(x).getScore().charAt(frames+1)=='X')
							{
								score+=10;
							}else
							{
								score+=players.get(x).getScore().charAt(frames+1);
							}
							if (players.get(x).getScore().length()-frames>=3)
							{
								if (players.get(x).getScore().charAt(frames+2)=='X')
								{
								score+=10;
								}else
								{
									score+=players.get(x).getScore().charAt(frames+2);
								}
								strike=false;
								players.get(x).add(score);
							}

						}
						if (spare==true)
							{
								score+=10;
								if (players.get(x).getScore().charAt(frames)=='/')
								{
									score+=(10-players.get(x).getScore().charAt(frames-1));
									players.get(x).add(score);
								}else
								{
									score+=players.get(x).getScore().charAt(frames+1);
									players.get(x).add(score);
								}
									spare=false;

						}
				}
			}


				if(score>300)
				{
					System.out.println(players.get(x).getName()+": INVALID SCORE");
					//players.get(x).setboo(false);
				}else if(players.get(x).getName()!=null)
				{
				System.out.println(players.get(x).getName()+" Scored a : "+ score);
				}
		}

	}
	public static void printStuff()
	{
		for (int x=0;x<players.size();x++)
		{
			System.out.println();
			if(players.get(x).getboo()==true)
			{
				System.out.println(players.get(x).getName());
				for (int y=0;y<players.get(x).getScore().length()-1;y++)
				{
					System.out.print("---");
				}
				System.out.println();
				for(int q=0;q<players.get(x).getScore().length()-1;q++)
				{
					if(players.get(x).getScore().charAt(q)=='X')
					{
						System.out.print("X |");
					}else{
						System.out.print(players.get(x).getScore().charAt(q));
					}
					if (q%2==0)
					{
						System.out.print(" ");
					}

				}
				System.out.println();
				for(int p=0;p<players.get(x).getSize()-1;p++)
				{
					System.out.print(players.get(x).getF(p)+" ");
				}
				System.out.println();
				for (int y=0;y<players.get(x).getScore().length()-1;y++)
				{
					System.out.print("---");
				}
			}
		}
	}
		/*for (int x = 0; x<3; x++)
		{
			int score = 0;
			if (players.get(x).getName().length()>21)
			{
				System.out.println(players.get(x).getName()+"'s score is invalid");
			}else
			{
				for (int y=0;y<players.get(x).getScore().length()-1;y++)
				{
					if(players.get(x).getScore().charAt(y)=='x')
					{
						score+=10;
						if(players.get(x).getScore().charAt(y+1)=='x')
						{
							score+=10;
							if(players.get(x).getScore().charAt(y+2)=='x')
							{
								score+=10;
							}
						}
					}else
					{
						score+=((int)(players.get(x).getScore().charAt(y)));
					}
				}

			}
			if (score>300)
			{
				System.out.println(players.get(x).getName()+"INVALID BOARD");
			}
			System.out.println(players.get(x).getName()+" Scored: " + score);
		}*/

	}

