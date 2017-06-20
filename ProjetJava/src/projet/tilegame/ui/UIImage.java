package projet.tilegame.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class UIImage extends UIObject {

	private BufferedImage images;
	
	
	public UIImage(float x, float y, int width, int height, BufferedImage images) {
		super(x, y, width, height);
		this.images = images;
		
	}

	@Override
	public void tick() {}

	@Override
	public void render(Graphics g) {
			g.drawImage(images, (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {

	}

}