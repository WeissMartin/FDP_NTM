package projet.entities.creatures;

import java.awt.Graphics;

import projet.graphics.Animation;
import projet.graphics.Assets;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;

public class Die extends Creature{
	private Animation animDie;
	private int i;
	
	public Die(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
		animDie = new Animation(150, Assets.die);
	}


	@Override
	public void tick() {
		
		move();
		animDie.tick();
		
	}
	
	public void die(){
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animDie.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
	}

}
