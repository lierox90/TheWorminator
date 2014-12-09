package Elements;

import java.util.ArrayList;
import java.util.Random;

public class Creature 
{
	private boolean isWorm;
	private Point position;
	private int atrib;
	private Genome genePool;
	
	
	public Creature(boolean c_Creature, int a_atrib){
		this.isWorm = c_Creature;
		this.atrib = a_atrib;
		this.genePool = new Genome();
	}
	
	
	public Point getPos(){
		return position;
	}
	
	
	public void setPos(Point p_pos){
	this.position = p_pos;	
	}
	
	
	public boolean isWorm()
	{
		if(isWorm) return true;
		return false;
	}
	
	
	public Point move(){
		if(isWorm){
			rotate();
			position.setPosX(position.getPosX()); // chodzi o to ze tutaj tracimy stare pozycje i trzeba by miec dostep do planszy zeby usunac wskaznik przedprzesunieciem i przestawic go po przesunieciu, wiec trzeba miec dostep do macierzy hexow z poziomy creature
			position.setPosY(position.getPosY());// dobra tragedia
		}
		return position;
	}
	
	
	private Point rotate(){
		if(isWorm){
			Random rg = new Random();
			int[] genes = new int[6];
			for(int i=0;i<6;i++){
				genes[i]=rg.nextInt(90)+10;
			}
			return position;
		}
		else return null;	
	}
	
	
	private int eat(){
		if(isWorm){
			atrib+=20;
		}
		else atrib = 0;
		return atrib;
	}

	
	
	private int mutate()
	{
		//Popraw, dalem jakas wartosc zeby nie bytlo bledow
		return 0;
	}
}
