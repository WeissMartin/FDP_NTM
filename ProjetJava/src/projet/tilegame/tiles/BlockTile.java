package projet.tilegame.tiles;

import java.awt.image.BufferedImage;

import projet.graphics.Assets;

public class BlockTile extends Tile {

	public BlockTile(int id) {
		super(Assets.block, id);
	}

	public boolean isSolid(){
		return true;
	}
	
	
}
