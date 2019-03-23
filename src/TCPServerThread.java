import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerThread {
	
	String clientSentence;
	
	String capitalizedSentence;
	
    public static void main (String args[]) {
	try{
		int serverPort = 6777; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		while(true) {
			Socket clientSocket = listenSocket.accept();
			Connection c = new Connection(clientSocket);
		}
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }

}
