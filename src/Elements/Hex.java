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
		this.animal = a_animal;
	}
	
	public boolean isOccupied()
	{
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
