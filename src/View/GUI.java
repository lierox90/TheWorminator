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
			repaint();
			System.out.println("Refreshed");
			try 
			{
				Thread.sleep(20);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}