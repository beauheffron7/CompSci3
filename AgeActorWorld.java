import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
//Beau Heffron
import java.util.PriorityQueue;


public class AgeActorWorld extends ActorWorld 
{
	 public void step()
	    {
	        Grid<Actor> gr = getGrid();
	        PriorityQueue actors = new PriorityQueue<AgeActor>();
	        for (Location loc : gr.getOccupiedLocations())
	            actors.add(gr.get(loc));

	        while(!actors.isEmpty())
	        {
	            // only act if another actor hasn't removed a
	        	AgeActor a  = (AgeActor) actors.remove();
	            if (a.getGrid() == gr)
	                a.act();
	        }
	    }

}
