package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	private BufferedImage image;
	public DrawPanel() 
	{
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
        drawCell(g2d,50,50,false);
    }
    private void drawCell(Graphics2D g2d,int x,int y, Boolean hover)
    {
    	g2d.drawImage(image, x, y, image.getWidth()/4, image.getHeight()/4, null);
    	drawBorder(g2d, x, y, hover);
    }
    private void drawBorder(Graphics2D g2d,int x,int y,Boolean hover)
    {
    	g2d.setColor(new Color(0,0,0));
    	//
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
}
