package projet.display;

import java.awt.Dimension;

public class Screen {
	
	public static int SCREENHEIGHTWANTED, SCREENWIDTHWANTED;
	
	public Screen(){
		
	}
	
	public int screenWidth, screenHeight;
	public int getScreenHeight(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		return screenHeight = (int)dimension.getHeight();
	}
	public int getScreenHeightVoulu(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		SCREENHEIGHTWANTED = (int)dimension.getHeight()*30/100;
		return SCREENHEIGHTWANTED;
	}
	
	public int getScreenWidth(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		return screenWidth = (int)dimension.getWidth();
	}
	
	public int getScreenWidthVoulu(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		SCREENWIDTHWANTED = (int)dimension.getWidth()*30/100;
		return SCREENWIDTHWANTED;
	}
}