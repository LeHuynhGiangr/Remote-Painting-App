import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	private String title="RemoteDraw";
	
	
	private final Dimension windowDimension=new Dimension(1050,600);
	public MainWindow() {
		Initial();
		
		this.add(new MyMenuBar(getxSize()/20, getySize()), BorderLayout.WEST);
		this.add(new MyToolBar(getxSize(), getySize()/16), BorderLayout.NORTH);
		this.add(new MyTableColor(getxSize()/10,getySize()), BorderLayout.EAST);
		this.add(new WorkArea(800, 500));
		Display();
	}
	private void Initial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(this.windowDimension);
		setLayout(new BorderLayout());
		setTitle(title);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void Display() {
		this.setVisible(true);
	}
	
	private int getxSize() {
		return this.getSize().width;
	}
	private int getySize() {
		return this.getSize().height;
	}
}
