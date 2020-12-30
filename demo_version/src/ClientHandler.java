import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Thread{
	final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
    final int id;
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos,int id)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
        this.id=id;
    } 
    public void run()  
    { 
        String received; 
        String toreturn; 
        DataInputStream in = new DataInputStream(System.in); 
        while (true)  
        { 
            try { 
  
                // Ask user what he wants 
            	String tosend=in.readLine();
                dos.writeUTF(tosend+" to "+id); 
                  
                // receive the answer from client 
                received = dis.readUTF(); 
                  
                if(received.equals("Exit")) 
                {  
                    System.out.println("Client " + id + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                else {
					System.out.println(received);
				}
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
}
