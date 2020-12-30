import java.awt.Graphics2D;

public class Elipse extends Shape{
	private int radius=0;
	private int height=0;
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		
		this.radius = radius;
	}
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		
		this.height = height;
	}
	@Override
	public boolean IsOnThisShape(int x, int y) {
		float d=(float) Math.sqrt(Math.pow(x-(getxLocation()+height), 2)+Math.pow(y-(getyLocation()+radius), 2));
		if(x<this.getxLocation()) return false;
		if(x>(this.getxLocation()+height)) return false;
		return d<=radius;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.fillOval(getxLocation(), getyLocation(),height, radius*2);
	}
}
