import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Shots  extends ShipGameObjects{
	private BufferedImage shotImg;
	//private BufferedImage explosion;
	private Handler handler;
	public static int realScore =0;
	
	public Shots(int x, int y, int hp,ID id, int score, Handler handler) {
		super(x, y, hp, score,id);
		this.handler = handler;
		
		try {
			shotImg   = ImageIO.read(new File("src/images/shot.png"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dy =-25;
	}

	public Rectangle spriteBounds(){
		return new	Rectangle(x-100,y,50,50);
		
	}
	@Override
	public void update() {
	 x += dx;
	 y += dy;
		
	 if(y > SpaceGame.HEIGHT)
	 {
		 setVisible(false);
	 }
	 
	 
	 
	 
	 for(int i =0; i < handler.object.size(); i++)
		{
			ShipGameObjects tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.EnemySmall)
			{
				if(spriteBounds().intersects(tempObject.spriteBounds()))
				{
					tempObject.setVisible(false);
					handler.object.remove(tempObject);
					setVisible(false);
					realScore += tempObject.score;
					tempObject.setDeath(true);
				}
			}
			if(tempObject.getId() == ID.EnemyMedium)
			{
				if(spriteBounds().intersects(tempObject.spriteBounds()) && tempObject.getHp() >0)
				{
					int firstHp = tempObject.getHp();
					setVisible(false);
					tempObject.setHp(firstHp - hp);
				}else if(spriteBounds().intersects(tempObject.spriteBounds()) && tempObject.getHp() == 0)
				{
					tempObject.setVisible(false);
					handler.object.remove(tempObject);
					setVisible(false);
					tempObject.setDeath(true);
					realScore += tempObject.score;
				}
			}
			if(tempObject.getId() == ID.EnemyLarge)
			{
				if(spriteBounds().intersects(tempObject.spriteBounds()) && tempObject.getHp() > 0)
				{
					 
					int firstHp = tempObject.getHp();
					setVisible(false);
					 tempObject.setHp(firstHp -hp);
					 
				
					
					
				}else if(spriteBounds().intersects(tempObject.spriteBounds()) && tempObject.getHp() ==0)
				{
					tempObject.setVisible(false);
					tempObject.setDeath(true);
					
					setVisible(false);
					handler.object.remove(tempObject);
					
					SpaceGame.setTrackLarge(0);
					realScore += tempObject.score;
					
					
					
				}
			
			}
			//if(tempObject.getId() == ID.Shot)
			//{ 
				//if(isVisible() == false)
				//{
				//	handler.object.remove(tempObject);
				//}
			//}
			
		}
	
	 
	
	}
	
	
	public void render(Graphics g){
	
	 
		
	  if(isVisible() == true)
	  {
		g.drawImage(shotImg,getX(), getY(), shotImg.getWidth(), shotImg.getHeight(), null);
		
		
	  }else if(isVisible() == false)
	  {
		  g.finalize();
	  }
	}
	public BufferedImage getImg() {
		return shotImg;
	}
	public void setImg(BufferedImage img) {
		shotImg = img;
	}

	public static int getRealScore() {
		return realScore;
	}

	public void setRealScore(int realScore) {
		this.realScore = realScore;
	}
	
	
}
