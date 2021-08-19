import java.awt.Graphics;
import java.awt.Rectangle;
public abstract class ShipGameObjects {
	
	protected int x, y, w, h;
	protected ID id;
	protected int dx, dy; // velocity
	protected boolean visible = true;
	protected boolean death;
	protected int hp;
	
	
	public int score = 0;
	
	public ShipGameObjects(int x, int y,int hp, int score, ID id)
	{
		this.score =score;
		this.hp =hp;
		this.x =x;
		this.y = y;
		this.id = id;
	}
	public abstract void update();
	public abstract Rectangle spriteBounds();
	
	public abstract void render(Graphics g);
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public boolean isVisible() {
		return visible;
	}
	public  void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isDeath() {
		return death;
	}
	public void setDeath(boolean death) {
		this.death = death;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
}
