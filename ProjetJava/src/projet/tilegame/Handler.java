package projet.tilegame;

import projet.entities.creatures.Player;
import projet.graphics.GameCamera;
import projet.tilegame.input.KeyManager;
import projet.tilegame.input.MouseManager;
import projet.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private Player player;
	
	public Handler(Game game){
		this.game = game;
	}
	
// --- Methods --- //
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManger();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
// --- GETTERS AND SETTERS --- ///
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	public float getY(){
		return player.getY();
	}

}
