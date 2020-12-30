import java.awt.Graphics2D;

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
		g.setColor(getColor());
		g.fillRect(getxLocation(), getyLocation(),width, height);
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
