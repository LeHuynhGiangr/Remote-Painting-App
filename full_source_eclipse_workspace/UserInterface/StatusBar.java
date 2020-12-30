import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusBar extends JPanel{
	private int xSize;
	private int ySize;
	
	private final String buffString="          |          ";

	private static JLabel objectLabel;
	private static JLabel locationXLabel;
	private static JLabel locationYLabel;
	private static JLabel sizeXLabel;
	private static JLabel sizeYLabel;
	private static JLabel angleLabel;
	private static JLabel levelLabel;
	private static JLabel idlabel;
	private static JLabel isGrouplabel;

	private static String valueObject="object:";
	private static String valueX="coordinate-X:";
	private static String valueY="coordinate-Y:";
	private static String valueWidth="width:";
	private static String valueHeight="height:";
	private static String valueAngle="angle(radian):";
	private static String valueLevel="level:";
	private static String id="id: ";
	private static String group="Group : ";

	public StatusBar(int xSize, int ySize) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setPreferredSize(new Dimension(xSize,ySize));
		//this.setBackground(new Color(40,60,128,255));
		this.add(Box.createGlue());
		objectLabel =new JLabel(valueObject);
		locationXLabel=new JLabel(valueX);
		locationYLabel=new JLabel(valueY);
		sizeXLabel=new JLabel(valueWidth);
		sizeYLabel=new JLabel(valueHeight);
		angleLabel=new JLabel(valueAngle);
		levelLabel=new JLabel(valueLevel);
		idlabel=new JLabel(id);
		isGrouplabel=new JLabel(group);
		this.add(objectLabel);
		this.add(new JLabel(buffString));
		
		this.add(locationXLabel);
		this.add(new JLabel(buffString));
		
		this.add(locationYLabel);
		this.add(new JLabel(buffString));
		
		this.add(sizeXLabel);
		this.add(new JLabel(buffString));
		
		this.add(sizeYLabel);
		this.add(new JLabel(buffString));
		
		this.add(angleLabel);
		this.add(new JLabel(buffString));
		
		this.add(levelLabel);
		this.add(new JLabel(buffString));
		
		this.add(idlabel);
		this.add(new JLabel(buffString));
		
		this.add(isGrouplabel);
		this.add(new JLabel(buffString));
		}

	public static void setInfor(String object, int x, int y, int level, int maxLevel,int IDlabel,Boolean isgroup) {
		objectLabel.setText(valueObject+object);
		locationXLabel.setText(valueX+x);
		locationYLabel.setText(valueY+y);
		levelLabel.setText(valueLevel+level+"/"+maxLevel);
		idlabel.setText(id+IDlabel);
		isGrouplabel.setText(group+isgroup);
	}
}
