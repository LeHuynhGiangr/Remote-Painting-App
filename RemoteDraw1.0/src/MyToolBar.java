import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyToolBar extends JPanel{
	private int xSize;
	private int ySize;
	public MyToolBar(int xSize, int ySize) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(30,28,28,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		this.xSize=xSize;
		this.ySize=ySize;
		
		this.AddButton();
	}
	private void AddButton() {
		this.add(new MyButton("undo" ,getySize(), getySize(), "image/undo.png"));
		this.add(new MyButton("redo", getySize(), getySize(), "image/redo.png"));
		this.add(new MyButton("move", getySize(), getySize(), "image/move.png"));
		this.add(new MyButton("remove", getySize(), getySize(), "image/remove.png"));
		this.add(new MyButton("pencil", getySize(), getySize(), "image/pencil.png"));
		this.add(new MyButton("line", getySize(), getySize(), "image/line.png"));
		this.add(new MyButton("rectangle",getySize(), getySize(), "image/rectangle.png"));
		this.add(new MyButton("circle", getySize(), getySize(), "image/circle.png"));
		this.add(new MyButton("triangle",getySize(), getySize(), "image/triangle.png"));
		this.add(new MyButton("elipse",getySize(), getySize(), "image/elipse.png"));
		
		this.add(Box.createGlue());
		
		this.add(new MyButton("network",getySize(), getySize(), "image/network.png"));
	}
	private int getxSize() {
		return xSize;
	}
	private int getySize() {
		return ySize;
	}
	
}
