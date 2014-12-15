package Elements;

import java.util.ArrayList;
import java.util.Random;

public class Creature 
{
	private boolean isWorm;
	private int atrib;
	private Genome genePool;
	
	
	public Creature(boolean c_Creature, int a_atrib){
		this.isWorm = c_Creature;
		this.atrib = a_atrib;
		this.genePool = new Genome();
	}
	
	public boolean isWorm()
	{
		if(isWorm) 
			return true;
		return false;
	}
	
	private int rotate()
	{
		if(isWorm)
		{
			Random rn = new Random();
			int number = rn.nextInt(100);
			int temp = 100;
			int id = 0;
			for(int i = 0;i<6;i++)
			{
				int dif = genePool.getGene(i) - number;
				if(dif<temp)
				{
					temp = dif;
					id = i;
				}
			}
			return id;
		}
		return -1;
	}
	
	
	private int eat()
	{
		if(isWorm){
			atrib+=20;
		}
		else atrib = 0;
		return atrib;
	}

	
	
	private int mutate(Genome newGenePool)
	{
		
		return 0;
	}
}
