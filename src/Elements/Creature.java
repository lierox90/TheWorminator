package Elements;

public class Creature 
{
	private boolean isWorm;
	private Point position;
	private int atrib;
	private Genome genePool;
	
	
	public Point getPos(){
		return position;
	}
	
	
	public void setPos(Point p_pos){
	this.position = p_pos;	
	}
	
	
	public Point move(){
		if(isWorm)
		{
			rotate();
			position.setPosX(5);
			position.setPosY(3);
		}
		return position;
	}
	private Point rotate(){
		if(isWorm)
		{
			position.setPosX(5);
			position.setPosY(3);
		}
		return position;
	}
	private int eat(){
		if(isWorm)
		{
			
		}
		return atrib;
		
	}
	private int mutate(){
		
	}
	private boolean divide(){
		
	}
	public die(){
		
	}
	
}
