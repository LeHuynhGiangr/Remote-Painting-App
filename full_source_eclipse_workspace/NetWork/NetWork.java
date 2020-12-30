import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class NetWork extends Thread{
	///////
	public static NetWork network;
	private NetWork(int a) {
		
	}
	public static NetWork getNetwork() {
		return network;
	}
	///////

	private int port=4322;
	private ServerSocket serverSocket;
	private Socket socket;
	private String mode="not";
	private String ip=""; 
	
	private ObjectInputStream oIS;
	private ObjectOutputStream oOS;
	
	private static List<ClientHandler> clients;
	
	public NetWork() {
		this.network=new NetWork(0);
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public static List<ClientHandler> getClients() {
		return clients;
	}
	@Override
	public void run()
	{
		switch (mode) {
		case "server":
			if(serverSocket==null)
				try {
					serverSocket=new ServerSocket(port);
					server();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("can not open socket:NetWork/setMode/server");
					e1.printStackTrace();
				}
			break ;
		case "client":
			try {
				socket=new Socket(ip, port);
				client();
			} catch (IOException e) {
				System.out.println("can not open socket:NetWork/setMode/client");
				e.printStackTrace();
			}
			break ;
		default:
			break;
		}
	}
	
	//
	private void server() {
		int i=0;
		clients=new ArrayList<ClientHandler>();
		while(1==1) {
			socket=null;
			try {
				System.out.println("1");
				
				socket=serverSocket.accept();
				
				System.out.println("2");
				//*****************
				// obtaining input and out streams 
				// create a new thread object
	            
		        ClientHandler client = new ClientHandler(socket, i); 
		        clients.add(client);
		        clients.get(clients.size()-1).start();
		        clients.get(clients.size()-1).Update(EventWorkArea.getMyCanvas().getShapes());
		        
				i++;
				System.out.println("client "+i+" is connected :");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("NetWork/server");
				e.printStackTrace();
			}
		}
	}
	private void client() {
		while (true){  
			try {
				
				oIS=new ObjectInputStream(socket.getInputStream());
                ListShapes listShapes=(ListShapes)oIS.readObject();
                System.out.println(listShapes.getStr());
                String received=listShapes.getStr();
                if(received.equals("close")) 
                { 
                	System.out.println("Closing this connection : " + socket); 
	                socket.close(); 
	                System.out.println("Connection closed"); 
	                break; 
                }
                EventWorkArea.getMyCanvas().setShapes(listShapes.getShapes());
				
                // If client sends exit,close this connection  
                // and then break from the while loop
                
               
                // closing resources     
               
			}catch(Exception e){
				System.out.println("NetWork/client 2");
				//this.Out();
				e.printStackTrace(); 
				break;
			} 
        }
		try {
			oIS.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Update(List<Shape> shapes) {
		switch (this.mode) {
		case "server":
			System.out.println("start update to client"+ clients.size());
			for(ClientHandler client:clients) {
				try {
				client.Update(shapes);
				}catch(Exception e) {
					clients.remove(client);
				}
			}
			break ;
		case "client":
			System.out.println("start update to server");
			UpdateToServer(shapes);
			break;
		default:
			//not do anything
		}
	}
	private void UpdateToServer(List<Shape> shapes) {
		if(socket.isClosed())return;
		try {
			//dos = new DataOutputStream(socket.getOutputStream());
            //dos.writeUTF("from client");
			oOS=new ObjectOutputStream(socket.getOutputStream());
			ListShapes listShapes=new ListShapes();
			listShapes.setStr("from client");
    		listShapes.setShapes(shapes);
    		//dos.writeObject(listShapes);
            oOS.writeObject(listShapes);
    		String tosend="";
            if(tosend.equals("Exit")) 
            { 
            	System.out.println("Closing this connection : " + socket); 
            	socket.close(); 
            	System.out.println("Connection closed"); 
            	//dos.close(); 	
            }
        }catch(Exception e){
        	System.out.println("NetWork/UpdateToServer");
            e.printStackTrace(); 
        }
	}
	
	public void close() {
		try {
			oOS=new ObjectOutputStream(socket.getOutputStream());
			ListShapes listShapes=new ListShapes();
			listShapes.setStr("close");
    		//dos.writeObject(listShapes);
            oOS.writeObject(listShapes);
            System.out.println("Closing this connection : " + socket); 
           	socket.close(); 
           	System.out.println("Connection closed"); 
           	oOS.close(); 	
        }catch(Exception e){
        	System.out.println("NetWork/close");
            e.printStackTrace(); 
        }
 	}
	
	public void Out() {
		switch (this.mode) {
		case "server":
			for(ClientHandler client:clients) {
				client.Out();
				client.stop();
			}
			clients=null;
			break;
		case "client":
			if(!socket.isInputShutdown())
				try {
					socket.shutdownInput();
					oIS.close();
				} catch (IOException e1) {
					System.out.println("cannot close Input Stream");
					e1.printStackTrace();
				}
	    	if(!socket.isOutputShutdown()) {
	    		socket.isOutputShutdown();
	    		try {
					oOS.close();
				} catch (IOException e) {
					System.out.println("cannot close Onput Stream");
					e.printStackTrace();
				}
	    	}
	    	if(!socket.isClosed())
				try {
					socket.close();
				} catch (IOException e) {
					System.out.println("cannot close socket");
					e.printStackTrace();
				}
	    	if(serverSocket.isClosed())
				try {
					serverSocket.close();
				} catch (IOException e1) {
					System.out.println("cannot close server socket");
					e1.printStackTrace();
				}
			break;
		default:
		}
		socket=null;
		serverSocket=null;
		this.mode="not";
	}
}
