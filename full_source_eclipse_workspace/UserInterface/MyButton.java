import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyButton extends JButton{
	
	//button with icon
	public MyButton(int xSize, int ySize, String iconPath) {
		this.setBackground(new Color(30,28,28,255));
		this.setBorder(BorderFactory.createEmptyBorder(2,1,2,1));
		this.setIcon(new ImageIcon(ReSizeImg(iconPath, xSize,ySize)));
	}
	public MyButton(String actionCommand, int xSize, int ySize, String iconPath,ActionListener action) {
		this.setBackground(new Color(30,28,28,255));
		this.setBorder(BorderFactory.createEmptyBorder(2,1,2,1));
		this.setIcon(new ImageIcon(ReSizeImg(iconPath, xSize,ySize)));
		this.setActionCommand(actionCommand);
		this.addActionListener(action);
	}
	
	//button without icon
	public MyButton(String title, Color packgroundColor) {
		this.setText(title);
		this.setBackground(packgroundColor);
		this.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
	}
	public MyButton(String actionCommand, String title, Color packgroundColor, ActionListener action) {
		this.setText(title);
		this.setBackground(packgroundColor);
		this.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		this.setActionCommand(actionCommand);
		this.addActionListener(action);
	}
	
	//without below method, icon cannot resize
	public static Image ReSizeImg(String path, int newWidth, int newHeight) {
		ImageIcon iconClose=new ImageIcon(path);
		Image image=iconClose.getImage();
		Image newImg=image.getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH);
		return newImg;
	}
}
