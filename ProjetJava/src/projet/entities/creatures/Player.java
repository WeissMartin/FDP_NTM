package projet.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import projet.graphics.Animation;
import projet.graphics.Assets;
import projet.states.ExitState;
import projet.states.State;
import projet.tilegame.Handler;

public class Player extends Creature{
	
// --- Animation --- //
	private Animation animUp, animDown, animLeft, animRight, animPlayer;
	


	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 2;
		bounds.y = 2;
		bounds.width = 28;
		bounds.height = 30;
		
	//Animations
		
		animUp = new Animation(400, Assets.player_up);
		animDown = new Animation(400, Assets.player_down);
		animLeft = new Animation(300, Assets.player_left);
		animRight = new Animation(300, Assets.player_right);
		animPlayer = new Animation(400, Assets.player_player);
	}

	@Override
	public void tick() {
		
		//Animation
		animUp.tick();
		animDown.tick();
		animLeft.tick();
		animRight.tick();
		animPlayer.tick();
		
		//Movement
		getInput(); 
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Dig
		checkDigs();
	}
	
	public void checkDigs() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle dr = new Rectangle();
		int drSize = 2;
		dr.width = drSize;
		dr.height = drSize;
		
		if(handler.getKeyManager().up) {
			dr.x = cb.x + cb.width / 2 - drSize / 2;
			dr.y = cb.y - drSize;
		} else if(handler.getKeyManager().down) {
			dr.x = cb.x + cb.width / 2 - drSize / 2;
			dr.y = cb.y + cb.height;
		} else if(handler.getKeyManager().left) {
			dr.x = cb.x - drSize;
			dr.y = cb.y + cb.height / 2 - drSize / 2;
		} else if(handler.getKeyManager().right) {
			dr.x = cb.x + cb.width;
			dr.y = cb.y + cb.height / 2 - drSize / 2;
		} else {
			return;	
		}
		
		for(projet.entities.Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(dr)) {
				e.hurt(1);
				return;
			}
		}
	}
	
	public void die(){
		handler.getWorld().getEntityManager().addEntity(new Die(handler, (int) (getX()),(int) (getY()+getHeight()/2)));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		State exitState;
		exitState = new ExitState(handler);
		State.setState(exitState);
		
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = - speed;
		if(handler.getKeyManager().down)
			yMove = + speed;
		if(handler.getKeyManager().left)
			xMove = - speed;
		if(handler.getKeyManager().right)
			xMove = + speed;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
/*		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);	*/
}
	
	private BufferedImage getCurrentAnimationFrame() {
		if(xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove < 0) {
			return animUp.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return animPlayer.getCurrentFrame();
		}
	}
}
