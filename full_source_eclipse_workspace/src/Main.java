import java.awt.BorderLayout;

/***
 * 
 * @author lehuynhgiang
 * edit: 11/23/2019
 */
public class Main {

	public static void main(String[] args) {
			//Main window
			MainWindow mainWindow =new MainWindow(1200,660);
			
			//component
			MyMenuBar myMenuBar=new MyMenuBar(mainWindow.getxSize()/20, mainWindow.getySize());
			MyToolBar myToolBar=new MyToolBar(mainWindow.getxSize(),  mainWindow.getySize()/13,new EventToolBar()); 
			PropertiesBar myTableColor=new PropertiesBar(mainWindow.getxSize()/4, mainWindow.getySize(), new EventPropertiesBar());
			WorkArea workArea=new WorkArea(800, 500);
			StatusBar statusBar=new StatusBar(mainWindow.getxSize(),  mainWindow.getySize()/25);
			
			NetWork network=new NetWork();
			
			//Window add component
			mainWindow.add(myMenuBar, BorderLayout.WEST);
			mainWindow.add(myToolBar, BorderLayout.NORTH);
			mainWindow.add(myTableColor, BorderLayout.EAST);
			mainWindow.add(workArea);
			mainWindow.add(statusBar, BorderLayout.SOUTH);
			//Display window
			mainWindow.Display();
	}

}
