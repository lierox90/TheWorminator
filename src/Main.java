import java.awt.EventQueue;
import java.io.IOException;

import View.GUI;

import Engine.Game;

public class Main 
{
	static GUI visualisation;
	static Game hexGameplay;
    public static void main(String[] args) throws IOException 
    {
    	hexGameplay = new Game();
    	Thread GameThread = new Thread(hexGameplay);
    	visualisation = new GUI(hexGameplay);
		Thread FrameThread = new Thread(visualisation);
		FrameThread.start();
		GameThread.start();
    }
}
