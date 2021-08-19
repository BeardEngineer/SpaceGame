
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Board  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Board(int width, int height, String title, SpaceGame space)
	{
		JFrame frame = new JFrame(title);  //Frame of our window
		
		
		frame.setPreferredSize(new Dimension(width, height));  //window dimensions
		frame.setMaximumSize(new Dimension(width, height));  //max size
		frame.setMinimumSize(new Dimension(width, height));  //min size
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //closes the game when clicking X button
		frame.setResizable(false);  //disables resizing the window
		frame.setLocationRelativeTo(null); //makes window start in center of screen
		frame.add(space); // adds our game to our window
		frame.setVisible(true); //sets our frame visible
		space.start(); //starts our game
	}
	
	
}
