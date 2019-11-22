import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class WorkArea extends JPanel{
	private MyCanvas canvas;

	public WorkArea(int width, int height) {
		this.setLayout(null);
		this.setBackground(Color.lightGray);
		
		canvas=new MyCanvas();
		canvas.setSize(width,height);
		canvas.setLocation(10, 10);
		canvas.setBackground(Color.white);
		
		this.add(canvas);
	}
	public MyCanvas getCanvas() {
		return canvas;
	}
}
