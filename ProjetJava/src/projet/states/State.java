package projet.states;

import java.awt.Graphics;

import projet.tilegame.Game;
import projet.tilegame.Handler;


// --- Class which contains all the methods that states will have --- //

public abstract class State {
	
	private static State currentState = null; //Hold the state we currently want to tick and render in our game
	
// --- Setter that change the state the game currently ticks and renders, and show the screen --- //
	
	public static void setState(State state){ 
		currentState = state;
	}
	
// --- Getter that get the current state --- //
	
	public static State getState(){
		return currentState;
		
	}
	//CLASS
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

}