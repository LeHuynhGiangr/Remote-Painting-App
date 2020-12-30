import java.awt.Canvas;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Event implements ActionListener, MouseListener, MouseMotionListener{
	public static String command="";
	public static MyCanvas myCanvas;
	public static ConnectWindow connectWindow= new ConnectWindow();
	private static int shapeSlected=-1;
	private static int previousX;
	private static int previousY;
	
	//
	public int getCurrentX() {
		return MouseInfo.getPointerInfo().getLocation().x-myCanvas.getLocationOnScreen().x;
	}
	public int getCurrentY() {
		return MouseInfo.getPointerInfo().getLocation().y-myCanvas.getLocationOnScreen().y;
	}
	//
	

	public static void setMyCanvas(MyCanvas canvas) {
		myCanvas=canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse has clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse has pressed");
		switch (command) {
		case "move":
			shapeSlected=myCanvas.selectShape(getCurrentX(), getCurrentY());
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "rectangle":
			System.out.println(myCanvas.getLocation().x+" "+myCanvas.getLocation().y);
			System.out.println(getCurrentX()+" "+getCurrentY());
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "network":
			break;
		default:
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse has released");
		switch (command) {
		case "move":
			Event.shapeSlected=-1;
			break;
		case "rectangle":
			myCanvas.addShape();
			break;
		case "":
			return;
		default:
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse has entered");
		System.out.println(getCurrentX()+" "+getCurrentY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse has exited");
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse is dragging");
		switch (command) {
		case "move":
			myCanvas.moveShape(shapeSlected,getCurrentX()-previousX,getCurrentY()-previousY);
			System.out.println(getCurrentX()-previousX);
			System.out.println(getCurrentY()-previousY);
			previousX=getCurrentX();
			previousY=getCurrentY();
			break;
		case "rectangle":
			Rectangle rectangle=new Rectangle();
			rectangle.setxLocation(previousX);rectangle.setyLocation(previousY);
			rectangle.setWidth(getCurrentX()-previousX);
			rectangle.setHeight(getCurrentY()-previousY);
			rectangle.setColor(EventTableColor.getColor());
			myCanvas.drawShape(rectangle);
			break;
		default:
			
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(command+"mouse is moving");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "move":
			Event.command="move";
			break;
		case "pencil":
			Event.command="pencil";
			System.out.println("pencil");
			break;
		case "line":
			Event.command="line";
			System.out.println("line");
			break;
		case "rectangle":
			Event.command="rectangle";
			System.out.println("rectangle");
			break;
		case "circle":
			Event.command="circle";
			System.out.println("circle");
			break;
		case "triangle":
			Event.command="triangle";
			System.out.println("triangle");
			break;
		case "elipse":
			Event.command="elipse";
			System.out.println("elipse");
			break;
		case "network":
			System.out.println("hello");
			if(connectWindow.isShowing())connectWindow.Hide();
			else connectWindow.Show(750,100);
			break;
		default:
			
		}
	}

	

}
