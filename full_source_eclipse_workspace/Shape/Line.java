import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Base64;

public class Line extends Shape{
	private int desX=getxLocation();
	private int desY=getyLocation();
	//private int stroke=1;
	
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
		//g.setStroke(new BasicStroke(PropertiesBar.getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setStroke(new BasicStroke(this.getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.setColor(this.getColor());
		g.drawLine(getxLocation(), getyLocation(),desX, desY);
	}
	
}
