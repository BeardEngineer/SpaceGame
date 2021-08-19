/**
 * Program: Space Game
 * Author: Jarred Nord
 * This program back-end functionality was created with the help of RealTutsGML tutorials
 * artwork was taken from https://itch.io/game-assets/free 
 */

import java.awt.Canvas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class SpaceGame extends Canvas implements Runnable {

		
	
		
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -3830162194717595087L; //requirement for Runnable, this has to do with the scheduler
	
	
	
		
		public static final int WIDTH = 1250, HEIGHT = WIDTH/12*9 ;
		Random rand = new Random();
		public int score =400000;
		private Thread thread; //declares our thread, this helps our program multitask
		private boolean running =false; //boolean to tell if our game is running
		private static BufferedImage background;
		private static int trackLarge =0;
		public int scoreUpdate =0;
		
		
		
		private Handler handler;  //this declares our handler class
		
		
		
		
		@SuppressWarnings("static-access")
		public SpaceGame() throws IOException{
			handler = new Handler();
			background = ImageIO.read(new File("src/images/background.png"));
			this.addKeyListener(new KeyInput(handler));
			new Board(WIDTH,HEIGHT, "SpaceGame", this); //calls and creates our game Window
			
			handler.addObject(new Player(WIDTH/2 -32,HEIGHT/2-32, 200, ID.Player, -80, handler)); //creates our player object at the x,y coordinates
			
		
			
			scoreUpdate = score;
			do{
		
				
				if(scoreUpdate>=0)
				{
			
			
					try {
						thread.sleep(600);
						handler.addObject(new EnemySmall(rand.nextInt(WIDTH)-100,0, 100, ID.EnemySmall, 100, handler));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
						
							
				}
				if(scoreUpdate > 5000)
				{
			
				
					handler.addObject(new EnemyMedium(rand.nextInt(WIDTH),0, 500, 500, ID.EnemyMedium));	
			
			
			
			
				}
					
				
				 if(scoreUpdate> 10000)
				 { 
				  
					 	if(trackLarge < 1)
					 	{	
						 handler.addObject(new EnemyLarge(600,0, 2000, ID.EnemyLarge, 1000));
					 	}
							 
							
							for(int i =0; i < handler.object.size(); i++)
							{
								ShipGameObjects tempObject = handler.object.get(i);
							
								if(tempObject.getId() == ID.EnemyLarge)
								{
									int newX;
									int newY;
									newX =tempObject.getX();
									newY = tempObject.getY();
									
									
									
									 handler.addObject(new EnemyShots(newX +145,newY+115, 50, 0, ID.EnemyShots, handler));
									
									
								}
								
							}
						trackLarge++;
				}
				 score = Shots.getRealScore();
				//System.out.println("THIS IS THE SCORE" + score);
				}while(running);
			
			
			
			score = Shots.getRealScore();
			System.out.println("THIS IS THE SCORE" + score);
			}
		
		
		
	
		//This Method creates our Thread, then it starts our thread, and enables our boolean to true
		//synchronized locks our thread
		public synchronized void start(){
			thread = new Thread(this); //Initializes thread with THIS instance of our game class
			thread.start(); //starts this instance of our thread by calling our run method
			running = true;
		}
		//this method makes closes our thread using join() and sets our boolean to false
		//needs to be in try/catch. can throw errors on close
		public synchronized void stop(){
			//will try to stop the thread, if i can not happen it will run our trace
			try{
				thread.join();
				running = false;
			}catch(Exception e)
			{
				e.printStackTrace(); //this will print out a trace of any exception that the thread.join() will throw
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			    long startTime = System.nanoTime(); //gets the time at execution and stores it
		        double numberOfUpdates = 60.0; //60 updates per seconds, or 60fps
		        double nanoPerSecond = 1000000000 / numberOfUpdates; //nano seconds per second to get how many seconds have past
		        double delta = 0;  //change in time
		        long timer = System.currentTimeMillis(); //stores the current system time in milliseconds
		        int frames = 0 ; //stores our frame rate
		        
		        //main game loop
		        while(running)
		        {
		                    long now = System.nanoTime(); //stores the current time 
		                    delta += (now - startTime) / nanoPerSecond; //calculates the change in time and sets it to our delta
		                    startTime = now; //our current times overwrites our previous time
		                    
		                    /**
		                     * While 1 update has passed (Stored in Delta) we call update then decrement delta to reset it
		                     * essentially it pauses the loop until another update has passed then it updates rendering the next frame
		                     * 
		                     */
		                    while(delta >=1)  
		                            {
		                                update();
		                                delta--;
		                            }
		                            if(running)
		                            {
		                                render(); //we render everything 
		                               frames++; //increment frame counter
		                            }
		                            
		                            //this simply prints out our frames rate, not necessary for the game to run but helps monitor fps
		                            if(System.currentTimeMillis() - timer > 1000)
		                            {
		                                timer += 1000;
		                                System.out.println("FPS: "+ frames);
		                                frames = 0;
		                            }
		        }
		                stop();
		}
		//this method updates our game, I could of also named this method update()
		private void update(){
			handler.update(); //calls our handler and then updates it based on our update rate in our run() method
			
		}
		
		//draws our graphics
		private void render(){
			
			/**
			 * A bufferStrategy is a smooth way of rendering frames 
			 * It renders how many frames you set at once (3 in this  program)
			 * After frame 1 is done, frame 2 is shown, then after 2 comes 3
			 * 
			 * 
			 *     ***** part of our Canvas class***
			 */
			BufferStrategy buffer = this.getBufferStrategy(); 
			if(buffer == null)
			{
				this.createBufferStrategy(3); //creates our bufferStrategy for our game
				
				return;
			}
			Graphics g = buffer.getDrawGraphics();
			g.drawImage(background,0,0, background.getWidth(), background.getHeight(), null);
			//g.setColor(Color.black);
			//g.fillRect(0, 0, WIDTH, HEIGHT);
			
			
			handler.render(g); //renders our objects
			
			g.dispose(); //gets rid of the resources that g is using
			buffer.show(); //displays our buffer
		}
		
		
		public static int getTrackLarge() {
			return trackLarge;
		}




		public static void setTrackLarge(int trackL) {
			trackLarge = trackL;
		}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new SpaceGame();
	}




	




	

}
