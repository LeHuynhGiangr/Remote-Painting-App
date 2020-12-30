import java.awt.Color;
import java.awt.Graphics2D;


public abstract class Shape implements IShapeMove{
	private int xLocation;
	private int yLocation;
	

	private Color color;
	
	public Shape() {
		
	}
	public Shape(int xLocation, int yLocation, Color color) {
		this.xLocation=xLocation;
		this.yLocation=yLocation;
		this.color=color;
	}
	
	public int getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	public int getyLocation() {
		return yLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public abstract boolean IsOnThisShape(int x, int y);
	
	public abstract void Draw(Graphics2D g);
	
	@Override
	public void Move(int x, int y) {
		this.setxLocation(getxLocation()+x);
		this.setyLocation(getyLocation()+y);
	}
}
