package Elements;

import java.util.ArrayList;
import java.util.Random;

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
		if(isWorm){
			rotate();
			position.setPosX(position.getPosX()+1);
			position.setPosY(position.getPosY()+1);
		}
		return position;
	}
	private Point rotate(){
		if(isWorm){
			Random rn = new Random();
			int[] genes = new int[6];
			for(int i=0;i<6;i++){
				genes[i]=rn.nextInt(90)+10;
			}
			return position;
		}
		else return null;
		
	}
	private int eat(){
		if(isWorm){
			atrib+=100;
		}
		else atrib =0;
		return atrib;
	}
	
	private int mutate()
	{
		//Popraw, dalem jakas wartosc zeby nie bytlo bledow
		return 0;
	}

	public void die()
	{	
		position.setPosX(null);
		position.setPosY(null);
	}
	
}
