import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;

public class MyTableColor extends JPanel{
	
	public MyTableColor(int xSize, int ySize) {
		//this.setLayout();
		this.setBackground(new Color(105,105,105,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		this.AddButton();
	}
	private void AddButton() {
		this.add(new MyButton("white","    ", Color.WHITE));
		this.add(new MyButton("black", "    ", Color.BLACK));
		this.add(new MyButton("red", "    ", Color.RED));
		this.add(new MyButton("orange", "    ", Color.ORANGE));
		this.add(new MyButton("yellow", "    ", Color.YELLOW));
		this.add(new MyButton("green", "    ", Color.GREEN));
		this.add(new MyButton("blue", "    ", Color.BLUE));
		this.add(new MyButton("pink", "    ", Color.PINK));
		this.add(new MyButton("gray", "    ", Color.GRAY));
	}
	private int getxSize() {
		return this.getSize().width;
	}
	private int getySize() {
		return this.getSize().height;
	}
}

