package projet.display;


import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	// --- Class Constructor --- //
	
	public Display(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	// --- Create a Window to see the game with graphics---//
	
	private void createDisplay(){
		
		// --- Create the Window --- //
		
		frame = new JFrame(title);									//Initialize the JFrame
		frame.setSize(width, height);								//Set the size of the JFrame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Would make sure that the Window close properly
		frame.setResizable(false);									//The User can't drag the Window
		frame.setLocationRelativeTo(null);							//The Window appear in the middle of the screen
		frame.setVisible(true);										//To see our Window
		
		// --- Allows us to draw a graphic --//
		
		canvas = new Canvas();										//Initialize the Canvas 
		canvas.setPreferredSize(new Dimension(width, height));		//Set the size of the Canvas The Dimension class encapsulates the width and height of a component (in integer precision) in a single object
		canvas.setMaximumSize(new Dimension(width, height));		//Set the Maximum size of the Canvas
		canvas.setMinimumSize(new Dimension(width, height));		//Set the Minimum size of the Canvas
		canvas.setFocusable(false);
		
		frame.add(canvas);			//Add the Canvas to the JFrame
		frame.pack();				//Resize the Window to be able to see the Canvas fully
	}

	// --- Getter to access canvas --- //
	
	public Canvas getCanvas(){
		return canvas;
	}
		
	public JFrame getFrame(){
		return frame;
	}
}