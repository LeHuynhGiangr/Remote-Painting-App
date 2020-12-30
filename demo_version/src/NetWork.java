import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetWork {
	private int port=4321;
	private String ip=""; 
	private ServerSocket serverSocket;
	private Socket socket;
	
	private String mode="not";

	public NetWork() {
	}
	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode, String ip) {
		this.mode = mode;
		this.ip=ip;
		if(!socket.isClosed())
			try {
				socket.close();
			} catch (IOException e1) {
				System.out.println("can not close socket:NetWork/setMode");
				e1.printStackTrace();
			}
		if(!serverSocket.isClosed())
			try {
				serverSocket.close();
			} catch (IOException e1) {
				System.out.println("can not close serversocket:NetWork/setMode");
				e1.printStackTrace();
			}
		switch (mode) {
			case "server":
				
				break ;
			case "client":
				try {
					socket=new Socket(ip, port);
				} catch (IOException e) {
					System.out.println("can not open socket:NetWork/setMode");
					e.printStackTrace();
				}
				break ;
			default:
				break;
		}
	}
}
