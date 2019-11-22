/*
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyConnect {
	private int port=4321;
	private String hostname; 
	ServerSocket serverSocket;
	Socket socket;
	
	//status
	boolean myConnectActive=false;
	boolean serverModeActive=false;
	boolean clientModeActive=false;
	
	//
	public MyConnect() {
		
	}
	//
	public void closeConnect() {
		serverModeActive=false;
		clientModeActive=false;
		myConnectActive=false;
		
		try {
			if(serverModeActive)
				if(!socket.isClosed())socket.close();
				if(!serverSocket.isClosed())serverSocket.close();
			else if(clientModeActive){
				if(!socket.isClosed())socket.close();
			}
		} catch (IOException e) {
			System.out.print("loi o MyConnect/closeConnect");
			e.printStackTrace();
		}
	}
	//
	public void endServerMode() {
		if(myConnectActive && serverModeActive) {
			serverModeActive=false;
			if(!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					System.out.print("loi o MyConnect/endServerMode");
					e.printStackTrace();
				}
		}
	}
	//
	public void endClientMode() {
		if(myConnectActive && clientModeActive) {
			clientModeActive=false;
			if(!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					System.out.print("loi o MyConnect/endClientMode");
					e.printStackTrace();
				}
		}
	}
	
	//SERVER MODE
	public void serverMode() {
		if(!clientModeActive && !myConnectActive) {
			try {
				this.serverSocket=new ServerSocket(this.port);
				this.socket=serverSocket.accept();
				myConnectActive=true;
				serverModeActive=true;
			} catch (IOException e) {
				myConnectActive=false;
				serverModeActive=false;
				System.out.println("loi MyConnect/serverMode:)");
				e.printStackTrace();
			}
		}
	}
	
	//CLIENT MODE
	public void clientMode() {
		if(!serverModeActive  && !myConnectActive) {
			try {
				this.socket=new Socket(this.hostname,this.port);
				myConnectActive=true;
				clientModeActive=true;
			} catch (IOException e) {
				myConnectActive=false;
				clientModeActive=false;
				System.out.println("loi MyConnect/clientMode:)");
				e.printStackTrace();
			}
		}
	}
	
	//
	public void receive(MyCanvas canvas)
	{
		while(myConnectActive && socket !=null) {
			try {
				ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
				GraphicsSerialization gS=(GraphicsSerialization)oin.readObject();
				System.out.println("da nhan duoc");//thong bao
				canvas.someOneDraw(gS);
				}catch (IOException e) {
				System.out.println("loi Myconnect/receive 1");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("loi Myconnect/receive 2");
				myConnectActive=false;
				e.printStackTrace();
			}
		}
	}
	//send
	public void send(GraphicsSerialization gS) {
		if(myConnectActive) {
			try {
					ObjectOutputStream objOut=new ObjectOutputStream(this.socket.getOutputStream());
					objOut.writeObject(gS);
					objOut.flush();
			} catch (UnknownHostException e) {
				System.out.print("Loi o MyConnect/send 1");
				myConnectActive=false;
				e.printStackTrace();
			} catch (IOException e) {
				System.out.print("Loi o MyConnect/send 2");
				myConnectActive=false;
				e.printStackTrace();
			}
		}
	}
	
	
}
*/