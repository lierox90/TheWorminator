package Elements;

public class Hex 
{
	private Creature animal;
	private Point g_position;
	
	public Hex(int x,int y)
	{
		this.g_position = new Point(x-3,y-8);
	}
	
	public Point getPos()
	{
		return g_position;
	}
	
	public Creature getCreature()
	{
		return animal;
	}
	
	public void setCreature(Creature a_animal)
	{
		//System.out.println("Replacing");
		this.animal = a_animal;
	}
	
	public void clearCreature()
	{
		//System.out.println("Clearing old");
		this.animal = null;
	}
	
	public boolean isOccupied()
	{
		//System.out.println("Checking if occupied");
		if (animal != null) 
        {
            return true;
        }
        return false;
	}
	
	public void clear()
	{
		animal = null;
	}
}
