	import java.awt.Graphics2D;

public class Circle extends Shape{
	private int radius=0;
	
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		
		this.radius = radius;
	}

	@Override
	public boolean IsOnThisShape(int x, int y) {
		float d=(float) Math.sqrt(Math.pow(x-(getxLocation()+radius), 2)+Math.pow(y-(getyLocation()+radius), 2));
		return d<=radius;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.fillOval(getxLocation(), getyLocation(),radius*2, radius*2);
	}

}
