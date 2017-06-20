package projet.tilegame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import projet.display.Display;
import projet.graphics.Assets;
import projet.graphics.GameCamera;
import projet.states.ExitState;
import projet.states.GameState;
import projet.states.MenuState;
import projet.states.State;
import projet.tilegame.input.KeyManager;
import projet.tilegame.input.MouseManager;





// --- Main Class, will start, run and close everything  --- //

public class Game implements Runnable {  //Allow Game class to run on a Thread

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs; //It's as a way for the computer to draw things to the screen. It use Buffer, which is a "Hidden" computer screen within your computer
	private Graphics g;
	
// --- States ---//
	
	public State gameState;
	public State menuState;
	
// --- Input --- //
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
// --- Camera --- //
	
	private GameCamera gameCamera;
	
// --- Handler --- //
	
	private Handler handler;
	
// --- Class Constructor --- //
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
// --- Method which initialize all the graphics --- //
	
	private void init(){
		display = new Display(title, width, height);	//Initialize display
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		menuState = new MenuState(handler);					//Initialize menuState
		gameState = new GameState(handler);					//Initialize gameState
		State.setState(menuState);
		
	}
	

	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy(); 		//Set the BufferStrategy object bs equal to the current BufferStrategy of our canvas
		if(bs == null){										//Check if the Canvas has no BufferStrtegy
			display.getCanvas().createBufferStrategy(3);	//Create BufferStrategy with 3 Buffers
			return;
		}
		g = bs.getDrawGraphics();							//Permit to draw to the canvas
		g.clearRect(0, 0, width, height);					//Clear Screen every single time we render

		//Draw begining
		
		if(State.getState() != null)
			State.getState().render(g);
		
		//Draw ending
		bs.show();		//Tell to Java that we ended to draw and that he can display it
		g.dispose();	//Make sure our graphics object gets done with properly
	}
	
	public void run(){
		
		init();
		
		int fps =60; 							//Amount of time we want to call the tick and render methods every second
		double timePerTick = 1000000000/fps; 	//Maximum amount of time in nanoseconds that we have to execute the tick and render methods that will achieve our fps target
		double delta = 0;						// Amount of time we have until we call the tick and render methods again
		long now;								//Current time of our computer
		long lastTime = System.nanoTime();		//Return the amount of time in nanoseconds that our computer is running at
		long timer = 0;							//Is going to time until we get 1second
		int ticks = 0;							//How many time our tick and render methods are called
		
		// --- GAME LOOP --- //
		
		while(running){
			now = System.nanoTime();
			timer += (now - lastTime);
			delta += (now - lastTime)/timePerTick;	//(now - lastTime) is the amount of time passed since we last called this line of code
													//This is going to add to the delta variable how much time we have until we have to call tick and render methods again
			lastTime = now;
			
			if(delta >= 1){
				tick();		//Update all the variables, positions of objects, etc
				render();	//Render (Draw) everything to the screen
				ticks++;
				delta--;
			}
			
			// --- Ticks Counter --- //
			
			if(timer >= 1000000000)	{
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public MouseManager getMouseManger(){
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	// --- Method which create the Thread --- //
	
	public synchronized void start(){			//Check if the game is already running
		if(running)								//Safety
			return;
		running = true;
		thread = new Thread(this);				//Initialize Thread
		thread.start();							//Start the Thread
	}
	
	// --- Method which stop the Thread --- //
	
	public synchronized void stop(){			//Check if the game is already stopped
		if(!running)							//Safety
			return;
		running = false;
		try {
			thread.join();						//Stop the Thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}