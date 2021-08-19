import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyLarge extends ShipGameObjects {
	private static BufferedImage largeImg;
	private int track = 0;
	
	public EnemyLarge(int x, int y, int hp,ID id, int score) {
		super(x, y, hp, score, id);
		try {
			largeImg   = ImageIO.read(new File("src/images/enemyLarge.png"));
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	 dx = 4;
	}

	@Override
	public void update() {
		x += dx;
		y += dy;
		
		if(x <= 0 || x >= SpaceGame.WIDTH - 32) 
		{
			dx*=-1;
		}
		
				
		
		
	}
	public Rectangle spriteBounds(){
		return new	Rectangle(x,y,100,100);
		
	}

	public void render(Graphics g) {
		
		if(isVisible() ==  true)
		{
			g.drawImage(largeImg,x, y, 400, 400, null);
			
			
		}else if(isVisible() == false)
		{
			g.finalize();
			
		}
	}
   
	
	public static BufferedImage getImg() {
		return largeImg;
	}
	public void setImg(BufferedImage img) {
		largeImg = img;
	}

	public static BufferedImage getLargeImg() {
		return largeImg;
	}

	public static void setLargeImg(BufferedImage largeImg) {
		EnemyLarge.largeImg = largeImg;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	

	

}
