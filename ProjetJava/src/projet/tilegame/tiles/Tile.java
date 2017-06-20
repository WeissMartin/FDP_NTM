package projet.tilegame.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import projet.display.Screen;

public class Tile {
	
	//STATIC STUFF
	
	public static Tile[] tiles = new Tile[256];
	public static Tile dirtTile = new DirtTile(0);
	public static Tile blockTile = new BlockTile(1);
	public static Tile stoneTile = new StoneTile(2);
	public static Tile diamondTile = new DiamondTile(3);
	public static Tile ballTile = new BallTile(4);
	public static Tile exitTile = new ExitTile(5);
	public static Tile stoneTile2 = new StoneTile2(6);
	public static Tile deathTile = new DeathTile(7);
	public static Tile batTile2 = new BatTile(8);
	public static Tile fishTile = new FishTile(9);
	public static Tile octopusTile2 = new OctopusTile(10);
	
	//CLASS
	static Screen screen = new Screen();
	public static final int TILEWIDTH = 32//screen.getScreenWidthVoulu()*5/100
							, TILEHEIGHT = 32;//screen.getScreenHeightVoulu()*5/100;
	
	protected BufferedImage texture;
	protected int id;
	
	
	public void setId(int id) {
		this.id = id;
	}

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		dirtTile.setId(3);
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
}
