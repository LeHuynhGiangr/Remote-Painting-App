import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyMenuBar extends JPanel{
	public MyMenuBar(int xSize, int ySize) {
		this.setBackground(new Color(70,130,180,255));
		this.setPreferredSize(new Dimension(xSize, ySize));
		this.add(CreateMenu());
	}
	private JMenuBar CreateMenu() {
		JMenuBar menuBar=new JMenuBar();
		menuBar.setLayout(new GridLayout(15,1));
		//
		JMenu menuFile, menuEdit ,menuMode, menuHelp;
		menuFile=new JMenu("File");
		menuEdit=new JMenu("Edit");
		menuMode=new JMenu("Mode");
		menuHelp=new JMenu("Help");
		menuHelp.setBackground(new Color(0,0,0,0));
		//
		JMenuItem itemFileNew, itemFileOpen, itemFileSave;
		JMenuItem itemEditUndo, itemEditRedo;
		itemFileNew=new JMenuItem("New File");
		itemFileOpen=new JMenuItem("Open File");
		itemFileSave=new JMenuItem("Save");
		itemEditUndo=new JMenuItem("Undo");
		itemEditRedo=new JMenuItem("Redo");
		//
		menuFile.add(itemFileNew);menuFile.add(itemFileOpen);menuFile.add(itemFileSave);
		menuEdit.add(itemEditUndo);menuEdit.add(itemEditRedo);
		menuHelp.add(new JMenuItem("0383990754 or Email:17110128student.hcmute.edu.vn"));
		//
		menuBar.add(menuFile);menuBar.add(menuEdit);
		menuBar.add(menuMode);
		menuBar.add(menuHelp);
		menuBar.setBackground(new Color(0,0,0,0));
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		//
		return menuBar;
	}
}
