import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class Triangle extends Shape{
	private int desX=0;
	private int desY=0;
	public int getDesX() {
		return desX;
	}

	public void setDesX(int desX) {
		this.desX = desX;
	}

	public int getDesY() {
		return desY;
	}

	public void setDesY(int desY) {
		this.desY = desY;
	}
	@Override
	public boolean IsOnThisShape(int x, int y) {
		if(x<this.getxLocation()) return false;
		if(x>(this.getxLocation()+desX)) return false;
		
		if(y<this.getyLocation()) return false;
		if(y>(this.getyLocation()+desY)) return false;
		return true;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.setStroke(new BasicStroke(this.getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.rotate(getAnpha(),getxLocation()+(float)getDesX()/2,getyLocation()+(float)getDesY()/2);
		g.drawLine(getxLocation(), getyLocation(), desX, desY);
		g.drawLine(getxLocation(), getyLocation(), getxLocation(), desX/3);
		g.drawLine(desX, desY, getxLocation(), desX/3);

		g.rotate(-getAnpha(),getxLocation()+(float)getDesX()/2,getyLocation()+(float)getDesY()/2);		
	}

}
