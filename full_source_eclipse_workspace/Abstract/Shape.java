import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.Serializable;


public abstract class Shape implements IShapeMove, IShapeRotation, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xLocation;
	private int yLocation;
	private float anpha;
	private int stroke=1;
	private Color color;
	private int id;
	private boolean isGroup=false;
	public Shape() {
		
	}
	public Shape(int xLocation, int yLocation, Color color,int id,Boolean isGroup) {
		this.xLocation=xLocation;
		this.yLocation=yLocation;
		anpha=0;
		this.color=color;
		this.id = id;
		//this.isGroup = isGroup;
	}
	public Boolean getGroup() {
		return isGroup;
	}
	public void setGroup(Boolean isGroup) {
		this.isGroup = isGroup;
	}
	//
	public int getId() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	//
	public int getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	//
	public int getyLocation() {
		return yLocation;
	}
	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	//
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getStroke() {
		return stroke;
	}
	public void setStroke(int stroke) {
		this.stroke=stroke;
	}
	//
	public float getAnpha() {
		return anpha;
	}
	public void setAnpha(float anpha) {
		this.anpha = anpha;
	}
	public abstract boolean IsOnThisShape(int x, int y);
	
	public abstract void Draw(Graphics2D g);
	
	@Override
	public void Move(int x, int y) {
		this.setxLocation(getxLocation()+x);
		this.setyLocation(getyLocation()+y);
	}
	@Override
	public void Rotate(float anpha) {
		this.setAnpha(getAnpha()+anpha);
	}
}
