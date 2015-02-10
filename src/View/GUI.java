package View;

import Elements.Creature;
import Elements.Point;
import Engine.Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements Runnable
{
	//Inits
	private int width=982;
	private int heigh=670;
	private int atribVal = 20;
	private boolean isCreature = false;
	private BufferedImage onMarker;
	private BufferedImage offMarker;
	private BufferedImage wormMarker;
	private BufferedImage bactMarker;
	private JLabel onLabel;
	private JLabel creatureLabel;
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
        //Display Controls
		try 
	    {                
			onMarker = ImageIO.read(new File("src/res/green_small.png"));
			offMarker = ImageIO.read(new File("src/res/red_small.png"));
			bactMarker = ImageIO.read(new File("src/res/blue_small.png"));
			wormMarker = ImageIO.read(new File("src/res/red_small.png"));
	    } 
	    catch (IOException ex) 
	    {
	    }
		//Turned on Label
        onLabel = new JLabel(new ImageIcon(offMarker));
        onLabel.setBounds(209, 7, 16, 16);
        //Creature on Label
        creatureLabel = new JLabel(new ImageIcon(bactMarker));
        creatureLabel.setBounds(483, 7, 16, 16);
        //Game init
        game = hexGameplay;
        //Control buttons
        //Start
        JButton startButton = new JButton("Start");
        startButton.setBounds(2, 2, 100, 26);
        startButton.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	onLabel.setIcon(new ImageIcon(onMarker));
                game.setActive();
            }
        }); 
        //Stop
        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(102, 2, 100, 26);
        stopButton.addActionListener(new ActionListener() {
       	 
            public void actionPerformed(ActionEvent e)
            {
            	onLabel.setIcon(new ImageIcon(offMarker));
                game.setUnactive();
            }
        });
        //Place worm
        JButton wormButton = new JButton("Place worm");
        wormButton.setBounds(376, 2, 100, 26);
        wormButton.addActionListener(new ActionListener() {
          	 
            public void actionPerformed(ActionEvent e)
            {
            	creatureLabel.setIcon(new ImageIcon(wormMarker));
                isCreature = true;
                atribVal = 100;
            }
        });
        //Place bacterie
        JButton bactButton = new JButton("Place bact");
        bactButton.setBounds(506, 2, 100, 26);
        bactButton.addActionListener(new ActionListener() {
         	 
            public void actionPerformed(ActionEvent e)
            {
            	creatureLabel.setIcon(new ImageIcon(bactMarker));
                isCreature = false;
                atribVal = 20;
            }
        });
        //Randomize
        JButton randButton = new JButton("Random");
        randButton.setBounds(874, 2, 100, 26);
        randButton.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	onLabel.setIcon(new ImageIcon(offMarker));
                game.setUnactive();
                game.setCreaturesRandomly();
            }
        });  
        //Clear
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(774, 2, 100, 26);
        clearButton.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e)
            {
            	onLabel.setIcon(new ImageIcon(offMarker));
                game.setUnactive();
                game.clearBoard();
            }
        });  
        //Draw Panel
        final DrawPanel dPane = new DrawPanel();
        dPane.setBounds(0, 30, width-6, heigh-58);
        dPane.setBorder(BorderFactory.createLoweredBevelBorder());
        dPane.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent me) 
            {
            	Point hexPos = dPane.getHexCooards();
                if(game != null)
                {
                    for(int i=0;i<game.getBoard().size();i++)
                    {
                        for(int j=0;j<game.getBoard().get(i).size();j++)
                        {
                        	if(hexPos.getPosX() == game.getBoard().get(i).get(j).getPos().getPosX())
                        	{
                            	if(hexPos.getPosY() == game.getBoard().get(i).get(j).getPos().getPosY())
                            	{
                            		if(!game.isActive())
                            		{
                            			placeCreature(i,j);
                            		}
                            	}
                        	}
                        }
                    }
                }
            }                
        });
        dPane.addMouseMotionListener(new MouseMotionAdapter() 
        {
        	@Override
        	public void mouseMoved(MouseEvent me) 
            {
        		dPane.getMouseCoords(me.getX(), me.getY());
            }
        });
        dPane.setGame(game);
        //Addition
        this.add(dPane);
        this.add(onLabel);
        this.add(startButton);
        this.add(stopButton);
        this.add(creatureLabel);
        this.add(wormButton);
        this.add(bactButton);
        this.add(randButton);
        this.add(clearButton);
        
    }
    private void placeCreature(int i, int j)
    {
    	game.getBoard().get(i).get(j).setCreature(new Creature(isCreature,atribVal));
    }
    
	@Override
	public void run()
	{
		while(true)
		{
			repaint();
			try 
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//System.out.println("Frame Thread");
		}
	}
}