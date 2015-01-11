package Engine; // Very important commentary

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Elements.Hex;
import Elements.Creature;

public class Game implements Runnable
{
	private List<ArrayList<Hex>> board;
	private List<Creature> creatures;
	
	public Game()
	{
		int initX=0;
		int initY=0;
		board = new ArrayList<ArrayList<Hex>>();
		creatures = new ArrayList<Creature>();
		
        for(int i=0;i<24;i++)
        {
        	
        	board.add(new ArrayList<Hex>());
            for(int j=0;j<13;j++)
            {
            	board.get(i).add(new Hex(initX,initY));
        		initY+=45;
            }
            initX+=40;
            if(i%2==1)
            {
            	initY=0;
            }
            else
            {
            	initY=23;
            }
        }
	}
	
	public void setCreaturesRandomly()
	{
		Random rn = new Random();
		int posX = rn.nextInt(24);
		int posY = rn.nextInt(13);
		System.out.println(posX+","+posY);
		creatures.add(new Creature(true,100));
		board.get(posX).get(posY).setCreature(creatures.get(0));
		for(int i=1;i<=10;i++)
		{
			posX = rn.nextInt(24);
			posY = rn.nextInt(13);
			System.out.println(posX+","+posY);
			if(!board.get(posX).get(posY).isOccupied())
			{
				creatures.add(new Creature(false,20));
				board.get(posX).get(posY).setCreature(creatures.get(i));
			}
			else
				i--;
			
		}
	}

	private void calcBoard()
	{
		
	}
	
	public List<ArrayList<Hex>> getBoard()
	{
		return board;
	}

	@Override
	public void run()
	{
		while(true)
		{
			calcBoard();
			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//System.out.println("Game Thread");
		}
	}
}
