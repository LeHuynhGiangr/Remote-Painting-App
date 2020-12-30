import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.undo.UndoManager;



public class MyCanvas extends JPanel{
	private static ArrayList<List<Shape>> store = new ArrayList<List<Shape>>();
	private static int current=0; 
	private static List<Shape> shapes;
	private int flagAdd=1;
	private int n;
	public int shapeSelected=-1;
	public static Boolean groupBoolean=false;
	
	public static Boolean getGroupBoolean() {
		return groupBoolean;
	}
	public static void setGroupBoolean(Boolean groupBoolean) {
		MyCanvas.groupBoolean=groupBoolean;
	}
	public int getNoShape() {
		return n;
	}
	
	public static List<Shape> getShapes() {
		return shapes;
	}
	
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
		this.n=shapes.size();
		repaint();
		if(NetWork.network.getMode().equals("server"))NetWork.network.Update(this.shapes);
	}
	
	public MyCanvas() {
		shapes=new ArrayList<Shape>();
		store.add(shapes);current=0;
		this.setBorder(new LineBorder(Color.BLACK,3));
		this.addMouseListener(new EventWorkArea());
		this.addMouseMotionListener(new EventWorkArea());
		EventWorkArea.setMyCanvas(this);
		n=0;
	}
	
	public void drawShape(Shape shape) {
		remove();
		shape.setStroke(PropertiesBar.getStroke());	
		this.shapes.add(n,shape);
		n++;
		repaint();
		flagAdd=0;
	}
	public void addShape() {
		flagAdd=1;
		for(int i=0;i<shapes.size();i++)
		{
			shapes.get(i).setID(i);
			shapes.get(i).setGroup(groupBoolean);
		}
		//
		store.add(new ArrayList<Shape>(shapes));
		current=store.size()-1;
		
	}
	//remove shape at top 
	private void remove() {
		if(n>=1&&flagAdd==0) {
			this.shapes.remove(n-1);
			n--;
		}
		//store.push(new ArrayList<Shape>(shapes));
	}
	//move shape base on index
	public void moveShape(int index, int x, int y) {
		if(index>=0 && index < n) {
			for(int i=0;i<n;i++)
			{
				if(EventPropertiesBar.flag==1)
				{
					if(shapes.get(i).getGroup()==true)
					{
					
						shapes.get(i).Move(x, y);
						repaint();
						//
					}
				}
				else {
					if(i==index)
					{
					
						shapes.get(i).Move(x, y);
						repaint();
						//
					}
				}
			}
		}
	}
	//rotate shape
	public void rotateShape(int index, float anpha) {
		if(index>=0 && index < n) {
	
			shapes.get(index).Rotate(anpha);
			repaint();
			//
			//shapesMemory.add(current++, shapes);
		}
	}
	//fill color 
	public void fillColor(int index, Color color) {
		if(index>=0 && index < n) {
	
			shapes.get(index).setColor(color);
			repaint();
			//
			//shapesMemory.add(current++, shapes);
		}
	}
	//shape is selected when mouse press
	public int selectShape(int locationX, int locationY) {
		int i;
		//PropertiesBar.getGroup().setText("Add Group");
		//PropertiesBar.getGroup().setBackground(Color.GREEN);
		for(i=n-1;i>=0;i--)
			if(shapes.get(i).IsOnThisShape(locationX, locationY)) {			
				//
				this.shapeSelected=i;
				Shape shape = shapes.get(i);
				StatusBar.setInfor(shape.getClass().getName(), shape.getxLocation(), shape.getyLocation(), i+1, n,shape.getId(),shape.getGroup());
				
				PropertiesBar.group.setVisible(true);
				PropertiesBar.ShowGroup(shape.getGroup());
				/*if(shape.getGroup()==true)
				{
					shapes.get(i).setGroup(groupBoolean);
					
					PropertiesBar.getGroup().setBackground(Color.RED);
					PropertiesBar.getGroup().setText("Remove Group");
				}*/
				//				
				
				return i;
			}
		return i;
	}
	
	public void removeByIndex(int index) {
		if(index>=0 && index <n) {
			store.add(new ArrayList<Shape>(shapes));
			current=store.size()-1;
			shapes.remove(index);
			n--;
			repaint();
			//
			//shapesMemory.add(current++, shapes);
		}
		
	}
	
	public void undo() {
		if(current<=0)return;
		current--;
		this.setShapes(store.get(current));
		
		//store.remove(store.size()-1);
	}
	public void redo() {
		if(current>=store.size()-1)return;
		current++;
		this.setShapes(store.get(current));
	}

	@Override
	public void paintComponent(Graphics g) {
		//super.paint(g);
		for(Shape shape: shapes) {
			shape.Draw((Graphics2D)g);
		}
		this.getParent().repaint();
		//NetWork.Update(shapes);
		
	}
}
