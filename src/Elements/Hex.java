package Elements;

public class Hex 
{
	private Creature animal = null;
	
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
