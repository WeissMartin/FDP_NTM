package projet.tilegame.worlds;

import java.awt.Graphics;

import projet.entities.EntityManager;
import projet.entities.creatures.Ball;
import projet.entities.creatures.Bat;
import projet.entities.creatures.Death;
import projet.entities.creatures.Diamond;
import projet.entities.creatures.Dirt;
import projet.entities.creatures.Fish;
import projet.entities.creatures.Octopus;
import projet.entities.creatures.Player;
import projet.tilegame.Handler;
import projet.tilegame.tiles.Tile;
import projet.tilegame.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	// --- Entities --- //
	
	private EntityManager entityManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		loadWorld(path);
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				switch(tiles[i][j]){
				
				case 2:
					entityManager.addEntity(new Dirt(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 3:
					entityManager.addEntity(new Diamond(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 4:
					entityManager.addEntity(new Ball(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 7:
					entityManager.addEntity(new Death(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 8:
					entityManager.addEntity(new Bat(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 9:
					entityManager.addEntity(new Fish(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
				case 10:
					entityManager.addEntity(new Octopus(handler, Tile.TILEWIDTH*i, Tile.TILEHEIGHT*j));
					break;
					
				
				/*if(tiles[i][j] == 3)
					entityManager.addEntity(new Diamond(handler, 32*i, 32*j));*/
			}
		}
	}
		//entityManager.addEntity(new Diamond(handler, 32*9, 32));
		//entityManager.addEntity(new Diamond(handler, 32*21, 32*2));
		
		
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick(){
		entityManager.tick();
	}
	
	public void render(Graphics g){
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Entities
		
		entityManager.render(g);
}
	
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.blockTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if(t == null)
			return Tile.blockTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2])*32;
		spawnY = Utils.parseInt(tokens[3])*32;
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
}