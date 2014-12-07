import java.awt.EventQueue;
import java.io.IOException;

import View.GUI;

public class Main 
{
	static GUI visualisation;
    public static void main(String[] args) throws IOException 
    {
    	visualisation = new GUI();
		Thread FrameThread = new Thread(visualisation);
		FrameThread.start();
    }
}
