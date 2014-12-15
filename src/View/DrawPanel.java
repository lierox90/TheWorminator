package View;

import Elements.Creature;
import Elements.Hex;
import Engine.Game;
import Elements.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private BufferedImage image;
	private int mouseX,mouseY;
	private Game game;
	public DrawPanel() 
	{
		mouseX=mouseY=0;
		try 
	    {                
			image = ImageIO.read(new File("src/res/hexagon-256.png"));
	    } 
	    catch (IOException ex) 
	    {
	    }
	}
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(255,255,255));
        
        if(game != null)
        {
            for(int i=0;i<game.getBoard().size();i++)
            {
                for(int j=0;j<game.getBoard().get(i).size();j++)
                {
                	Point point = game.getBoard().get(i).get(j).getPos();
                	drawCell(g2d,point.getPosX(),point.getPosY());
                	if(game.getBoard().get(i).get(j).isOccupied())
                	{
                		drawCreature(game.getBoard().get(i).get(j).getCreature(),point.getPosX(),point.getPosY());
                	}
                }
            }    	
        }    
    }
    private void drawCell(Graphics2D g2d,int x,int y)
    {
    	g2d.drawImage(image, x, y, image.getWidth()/4, image.getHeight()/4, null);
    	drawBorder(g2d, x, y,isOnHover(g2d,x,y));
    }
    private void drawCreature(Creature creature,int x, int y)
    {
    	
    }
    private void drawBorder(Graphics2D g2d,int x,int y,Boolean hover)
    {
    	//Sets color upon distance from mid point of hex cell
    	if (hover)
    	{
    		g2d.setColor(new Color(0,0,255));
    	}
    	else
    	{
    		g2d.setColor(new Color(0,0,0));
    	}
    	//Draw lines around hex cell
    	g2d.drawLine(x+18, y+10, x+45, y+10);
    	//
    	g2d.drawLine(x+6, y+32, x+18, y+10);
    	g2d.drawLine(x+45, y+10, x+57, y+32);
    	//
    	g2d.drawLine(x+6, y+32, x+18, y+54);
    	g2d.drawLine(x+45, y+54, x+57, y+32);
    	//
    	g2d.drawLine(x+18, y+54, x+45, y+54);
    }
    //Pulls mouse coords for distance check
    void getMouseCoords(int p_mouseX,int p_mouseY)
    {
    	this.mouseX = p_mouseX;
    	this.mouseY = p_mouseY;
    }
    private Boolean isOnHover(Graphics2D g2d,int x,int y)
    {
    	//Calc mid point of hex cell
    	int imgMidPointX = (image.getWidth()/8) + x;
    	int imgMidPointY = (image.getHeight()/8) + y;
    	//Calc simplified range of hex
    	int hexRange = (image.getHeight()/8) - 10;
    	//Calc distance between hex cell mid point and mouse cursor
    	int hex_mouse_distance = (int) Math.sqrt(Math.pow(imgMidPointX-mouseX, 2)+Math.pow(imgMidPointY-mouseY, 2));
    	
    	//Debug
    	debugLine(g2d, imgMidPointX, imgMidPointY, hexRange, hex_mouse_distance, false);
    	
    	if (hexRange >= hex_mouse_distance)
    	{
    		return true;
    	}
    	return false;
    }
    private void debugLine(Graphics2D g2d,int imgMidPointX,int imgMidPointY, int hexRange, int hex_mouse_distance, boolean draw)
    {
    	if(draw)
    	{
        	//Debug text + line
        	g2d.setColor(new Color(0,0,0));  
        	//Text
        	g2d.drawString(Integer.toString(image.getWidth()/4), 200, 100);
        	g2d.drawString(Integer.toString(imgMidPointX), 200, 130);
        	g2d.drawString(Integer.toString(hexRange), 200, 160);
        	g2d.drawString(Integer.toString(hex_mouse_distance), 200, 190);
        	//Line
        	g2d.drawLine(imgMidPointX, imgMidPointY, mouseX, mouseY);
    	}
    }
    public void setGame(Game p_game)
    {
    	this.game = p_game;
    }
}
