package projet.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import projet.graphics.Animation;
import projet.graphics.Assets;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;

public class Ball extends Creature {
	private Animation animBalls;
	private int i;
	private boolean run = false;

	//private Thread thread;
	//private boolean running = false;
	
	public Ball(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 28;
		bounds.height = 30;
		
		setHealth(1000000000);
	
		animBalls = new Animation(150, Assets.balls);
	}	

	@Override
	public void tick() {
		move();
		animBalls.tick();
		checkDigs();
		//theBigBang();
		
		

	}
	
	/*public void theBigBang() {
		
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
				this.i = 0;
				return;
			} else {
				this.i = i + 1;
				if (i >= 59) {
			y++;
			for(projet.entities.Entity e1 : handler.getWorld().getEntityManager().getEntities()) {
				if (e1.equals(this))
					continue;
				if (e1.getCollisionBounds(0, 0).intersects(dr)) {
					e1.hurt(1);
					return;
				}
			}
		}
				return;
			}	
			
		}
	}*/
	
	
	
	public void checkDigs() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle dr = new Rectangle();
		int drSize = 2;
		dr.width = drSize;
		dr.height = drSize;
		

		 if(handler.getKeyManager().down) {
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
					 e.hurt(100);
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
				if(getHealth() < 1000000000){
					if(handler.getKeyManager().right){
						xMove = 1;
						run = true;
						setHealth(1000000000);
					} else if (handler.getKeyManager().left) {
						xMove= -1;
						setHealth(1000000000);
					}
				}
				if(!run)
					yMove = 1;
				
				return;
			}
			}
			
		}
	

	
	public void die(){
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(animBalls.getCurrentFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
	}

	/*@Override
	public void run() {
		this.checkDigs();
	}

	/*@Override
	public void run() {
		while(running) {
			checkDigs();
		}
		stop();
		
	}

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
	}*/
}

