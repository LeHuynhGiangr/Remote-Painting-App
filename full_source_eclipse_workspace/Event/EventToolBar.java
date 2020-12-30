import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class EventToolBar implements ActionListener{
	public static String command="";
	
	private ConnectWindow connectWin=new ConnectWindow(); 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		command=e.getActionCommand();
		PropertiesBar.getText().setEnabled(false);
		EventPropertiesBar.flag=0;
		PropertiesBar.group.setVisible(false);
		switch (command) {
		case "undo":
			EventWorkArea.getMyCanvas().undo();
			System.out.println("undo");
			break;
		case "redo":
			EventWorkArea.getMyCanvas().redo();
			break;
		case "network":
			connectWin.Display(750, 100);
			break;
		case "rectangle":
			break;
		case "circle":
			break;
		case "line":			
			break;
		case "triangle":
			break;
		case "text":
			PropertiesBar.getText().setEnabled(true);
			break;

		default:
		}
	}
	public static String getCommand() {
		return command;
	}
	
}
