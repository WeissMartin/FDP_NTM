package projet.entities.creatures;

import java.awt.Graphics;

import projet.graphics.Animation;
import projet.graphics.Assets;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;

public class Death extends Creature{
	private Animation animDeath;
	private int i;
	
	public Death(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
		animDeath = new Animation(150, Assets.deaths);
		setHealth(100);

	}


	@Override
	public void tick() {
		
		move();
		animDeath.tick();
		
	}
	
	public void die(){
			handler.getWorld().getEntityManager().addEntity(new Diamond(handler, (int) (getX()),(int) (getY()+getHeight()/2)));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animDeath.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
	}

}
