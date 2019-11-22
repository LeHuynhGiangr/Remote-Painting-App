import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JPanel;

public class MyCanvas extends Canvas{
	private List<Shape> shapes;
	private int n;
	public int getNoShape() {
		return n;
	}
	
	private int flagAdd=0;
	
	
	public MyCanvas() {
		shapes=new ArrayList<Shape>();
		this.addMouseListener(new Event());
		this.addMouseMotionListener(new Event());
		Event.setMyCanvas(this);
		n=0;
	}
	
	public void drawShape(Shape shape) {
		remove();
		this.shapes.add(n,shape);
		n++;
		repaint();
		flagAdd=0;
	}
	public void addShape() {
		flagAdd=1;
	}
	public void remove() {
		if(n>=1&&flagAdd==0) {
			this.shapes.remove(n-1);
			n--;
		}
	}
	public void removeLastShape() {
		if(n>=1) {
			this.shapes.remove(n-1);
			repaint();
		}
	}
	
	public int selectShape(int locationX, int locationY) {
		int i=n-1;
		for(;i>=0;i--)
			if(shapes.get(i).IsOnThisShape(locationX, locationY))return i;
		return i;
	}
	public void moveShape(int index, int x, int y) {
		if(index>=0 && index < n) {
			shapes.get(index).Move(x, y);
			repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape: shapes) {
			shape.Draw((Graphics2D)g);
		}
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
}
