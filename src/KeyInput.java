import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KeyInput extends KeyAdapter {
	private Handler handler;

	
	
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	//what happens when our keys are pressed
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		
		
		for(int i = 0; i < handler.object.size(); i ++) //moves through our linked list
		{
			ShipGameObjects tempObject = handler.object.get(i); //creates a temporary object to store our objects at the index position
			
			if(tempObject.getId() == ID.Player){  //condition that checks if our enum ID of the object is our player 
				
			//manupulates the tempObject based on our keypresses
				if(key == KeyEvent.VK_W)
					{
					tempObject.setDy(-10); //moves player upward by changing velocity 
					}
				if(key == KeyEvent.VK_S) 
					{
					tempObject.setDy(10);//moves player left by changing velocity 
					}
				if(key == KeyEvent.VK_D)
					{
					tempObject.setDx(10);//moves player right by changing velocity 
					}
				if(key == KeyEvent.VK_A) 
					{
					tempObject.setDx(-10);//moves player left by changing velocity 
					}
				if(key == KeyEvent.VK_SPACE) //adds a shot to your linked list when pressed
					{
				   
					
				
						try {
							Thread.sleep(200);
							handler.addObject(new Shots(tempObject.getX()+100,tempObject.getY(), 25, ID.Shot, 0, handler));
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					
				    }
			}
		}
	}
	
	
	//what happens when our keys are released
	public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
		
	
	
		for(int i = 0; i < handler.object.size(); i ++)
		{
			ShipGameObjects tempObject = handler.object.get(i);
			
			//all these inputs set our move to none when keys are released
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W)
					{
					tempObject.setDy(0);
					}
				if(key == KeyEvent.VK_S) 
					{
					tempObject.setDy(0);
					}
				if(key == KeyEvent.VK_D)
					{
					tempObject.setDx(0);
					}
				if(key == KeyEvent.VK_A) 
					{
					tempObject.setDx(0);
					}
			}
		}
	}
	
}
