package Engine; // Very important commentary

import java.util.ArrayList;
import java.util.List;

import Elements.Hex;

public class Game 
{
	private List<ArrayList<Hex>> board;
	
	public Game()
	{
		int initX=0;
		int initY=0;
		board = new ArrayList<ArrayList<Hex>>();
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
	
	public List<ArrayList<Hex>> getBoard()
	{
		return board;
	}
}
