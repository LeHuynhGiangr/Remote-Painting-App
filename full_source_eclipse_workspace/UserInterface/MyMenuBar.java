import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MyMenuBar extends JPanel implements ActionListener{
	private JMenuBar menuBar;
	private JMenu menuFile,menuExport,menuMode,menuHelp;
	private JMenuItem itemFileNew, itemFileOpen, itemFileSave;
	private JMenuItem itemExportPng, itemExportJPG;
	public static MyCanvas myCanvas;
	public static void setMyCanvas(MyCanvas canvas) {
		myCanvas=canvas;
	}
	public MyMenuBar(int xSize, int ySize) {
		this.setBackground(new Color(70,130,180,255));
		this.setPreferredSize(new Dimension(xSize, ySize));
		this.add(CreateMenu());
	}
	private JMenuBar CreateMenu() {
		menuBar=new JMenuBar();
		menuBar.setLayout(new GridLayout(15,1));
		//
		menuFile=new JMenu("File");
		menuFile.setMnemonic(KeyEvent.VK_F);
		menuExport=new JMenu("Export");
		menuExport.setMnemonic(KeyEvent.VK_E);
		menuMode=new JMenu("Mode");
		menuMode.setMnemonic(KeyEvent.VK_M);
		menuHelp=new JMenu("Help");
		menuHelp.setMnemonic(KeyEvent.VK_H);
		menuHelp.setBackground(new Color(0,0,0,0));
		//
		
		itemFileNew=new JMenuItem("New File",new ImageIcon(MyButton.ReSizeImg("image/newFile.png", 40, 40)));itemFileNew.setActionCommand("new");
		itemFileOpen=new JMenuItem("Open File",new ImageIcon(MyButton.ReSizeImg("image/openFile.png", 40, 40)));itemFileOpen.setActionCommand("open");
		itemFileSave=new JMenuItem("Save",new ImageIcon(MyButton.ReSizeImg("image/saveFile.png", 40, 40)));itemFileSave.setActionCommand("save");
		itemExportPng=new JMenuItem("To PNG",new ImageIcon(MyButton.ReSizeImg("image/exportPng.png", 60, 60)));itemExportPng.setActionCommand("png");
		itemExportJPG=new JMenuItem("To JPG",new ImageIcon(MyButton.ReSizeImg("image/exportJPG.png", 60, 60)));itemExportJPG.setActionCommand("jpg");
		itemFileNew.addActionListener(this);
		itemFileOpen.addActionListener(this);
		itemFileSave.addActionListener(this);
		itemExportPng.addActionListener(this);
		itemExportJPG.addActionListener(this);
		//
		menuFile.add(itemFileNew);menuFile.add(itemFileOpen);menuFile.add(itemFileSave);
		/*menuExport.add(itemExportJPG)*/;menuExport.add(itemExportPng);
		menuHelp.add(new JMenuItem("0383990754 or Email:17110128student.hcmute.edu.vn"));
		//
		menuBar.add(menuFile);
		menuBar.add(menuExport);
		menuBar.add(menuMode);
		menuBar.add(menuHelp);
		menuBar.setBackground(new Color(0,0,0,0));
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		//
		return menuBar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "new":
			EventWorkArea.myCanvas.setShapes(new ArrayList<Shape>());
			break;
		case "open":
			OpenFile();
			break;
		case "save":
			SaveFile();
			break;
		case "png":
			ExportPNG();
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + e.getActionCommand());
		}
	}
	 public void ExportPNG() 
	 {
		 try {
		        BufferedImage image = new BufferedImage(myCanvas.getWidth(), myCanvas.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		        JFileChooser jFile = new JFileChooser();
		        jFile.showSaveDialog(null);
		        Path pth = jFile.getSelectedFile().toPath();
		        JOptionPane.showMessageDialog(null, pth.toString()+".png");
		        Graphics g = image.getGraphics();
		        myCanvas.printAll(g);
		        g.dispose();
		        ImageIO.write(image, "png", new File(pth.toString()+".png"));
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	 }
	 public void SaveFile() {
		 JFileChooser jFile = new JFileChooser();
		 jFile.showSaveDialog(null);
		 Path pth = jFile.getSelectedFile().toPath();
		 
		 try {
			 File file =new File(pth.toString()+".rmd");
			 if(!file.exists()) {
				 file.createNewFile();
			 }
			 FileOutputStream fileOutputStream = new FileOutputStream(file);
			
			 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			 
			 ListShapes listShapes=new ListShapes();
			 listShapes.setShapes(MyCanvas.getShapes());
			 
			 objectOutputStream.writeObject(listShapes);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 JOptionPane.showMessageDialog(null, pth.toString()+".rmd");
	 }
	 
	 //https://www.mkyong.com/swing/java-swing-jfilechooser-example/
	 public void OpenFile(){
		 JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		 jfc.setDialogTitle("Select an image");
		 jfc.setAcceptAllFileFilterUsed(false);
		 FileNameExtensionFilter filter = new FileNameExtensionFilter("rmd", "rmd");
		 jfc.addChoosableFileFilter(filter);

		 int returnValue = jfc.showOpenDialog(null);
		 if (returnValue == JFileChooser.APPROVE_OPTION) {
			 File selectedFile = jfc.getSelectedFile();
			 
			 FileInputStream fileInputStream;
			try {
				fileInputStream = new FileInputStream(selectedFile);
				ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
				
                ListShapes listShapes=(ListShapes)objectInputStream.readObject();
                EventWorkArea.myCanvas.setShapes(listShapes.getShapes());
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
			 
			 System.out.println(jfc.getSelectedFile().getPath());
		 }
	 }
	 
	 public void OpenPaint() {
		 
		 BufferedImage bi = null;
         //System.err.println("....setimg...." + fileName);

         try {
             bi = ImageIO.read(new File("D://moa.png")); 

         } catch (IOException e) {
             e.printStackTrace();
             System.out.println("Image could not be read");
             System.exit(1);
         }
	}
}
