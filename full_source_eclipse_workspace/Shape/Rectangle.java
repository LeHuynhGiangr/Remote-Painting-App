import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Rectangle extends Shape{
	private int width;
	private int height;
	public Rectangle() {
		super();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.rotate(getAnpha(),getxLocation()+(float)getWidth()/2,getyLocation()+(float)getHeight()/2);
		g.fillRect(getxLocation(), getyLocation(),width, height);
		g.rotate(-getAnpha(),getxLocation()+(float)getWidth()/2,getyLocation()+(float)getHeight()/2);
	}
	
	@Override
	public boolean IsOnThisShape(int x, int y) {
		// TODO Auto-generated method stub
		if(x<this.getxLocation()) return false;
		if(x>(this.getxLocation()+width)) return false;
		
		if(y<this.getyLocation()) return false;
		if(y>(this.getyLocation()+height)) return false;
		return true;
	}
	
}
