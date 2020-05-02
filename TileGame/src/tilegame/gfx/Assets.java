package tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int WIDTH = 100, HEIGHT = 100;
	
	public static BufferedImage wood, plants, sky, stone, player;
	
	public static void init() 
	{
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		wood = sheet.crop(0, 0, WIDTH, HEIGHT);
		plants = sheet.crop(WIDTH, 0, WIDTH, HEIGHT);
		sky = sheet.crop(WIDTH * 2, 0, WIDTH, HEIGHT);
		stone = sheet.crop(0 , HEIGHT, WIDTH, HEIGHT);
		
		player = ImageLoader.loadImage("/textures/player.jpg");
		
	}
}
