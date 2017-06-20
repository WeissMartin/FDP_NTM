package projet.graphics;

import java.awt.image.BufferedImage;


//--- Class which allows us to to load in everything once but us it from anywhere at any time --- //

public class Assets {
	private static final int width = 16, height = 16;
	public static BufferedImage block, dirt, stone, ball, diamond, exit, stone2, menu, death, bat, fish, octopus,gameover;
	public static BufferedImage[] player_up, player_down, player_left, player_right, player_player;
	public static BufferedImage[] diamonds;	
	public static BufferedImage[] balls;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_story;
	public static BufferedImage[] btn_retry;
	public static BufferedImage[] deaths, bats, fishs, octopuss, die;
	
	
//--- Method which load everything --- //	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/decor.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/743362.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/SSBD.png"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/GOM.png"));
		
		block = sheet.crop(0, 0, width, height);
		dirt = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width*2, 0, width, height);
		ball = sheet.crop(width*2, 0, width, height);
		diamond = sheet.crop(width*2, 0, width, height);
		exit = sheet.crop(width*6, 0, width, height);
		stone2 = sheet.crop(width*2, 0, width, height);
		menu = sheet3.crop(0, height*4, width*16, height*12);
		gameover = sheet4.crop(0, height*28, width*44, height*30);
		death = sheet.crop(width*2, 0, width, height);
		bat = sheet.crop(width*2, 0, width, height);
		fish = sheet.crop(width*2, 0, width, height);
		octopus = sheet.crop(width*2, 0, width, height);
		
btn_retry = new BufferedImage[2];
		
		btn_retry[0] = sheet4.crop(0, 0, width*44, height*14);
		btn_retry[1] = sheet4.crop(0, height*14, width*44, height*14);
		
die = new BufferedImage[2];
	
		die[0] = sheet2.crop(width*4, height*5, width, height);
		die[1] = sheet2.crop(width*5, height*5, width, height);
		
deaths = new BufferedImage[4];
		
		deaths[0] = sheet.crop(width*3, height*8, width, height);
		deaths[1] = sheet.crop(width*3, height*9, width, height);
		deaths[2] = sheet.crop(width*3, height*10, width, height);
		deaths[3] = sheet.crop(width*3, height*11, width, height);
		
bats = new BufferedImage[4];
		
		bats[0] = sheet.crop(width*9, height*8, width, height);
		bats[1] = sheet.crop(width*9, height*9, width, height);
		bats[2] = sheet.crop(width*9, height*10, width, height);
		bats[3] = sheet.crop(width*9, height*11, width, height);
		
fishs = new BufferedImage[4];
		
		fishs[0] = sheet.crop(width*9, height*12, width, height);
		fishs[1] = sheet.crop(width*9, height*13, width, height);
		fishs[2] = sheet.crop(width*9, height*14, width, height);
		fishs[3] = sheet.crop(width*9, height*13, width, height);
		
octopuss = new BufferedImage[4];
		
		octopuss[0] = sheet.crop(width*10, height*12, width, height);
		octopuss[1] = sheet.crop(width*10, height*13, width, height);
		octopuss[2] = sheet.crop(width*10, height*14, width, height);
		octopuss[3] = sheet.crop(width*10, height*15, width, height);
		
		btn_start = new BufferedImage[2];
		
		btn_start[0] = sheet3.crop(0, 0, width*4, height*2);
		btn_start[1] = sheet3.crop(0, height*2, width*4, height*2);
		
		btn_story = new BufferedImage[2];
		
		btn_story[0] = sheet3.crop(width*4, 0, width*4, height*2);
		btn_story[1] = sheet3.crop(width*4, height*2, width*4, height*2);
		
		balls = new BufferedImage[4];
		
		balls[0] = sheet.crop(width*3, 0, width, height);
		balls[1] = sheet.crop(width*3, height, width, height);
		balls[2] = sheet.crop(width*3, height*2, width, height);
		balls[3] = sheet.crop(width*3, height*3, width, height);
		
		diamonds = new BufferedImage[4];
		
		diamonds[0] = sheet.crop(width*4, 0, width, height);
		diamonds[1] = sheet.crop(width*4, height, width, height);
		diamonds[2] = sheet.crop(width*4, height*2, width, height);
		diamonds[3] = sheet.crop(width*4, height*3, width, height);
		
		player_up = new BufferedImage[2];
		player_down = new BufferedImage[2];
		player_left = new BufferedImage[3];
		player_right = new BufferedImage[3];
		player_player = new BufferedImage[2];
		
		
		player_up[0] = sheet2.crop(0, height*2, width, height);
		player_up[1] = sheet2.crop(width*2, height*2, width, height);
		
		player_down[0] = sheet2.crop(0, height*4, width, height);
		player_down[1] = sheet2.crop(width*2, height*4, width, height);

		
		player_left[0] = sheet2.crop(0, height, width, height);
		player_left[1] = sheet2.crop(width, height, width, height);
		player_left[2] = sheet2.crop(width*2, height, width, height);
		
		
		player_right[0] = sheet2.crop(0, height*3, width, height);
		player_right[1] = sheet2.crop(width, height*3, width, height);
		player_right[2] = sheet2.crop(width*2, height*3, width, height);
		
		player_player[0] = sheet2.crop(0, 0, width, height);
		player_player[1] = sheet2.crop(width, 0, width, height);
		
		}
}
