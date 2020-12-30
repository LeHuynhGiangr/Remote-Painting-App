import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

public class PolyLine extends Shape{
	private List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	@Override
	public boolean IsOnThisShape(int x, int y) {
		// TODO Auto-generated method stub
		for(Point p : points) {
			float d=(float) Math.sqrt(Math.pow(x-p.x, 2)+Math.pow(y-p.y, 2));
			if (d<=20) return true;
		}
		return false;
	}

	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.setStroke(new BasicStroke(this.getStroke(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		int n=points.size();
		int[]xs =new int[n];
		int[]ys =new int[n];
		int i=0;
		for(;i<n;i++) {
			xs[i]=(int) points.get(i).getX();
			ys[i]=(int) points.get(i).getY();
		}
		g.drawPolyline(xs, ys, n);
	}
	
	@Override
	public void Move(int x, int y) {
		for(Point p : points) {
			p.x+=x;
			p.y+=y;
		}
	}
}
