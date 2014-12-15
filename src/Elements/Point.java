package Elements;

public class Point 
{
	private int posX;
	private int posY;
	
	public Point(int p_posX,int p_posY)
	{
		this.posX = p_posX;
		this.posY = p_posY;
	}
	
	public void setPosX(int p_posX)
	{
		this.posX = p_posX;
	}
	
	public void setPosY(int p_posY)
	{
		this.posY = p_posY;
	}
	
	public int getPosX()
	{
		return this.posX;
	}
	
	public int getPosY()
	{
		return this.posY;
	}
}
