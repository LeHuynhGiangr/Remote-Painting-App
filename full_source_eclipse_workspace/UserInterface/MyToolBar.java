import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class MyToolBar extends JPanel{
	private int xSize;
	private int ySize;
	public MyToolBar(int xSize, int ySize, ActionListener action) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(new Color(30,28,28,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		this.xSize=xSize;
		this.ySize=ySize;
		
		this.AddButton(action);
	}
	private void AddButton(ActionListener action) {
		this.add(new MyButton("undo" ,getySize(), getySize(), "image/undo.png",action));
		this.add(new MyButton("redo", getySize(), getySize(), "image/redo.png",action));
		this.add(new MyButton("move", getySize(), getySize(), "image/move.png",action));
		this.add(new MyButton("rotate", getySize(), getySize(), "image/rotate.png",action));
		this.add(new MyButton("remove", getySize(), getySize(), "image/remove.png",action));
		this.add(new MyButton("fillColor",getySize(), getySize(), "image/fillColor.png",action));
		this.add(new MyButton("pencil", getySize(), getySize(), "image/pencil.png",action));
		this.add(new MyButton("line", getySize(), getySize(), "image/line.png",action));
		this.add(new MyButton("rectangle",getySize(), getySize(), "image/rectangle.png",action));
		this.add(new MyButton("circle", getySize(), getySize(), "image/circle.png",action));
		this.add(new MyButton("triangle",getySize(), getySize(), "image/triangle.png",action));
		this.add(new MyButton("elipse",getySize(), getySize(), "image/elipse.png",action));	
		this.add(new MyButton("text",getySize(), getySize(), "image/text.png",action));		

		this.add(Box.createGlue());
		
		this.add(new MyButton("network",getySize(), getySize(), "image/network.png",action));
	}
	private int getxSize() {
		return xSize;
	}
	private int getySize() {
		return ySize;
	}
	
}
