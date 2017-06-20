package projet.states;

import java.awt.Graphics;

import projet.graphics.Assets;
import projet.tilegame.Handler;
import projet.tilegame.ui.ClickListener;
import projet.tilegame.ui.UIImage;
import projet.tilegame.ui.UIImageButton;
import projet.tilegame.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(125, 250, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		uiManager.addObject(new UIImageButton(325, 250, 128, 64, Assets.btn_story, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		uiManager.addObject(new UIImage(0, 0, 576, 248, Assets.menu));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}