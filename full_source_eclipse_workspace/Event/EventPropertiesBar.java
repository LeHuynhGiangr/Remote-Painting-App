import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JScrollBar;

public class EventPropertiesBar extends JFrame implements ActionListener, AdjustmentListener{
	private static Color color=Color.BLACK;
	private static int thickness=1;
	private static int anpha=255;
	private static int red=1;
	private static int green=1;
	private static int blue=1;
	public static int flag=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PropertiesBar.group.setVisible(false);
		switch (e.getActionCommand()) {
		case "color":
			Color color=JColorChooser.showDialog(this,"Select a color",Color.RED);  
			this.color=color;
			break;
		case "white":
			this.color=Color.WHITE;
			break;
		case "black":
			this.color=Color.BLACK;
			break;
		case "red":
			this.color=Color.RED;
			break;
		case "orange":
			this.color=Color.ORANGE;
			break;
		case "yellow":
			this.color=Color.YELLOW;
			break;
		case "green":
			this.color=Color.GREEN;
			break;
		case "blue":
			this.color=Color.BLUE;
			break;
		case "pink":
			this.color=Color.PINK;
			break;
		case "gray":
			this.color=Color.GRAY;
			break;
		case "group":
			PropertiesBar.group.setVisible(true);
			Shape tempShape=EventWorkArea.myCanvas.getShapes().get(EventWorkArea.myCanvas.shapeSelected);
			EventWorkArea.myCanvas.getShapes().get(EventWorkArea.myCanvas.shapeSelected).setGroup(!tempShape.getGroup());
			PropertiesBar.ShowGroup(tempShape.getGroup());
			this.flag=1;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
		
		this.red=this.color.getRed();
		this.green=this.color.getGreen();
		this.blue=this.color.getBlue();
		PropertiesBar.show(thickness, anpha, this.color.getRed(), this.color.getGreen(), this.color.getBlue());
	}
	
	public static Color getColor() {
		return color;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		JScrollBar source=(JScrollBar)e.getSource();
		JScrollBar k1=PropertiesBar.thicknessScrollBar;
		JScrollBar k2=PropertiesBar.anphaScrollBar;
		JScrollBar k3=PropertiesBar.redScrollBar;
		JScrollBar k4=PropertiesBar.greenScrollBar;
		JScrollBar k5=PropertiesBar.blueScrollBar;
		if(source==k1) {
			this.thickness=e.getValue();
		}else if(source==k2) {
			this.anpha=255-e.getValue();
		}else if(source==k3) {
			this.red=e.getValue();
		}else if(source==k4) {
			this.green=e.getValue();
		}else if(source==k5) {
			this.blue=e.getValue();
		}
		this.color=new Color(red, green, blue, anpha);
		PropertiesBar.show(thickness, anpha, red, green, blue);
	}
}
