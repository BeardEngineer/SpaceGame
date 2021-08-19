import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyShots extends ShipGameObjects{

	
	private BufferedImage enemyShot;
	private Handler handler;
	public EnemyShots(int x, int y, int hp, int score, ID id, Handler handler) {
		super(x, y, hp, score, id);
		this.handler =handler;
		// TODO Auto-generated constructor stub
		
		try{
			enemyShot = ImageIO.read(new File("src/images/EnemyProjectile2.png"));
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		dy =+ 25;
	}

	@Override
	public void update() {
		 x += dx;
		 y += dy;
		
	}

	@Override
	public Rectangle spriteBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 50, 50);
	}

	@Override
	public void render(Graphics g) {
		 if(isVisible() == true)
		  {
			g.drawImage(enemyShot,getX(), getY(), enemyShot.getWidth(), enemyShot.getHeight(), null);
			
			
		  }else if(isVisible() == false)
		  {
			  g.finalize();
			  g.dispose();
		  }
		
	}

}
