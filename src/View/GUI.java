package View;

import Engine.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame implements Runnable
{
	//Inits
	private int width=982;
	private int heigh=670;
	private double initTimePrev = 0;
	private double endTimePrev = 0;
	private double FPS = 0;
	private Game game;
	//Constructor
    public GUI(Game hexGameplay) throws IOException 
    {
    	//Window init
        super("TheWorminator");
        setSize(width, heigh);
        setResizable( false );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        //Game init
        game = hexGameplay;
        //Control buttons
        //Start
        JButton startButton = new JButton("Start");
        startButton.setBounds(2, 2, 100, 26);
        //Stop
        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(102, 2, 100, 26);
        //Place worm
        JButton wormButton = new JButton("Place worm");
        wormButton.setBounds(610, 2, 100, 26);
        //Place bacterie
        JButton bactButton = new JButton("Place bact");
        bactButton.setBounds(712, 2, 100, 26);
        //Randomize
        JButton randButton = new JButton("Random");
        randButton.setBounds(814, 2, 100, 26);
        //Clear
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(204, 2, 100, 26);
        //Draw Panel
        final DrawPanel dPane = new DrawPanel();
        dPane.setBounds(0, 30, width-6, heigh-58);
        dPane.setBorder(BorderFactory.createLoweredBevelBorder());
        dPane.addMouseMotionListener(new MouseMotionAdapter() 
        {
        	public void mouseMoved(MouseEvent me) 
            {
        		dPane.getMouseCoords(me.getX(), me.getY());
            }
        });
        dPane.setGame(game);
        //Addition
        this.add(dPane);
        this.add(startButton);
        this.add(stopButton);
        this.add(wormButton);
        this.add(bactButton);
        this.add(randButton);
        this.add(clearButton);
        
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
				Thread.sleep(100);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println("Frame Thread");
			double endTimeCurrent = (double)System.currentTimeMillis();
			FPS = 1000/((endTimeCurrent - initTimeCurrent) * 0.9)+((endTimePrev - initTimePrev) * 0.1);
			initTimePrev = initTimeCurrent;
			endTimePrev = endTimeCurrent;
		}
	}
}