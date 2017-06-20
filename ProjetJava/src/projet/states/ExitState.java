package projet.states;

import java.awt.Color;
import java.awt.Graphics;

import projet.display.Screen;
import projet.graphics.Assets;
import projet.tilegame.Game;
import projet.tilegame.Handler;
import projet.tilegame.ui.ClickListener;
import projet.tilegame.ui.UIImage;
import projet.tilegame.ui.UIImageButton;
import projet.tilegame.ui.UIManager;

public class ExitState extends State {

	private UIManager uiManager;

	public ExitState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(192, 216, 192, 96, Assets.btn_retry, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				final int width, height;
				Screen screen = new Screen();
				width = screen.getScreenWidthVoulu();
				height = screen.getScreenHeightVoulu();
				Game game = new Game("Tile Game!", width, height);
				game.start();
			}
		}));
		uiManager.addObject(new UIImage(100, 0, 376, 216, Assets.gameover));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 576, 336);
		uiManager.render(g);
		g.setColor(Color.BLACK);
		g.fillRect(475, 0, 336, 336);
	}

}