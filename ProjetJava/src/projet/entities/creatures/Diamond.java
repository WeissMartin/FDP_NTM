package projet.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import projet.graphics.Animation;
import projet.graphics.Assets;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;

public class Diamond extends Creature {
	private Animation animDiamonds;
	private int i;
	
	public Diamond(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 28;
	
		animDiamonds = new Animation(150, Assets.diamonds);
	}
	
	public void checkDigs() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle dr = new Rectangle();
		int drSize = 2;
		dr.width = drSize;
		dr.height = drSize;
		
		dr.x = cb.x + cb.width / 2 - drSize / 2;
		dr.y = cb.y + cb.height;

		
		for(projet.entities.Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(dr)) {
				 e.hurt(1);
				return;
			}
			if (!e.getCollisionBounds(0, 0).intersects(dr)) {
				/*Thread t = new Thread(this);
				t.run();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					
					e1.printStackTrace();
				}*/
				yMove = 1;
				return;
			}
		}
	}

	@Override
	public void tick() {
		checkDigs();
		move();
		animDiamonds.tick();
		
	}
	
	public void die(){
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animDiamonds.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
	}

}
