package projet.tilegame.tiles;

import java.awt.image.BufferedImage;

import projet.graphics.Assets;

public class BallTile extends Tile {

	public BallTile(int id) {
		super(Assets.ball, id);
	}

	public boolean isSolid(){
		return false;
	}
	
	
}
