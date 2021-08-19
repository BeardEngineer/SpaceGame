import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyMedium extends ShipGameObjects {
	private static BufferedImage mediumImg;
	
	
	public EnemyMedium(int x, int y, int hp, int score, ID id) {
		super(x, y, hp, score, id);
		
		try {
			mediumImg   = ImageIO.read(new File("src/images/enemyMedium.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dy = 1;
		dx = 1;
		
		
		
	}

	@Override
	public void update() {
		x += dx;
		y += dy;
		
		if(x <= 0 || x >= SpaceGame.WIDTH- 125) 
		{
			dx*=-1;
			
		}
		
	}
	public Rectangle spriteBounds(){
		return new	Rectangle(x,y,220 ,220);
		
	}

	public void render(Graphics g) {
		
		
		
		if(isVisible() == true)
		{
			g.drawImage(mediumImg,x, y, mediumImg.getWidth(), mediumImg.getHeight(), null);
			
		}else if(isVisible() == false)
		{
			g.finalize();
			
		}
	}

	public static BufferedImage getImg() {
		return mediumImg;
	}
	public void setImg(BufferedImage img) {
		mediumImg = img;
	}
}
