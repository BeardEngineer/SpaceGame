
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;




public class Player extends ShipGameObjects {
	private static BufferedImage playerImg;
	private Handler handler;
	
	public Player(int x, int y, int hp, ID id, int score, Handler handler)  {
		super(x, y, hp, score, id);
		this.handler = handler;
	
		
			try {
				playerImg   = ImageIO.read(new File("src/images/player.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		
	}
	
	public Rectangle spriteBounds(){
		return new	Rectangle(x,y,50,50);
		
	}


	

	public void update() {
		x += dx;
		y += dy;
		
		if(x<=0 || x >= SpaceGame.WIDTH -125) 
		{
		  dx*=-1;
		}
		if(y<=0 || y >= SpaceGame.HEIGHT- 100)
		{
			dy*=-1;
		}
		
	
		
		

	

	}
	public void render(Graphics g){
		
		g.drawImage(playerImg,x, y, playerImg.getWidth(), playerImg.getHeight(), null);
		
		
		
	}
	public static BufferedImage getImg() {
		return playerImg;
	}
	public void setImg(BufferedImage img) {
		playerImg = img;
	}
	
	
	
		
}	


