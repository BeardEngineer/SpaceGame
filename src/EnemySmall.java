
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemySmall extends ShipGameObjects{
	private static BufferedImage smallImg;
	//private BufferedImage explosion;
	private Handler handler;
	
	public EnemySmall(int x, int y, int hp,ID id, int score, Handler handler) {
		super(x, y, hp,score, id);
		this.handler =handler;
		
		
		// TODO Auto-generated constructor stub
		try {
			smallImg   = ImageIO.read(new File("src/images/enemySmall.png"));
			//explosion = ImageIO.read(new File("src/images/ex.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//dx =1;
		dy=5;
		
	}

	
	public void update() {
		x += dx;
		y += dy;
		
			
		if(x<=0 || x >= SpaceGame.WIDTH- 150) 
			{
			  dx*=-1;
			}
		if (y >= SpaceGame.HEIGHT)
		{
			dy*= -6;
			dx*= 1;
		}
		
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			ShipGameObjects tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.EnemySmall )
			{
				if(tempObject.getY() >= SpaceGame.HEIGHT+200)
				{
					handler.object.remove(tempObject);
				}
			}
			
		
	    }
		
		
	}
	public Rectangle spriteBounds(){
		
		
		return new	Rectangle(x,y,50,50);
		
	}
	

	public void render(Graphics g) {
		
		if(isVisible() == true)
		{
		 g.drawImage(smallImg,x, y, smallImg.getWidth(), smallImg.getHeight(), null);
		 
	
		 
		}else if(isVisible() == false)
		{
			g.finalize();
		}
		
	}

	public static BufferedImage getImg() {
		return smallImg;
	}
	public void setImg(BufferedImage img) {
		smallImg = img;
	}
	
	
}
