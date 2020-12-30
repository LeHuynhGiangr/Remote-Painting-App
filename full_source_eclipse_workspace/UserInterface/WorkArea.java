import java.awt.Color;
import javax.swing.JPanel;

public class WorkArea extends JPanel{
	private MyCanvas canvas;

	public WorkArea(int width, int height) {
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		//this.setLocation(20, 20);
		canvas=new MyCanvas();
		canvas.setSize(800, 500);
		canvas.setLocation(10,10);
		
		this.add(canvas);
		MyMenuBar.setMyCanvas(canvas);
	}
	public MyCanvas getCanvas() {
		return canvas;
	}
}
