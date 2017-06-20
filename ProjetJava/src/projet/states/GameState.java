package projet.states;

import java.awt.Graphics;

import projet.entities.creatures.Diamond;
import projet.entities.creatures.Player;
import projet.graphics.Assets;
import projet.tilegame.Game;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;
import projet.tilegame.worlds.World;




public class GameState extends State {
	

	private World world;

	
// --- Class Constructor --- //	
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}
	
	@Override
	public void tick() {
		world.tick();

		
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
	}

}
