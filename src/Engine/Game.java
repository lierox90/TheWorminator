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
	private boolean ifMovedFlag = false;
	private boolean isActiveFlag = false;
	
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
	
	public void clearBoard()
	{
		for(int i=0;i<board.size();i++)
		{
			for(int j=0;j<board.get(i).size();j++)
			{
				board.get(i).get(j).clearCreature();
			}
		}
	}
	
	private void makeNewBacterieAfterBeingEaten()
	{
		Random rn = new Random();
		int posX = rn.nextInt(24);
		int posY = rn.nextInt(13);
		while(board.get(posX).get(posY).isOccupied())
		{
			posX = rn.nextInt(24);
			posY = rn.nextInt(13);
		}
		board.get(posX).get(posY).setCreature(new Creature(false,20));
	}
	
	public void setCreaturesRandomly()
	{
		clearBoard();
		Random rn = new Random();
		int posX = rn.nextInt(24);
		int posY = rn.nextInt(13);
		System.out.println(posX+","+posY);
		board.get(posX).get(posY).setCreature(new Creature(true,100));
		for(int i=1;i<=10;i++)
		{
			posX = rn.nextInt(24);
			posY = rn.nextInt(13);
			//System.out.println(posX+","+posY);
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
	
	public void setActive()
	{
		this.isActiveFlag = true;
	}
	
	public void setUnactive()
	{
		this.isActiveFlag = false;
	}
	
	public boolean isActive()
	{
		return this.isActiveFlag;
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
						if(board.get(i).get(j).getCreature().getLife()>0)
						{
							int direction = board.get(i).get(j).getCreature().rotate();
							System.out.println("Direction - "+direction);
							switch (direction) 
							{
				            	case 0:
				            	{
				            		//top left
				            		System.out.println("Upper Left");
				            		if(i%2 == 0)
				            		{
					            		if(i>0 && j>0)
					            		{
					            			if(board.get(i-1).get(j-1).isOccupied())
					            			{
					            				board.get(i).get(j).getCreature().eat(board.get(i-1).get(j-1).getCreature());
					            				makeNewBacterieAfterBeingEaten();
					            			}
					            			board.get(i).get(j).getCreature().makeStep();
					            			board.get(i-1).get(j-1).setCreature(board.get(i).get(j).getCreature());
				            				board.get(i).get(j).setCreature(null);
					            		}
				            		}
				            		else
				            		{
					            		if(i>0)
					            		{
					            			if(board.get(i-1).get(j).isOccupied())
					            			{
					            				board.get(i).get(j).getCreature().eat(board.get(i-1).get(j).getCreature());
					            				makeNewBacterieAfterBeingEaten();
					            			}
					            			board.get(i).get(j).getCreature().makeStep();
					            			board.get(i-1).get(j).setCreature(board.get(i).get(j).getCreature());
				            				board.get(i).get(j).setCreature(null);
					            		}
				            		}
				            		break;
				            	}
				            	case 1:  
				            	{
				            		//bottom left
				            		if(i%2 == 0)
				            		{
					            		if(i>0)
					            		{
					            			System.out.println("Bottom Left");
					            			if(board.get(i-1).get(j).isOccupied())
					            			{
					            				board.get(i).get(j).getCreature().eat(board.get(i-1).get(j).getCreature());
					            				makeNewBacterieAfterBeingEaten();
					            			}
					            			board.get(i).get(j).getCreature().makeStep();
					            			board.get(i-1).get(j).setCreature(board.get(i).get(j).getCreature());
				            				board.get(i).get(j).setCreature(null);
					            		}
				            		}
				            		else
				            		{
					            		if(i>0 && j<board.get(i).size()-1)
					            		{
					            			System.out.println("Bottom Left");
					            			if(board.get(i-1).get(j+1).isOccupied())
					            			{
					            				board.get(i).get(j).getCreature().eat(board.get(i-1).get(j+1).getCreature());
					            				makeNewBacterieAfterBeingEaten();
					            			}
					            			board.get(i).get(j).getCreature().makeStep();
					            			board.get(i-1).get(j+1).setCreature(board.get(i).get(j).getCreature());
				            				board.get(i).get(j).setCreature(null);
					            		}
				            		}
				            		break;
				            	}
				            	case 2:  
				            	{
				            		//bottom
				            		if(!ifMovedFlag)
				            		{
					            		if(j<board.get(i).size()-1)
					            		{
					            			System.out.println("Bottom");
					            			if(board.get(i).get(j+1).isOccupied())
					            			{
					            				board.get(i).get(j).getCreature().eat(board.get(i).get(j+1).getCreature());
					            				makeNewBacterieAfterBeingEaten();
					            			}
					            			board.get(i).get(j).getCreature().makeStep();
					            			board.get(i).get(j+1).setCreature(board.get(i).get(j).getCreature());
					            			board.get(i).get(j).clearCreature();
					            			ifMovedFlag = true;
					            		}
				            		}
				            		break;
				            	}
								case 3:  
				            	{
				            		//bottom right
				            		System.out.println("Bottom Right");
				        			if(!ifMovedFlag)
				            		{
					            		if(i%2 == 0)
					            		{
						            		if(i<board.size()-1)
						            		{
						            			if(board.get(i+1).get(j).isOccupied())
						            			{
						            				board.get(i).get(j).getCreature().eat(board.get(i+1).get(j).getCreature());
						            				makeNewBacterieAfterBeingEaten();
						            			}
						            			board.get(i).get(j).getCreature().makeStep();
						            			board.get(i+1).get(j).setCreature(board.get(i).get(j).getCreature());
					            				board.get(i).get(j).setCreature(null);
					            				ifMovedFlag = true;
						            		}
					            		}
					            		else
					            		{
						            		if(i<board.size()-1 && j<board.get(i).size()-1)
						            		{
						            			if(board.get(i+1).get(j+1).isOccupied())
						            			{
						            				board.get(i).get(j).getCreature().eat(board.get(i+1).get(j+1).getCreature());
						            				makeNewBacterieAfterBeingEaten();
						            			}
						            			board.get(i).get(j).getCreature().makeStep();
						            			board.get(i+1).get(j+1).setCreature(board.get(i).get(j).getCreature());
					            				board.get(i).get(j).setCreature(null);
					            				ifMovedFlag = true;
						            		}
					            		}
					            	}
				            		break;
				            	}
				            	case 4:  
				            	{
				            		//upper right
				            		System.out.println("Upper Right");
				            		if(!ifMovedFlag)
				            		{
					            		if(i%2 == 0)
					            		{
						            		if(i<board.size()-1 && j>0)
						            		{
						            			if(board.get(i+1).get(j-1).isOccupied())
						            			{
						            				board.get(i).get(j).getCreature().eat(board.get(i+1).get(j-1).getCreature());
						            				makeNewBacterieAfterBeingEaten();
						            			}
						            			board.get(i).get(j).getCreature().makeStep();
						            			board.get(i+1).get(j-1).setCreature(board.get(i).get(j).getCreature());
					            				board.get(i).get(j).setCreature(null);
					            				ifMovedFlag = true;
						            		}
					            		}
					            		else
					            		{
						            		if(i<board.size()-1)
						            		{
						            			if(board.get(i+1).get(j).isOccupied())
						            			{
						            				board.get(i).get(j).getCreature().eat(board.get(i+1).get(j).getCreature());
						            				makeNewBacterieAfterBeingEaten();
						            			}
						            			board.get(i).get(j).getCreature().makeStep();
						            			board.get(i+1).get(j).setCreature(board.get(i).get(j).getCreature());
					            				board.get(i).get(j).setCreature(null);
					            				ifMovedFlag = true;
						            		}
					            		}
					            	}
				            		break;
				            	}
				            	case 5:  
				            	{
				            		//upper
				            		System.out.println("Upper");
				            		if(j>0)
				            		{
				            			if(board.get(i).get(j-1).isOccupied())
				            			{
				            				board.get(i).get(j).getCreature().eat(board.get(i).get(j-1).getCreature());
				            				makeNewBacterieAfterBeingEaten();
				            			}
				            			board.get(i).get(j).getCreature().makeStep();
				            			board.get(i).get(j-1).setCreature(board.get(i).get(j).getCreature());
			            				board.get(i).get(j).setCreature(null);
				            		}
				            		break;
				            	}
				            	default: 
				            	{
				            		break;
				            	}
							}
						}
						else
						{
							isActiveFlag = false;
							board.get(i).get(j).clearCreature();
							j=board.get(i).size()-1;
							i=board.size()-1;
						}
					}	
				}
			}
		}
		ifMovedFlag = false;
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
			if(isActiveFlag)
			{
				calcBoard();
			}
			try 
			{
				Thread.sleep(700);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
