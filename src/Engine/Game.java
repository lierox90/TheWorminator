package Engine; // Very important commentary

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Elements.Hex;
import Elements.Creature;

public class Game implements Runnable
{
	private List<ArrayList<Hex>> board;
	//private List<Creature> creatures;
	
	public Game()
	{
		int initX=0;
		int initY=0;
		board = new ArrayList<ArrayList<Hex>>();
		//creatures = new ArrayList<Creature>();
		
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
		board.get(posX).get(posY).setCreature(new Creature(true,100));
		for(int i=1;i<=10;i++)
		{
			posX = rn.nextInt(24);
			posY = rn.nextInt(13);
			System.out.println(posX+","+posY);
			if(!board.get(posX).get(posY).isOccupied())
			{
				board.get(posX).get(posY).setCreature(new Creature(false,20));
			}
			else
			{
				i--;
			}
		}
	}

	private void calcBoard()
	{
		for(int i=0;i<board.size();i++)
		{
			for(int j=0;j<board.get(i).size();j++)
			{
				if(board.get(i).get(j).getCreature()!= null)
				{
					if(board.get(i).get(j).getCreature().isWorm())
					{
						int direction = board.get(i).get(j).getCreature().rotate();
						switch (direction) 
						{
			            	case 0:
			            	{
			            		//left
			            		System.out.println("Left");
			            		break;
			            	}
			            	case 1:  
			            	{
			            		//bottom left
			            		System.out.println("Bottom Left");
			            		break;
			            	}
			            	case 2:  
			            	{
			            		//bottom
			            		System.out.println("Bottom");
			            		break;
			            	}
			            	case 3:  
			            	{
			            		//right
			            		System.out.println("Right");
			            		break;
			            	}
			            	case 4:  
			            	{
			            		//upper right
			            		System.out.println("Upper Right");
			            		break;
			            	}
			            	case 5:  
			            	{
			            		//right
			            		System.out.println("Upper");
			            		break;
			            	}
			            	default: 
			            	{
			            		//bacteria
			            		System.out.println("Bact");
			            		break;
			            	}
						}
					}	
				}
			}
		}
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
				Thread.sleep(500);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
