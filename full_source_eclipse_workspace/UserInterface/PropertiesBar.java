import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class PropertiesBar extends JPanel{
	public static Color color=Color.BLACK;
	public static int thickness=1;
	public static JLabel showLabel=new JLabel();
	public static JTextField textField;
	
	static JScrollBar thicknessScrollBar;
	static JScrollBar anphaScrollBar;
	static JScrollBar redScrollBar;
	static JScrollBar greenScrollBar;
	static JScrollBar blueScrollBar;
	static JRadioButton isgroupRadioButton;
	public static MyButton group;
	public static Color getColor() {
		return color;
	}
	public static int getStroke() {
		return thickness;
	}
	public static JTextField getText() {
		return textField;
	}
	public static void setThickness(int thickness) {
		PropertiesBar.thickness = thickness;
	}
	public PropertiesBar(int xSize, int ySize, ActionListener action) {
		this.setLayout(null);
		this.setBackground(new Color(105,105,105,255));
		this.setPreferredSize(new Dimension(xSize,ySize));
		
		MyButton colButton=new MyButton("color" ,20,20, "image/color.png",action);
		MyButton white=new MyButton("white","    ", Color.WHITE, action);
		MyButton black=(new MyButton("black", "    ", Color.BLACK, action));
		MyButton red=(new MyButton("red", "    ", Color.RED, action));
		MyButton orange=(new MyButton("orange", "    ", Color.ORANGE, action));
		MyButton yellow=(new MyButton("yellow", "    ", Color.YELLOW, action));
		MyButton green=(new MyButton("green", "    ", Color.GREEN, action));
		MyButton blue=(new MyButton("blue", "    ", Color.BLUE, action));
		MyButton pink=(new MyButton("pink", "    ", Color.PINK, action));
		MyButton gray=(new MyButton("gray", "    ", Color.GRAY, action));
		group=(new MyButton("group", "Add Group", Color.GREEN, action));
		group.setVisible(false);
		//show color
		
		JLabel thicknessLabel=new JLabel("Thickness");
		thicknessLabel.setPreferredSize(new Dimension(60,15));
		
		JLabel anphaLabel=new JLabel("Anpha");anphaLabel.setPreferredSize(new Dimension(60,15));
		
		JLabel redLabel=new JLabel("Red");redLabel.setPreferredSize(new Dimension(60,15));
		
		JLabel greenLabel=new JLabel("Green");greenLabel.setPreferredSize(new Dimension(60,15));
		
		JLabel blueLabel=new JLabel("Blue");blueLabel.setPreferredSize(new Dimension(60,15));
		JLabel textLabel=new JLabel("TEXT  ");redLabel.setPreferredSize(new Dimension(60,15));

		
		thicknessScrollBar=new JScrollBar(Adjustable.HORIZONTAL, 1, 1, 1, 10);
		thicknessScrollBar.setPreferredSize(new Dimension(150, 15));
		thicknessScrollBar.setName("thickness");
	    thicknessScrollBar.addAdjustmentListener((AdjustmentListener) action);
	    
	    //anpha
		anphaScrollBar=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		anphaScrollBar.setPreferredSize(new Dimension(150, 15));
		anphaScrollBar.setName("anpha");
	    anphaScrollBar.addAdjustmentListener((AdjustmentListener) action);
	    
	    //red
	    redScrollBar=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		redScrollBar.setPreferredSize(new Dimension(150, 15));
		redScrollBar.setName("red");
	    redScrollBar.addAdjustmentListener((AdjustmentListener) action);
	    
	    //green
	    greenScrollBar=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		greenScrollBar.setPreferredSize(new Dimension(150, 15));
		greenScrollBar.setName("green");
	    greenScrollBar.addAdjustmentListener((AdjustmentListener) action);
	    
	    //blue
	    blueScrollBar=new JScrollBar(Adjustable.HORIZONTAL, 0, 0, 0, 255);
		blueScrollBar.setPreferredSize(new Dimension(150, 15));
		blue.setName("blue");
	    blueScrollBar.addAdjustmentListener((AdjustmentListener) action);
	    textField =new JTextField();
	    textField.setEnabled(false);
		textField.setPreferredSize(new Dimension(150, 20));

	    
	    JPanel panel1=new JPanel();
	    panel1.setLocation(0, 0);
	    panel1.setSize(300, 40);
	    panel1.add(red);
	    panel1.add(orange);
	    panel1.add(yellow);
	    panel1.add(green);
	    panel1.add(pink);
	    panel1.add(gray);
	    panel1.add(blue);
	    panel1.add(black);
	    panel1.add(white);
	    panel1.add(colButton);
	    
	    
	    JPanel panel2=new JPanel();
	    panel2.setLocation(0, 40);
	    panel2.setSize(300, 40);
	    panel2.add(thicknessLabel);
	    panel2.add(thicknessScrollBar);
	    this.add(panel2);
	    
	    JPanel panel3=new JPanel();
	    panel3.setLocation(0, 80);
	    panel3.setSize(300, 40);
	    panel3.add(anphaLabel);
	    panel3.add(anphaScrollBar);
	    
	    JPanel panel4=new JPanel();
	    panel4.setLocation(0, 120);
	    panel4.setSize(300, 40);
	    panel4.add(redLabel);
	    panel4.add(redScrollBar);
	    
	    JPanel panel5=new JPanel();
	    panel5.setLocation(0, 160);
	    panel5.setSize(300, 40);
	    panel5.add(greenLabel);
	    panel5.add(greenScrollBar);
	    
	    JPanel panel6=new JPanel();
	    panel6.setLocation(0, 200);
	    panel6.setSize(300, 40);
	    panel6.add(blueLabel);
	    panel6.add(blueScrollBar);
	    
	    JPanel panel7=new JPanel();
	    panel7.setLocation(0, 240);
	    panel7.setSize(300,40);
	    showLabel.setFont(new Font("TimesRoman", Font.BOLD, 25));
	    showLabel.setText("ARGB("+(255-anphaScrollBar.getValue())+", "+redScrollBar.getValue()+", "+greenScrollBar.getValue()+", "+blueScrollBar.getValue()+")");
	    showLabel.setForeground(new Color(redScrollBar.getValue(), greenScrollBar.getValue(), blueScrollBar.getValue(), 255-anphaScrollBar.getValue()));
	    panel7.add(showLabel);
	    
	    JPanel panel8=new JPanel();
	    panel8.setLocation(0, 280);
	    panel8.setSize(300,40);
	    panel8.add(textLabel);
	    panel8.add(textField);

	    JPanel panel9=new JPanel();
	    panel9.setLocation(0, 320);
	    panel9.setSize(300,40);
	    panel9.add(group);
	    
	    
	    this.add(panel1);
	    this.add(panel2);
	    this.add(panel3);
	    this.add(panel4);
	    this.add(panel5);
	    this.add(panel6);
	    this.add(panel7);
	    this.add(panel8);
	    this.add(panel9);


	}
	public static void show(int thickn, int anpha, int red, int green, int blue) {
		thickness=thickn;
		showLabel.setText("ARGB("+anpha+", "+red+", "+green+", "+blue+")");
		showLabel.setForeground(new Color(red, green, blue, anpha));
	}
	public static void ShowGroup(boolean b) {
		group.setBackground(b?Color.RED:Color.GREEN);
		group.setText(b?"remove from group":"add to group");
	}
}
