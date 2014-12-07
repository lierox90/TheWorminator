package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class GUI extends JFrame implements Runnable
{
	//Inits
	int width=100;
	int heigh=100;
	double initTimePrev = 0;
	double endTimePrev = 0;
	//Constructor
    public GUI() throws IOException 
    {
    	//Window init
        super("TheWorminator");
        setSize(width, heigh);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
    }
	@Override
	public void run()
	{
		while(true)
		{
			double initTimeCurrent = (double)System.currentTimeMillis();
			repaint();
			try 
			{
				Thread.sleep(13);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			double endTimeCurrent = (double)System.currentTimeMillis();
			double FPS = 1000/((endTimeCurrent - initTimeCurrent) * 0.9)+((endTimePrev - initTimePrev) * 0.1);
			//System.out.println("Current - "+(endTimeCurrent - initTimeCurrent) * 0.9);
			//System.out.println("Prev - "+(endTimePrev - initTimePrev) * 0.1);
			initTimePrev = initTimeCurrent;
			endTimePrev = endTimeCurrent;
			//System.out.println("FPS - "+1000/FPS);
		}
	}
}