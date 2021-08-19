import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	//our data structure, LinkedList
	LinkedList<ShipGameObjects> object = new LinkedList<ShipGameObjects>();
	
	//moves through our linked list, and calls update for all current objects
	public void update() {
		for(int i = 0; i <object.size(); i++)
		{
			ShipGameObjects tempObject = object.get(i);
			
			tempObject.update();
		}
	}
	
	//moves through our linked list and calls render for all current objects
	public void render(Graphics g)
	{
		for(int i = 0; i <object.size(); i++){
			ShipGameObjects tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	//adds objects to our linked list
	public void addObject(ShipGameObjects object)
	{
		this.object.add(object);
	}
	//removes objects from our linked list
	public void removeObject(ShipGameObjects object){
		this.object.remove(object);
	}
	
}
