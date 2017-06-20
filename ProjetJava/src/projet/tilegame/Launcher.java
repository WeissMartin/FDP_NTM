package projet.tilegame;

import projet.display.Screen;

public class Launcher {

	// --- Will start the game ---//
	
	public static void main(String[] args){
		final int width, height;
		Screen screen = new Screen();
		width = screen.getScreenWidthVoulu();
		height = screen.getScreenHeightVoulu();
		Game game = new Game("Tile Game!", width, height);
		game.start();
	}
	
}