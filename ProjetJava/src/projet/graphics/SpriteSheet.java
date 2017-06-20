package projet.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage sheet;
	
// --- Class Constructor --- //
	
	public SpriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
// --- Method which take a part of the sprite sheet --- //	
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}