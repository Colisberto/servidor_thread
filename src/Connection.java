import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection extends Thread {

	BufferedReader inFromClient;
	
	DataOutputStream outToClient;
	
	Socket clientSocket;
	
	String clientSentence;
	
	String capitalizedSentence;

	public Connection(Socket aClientSocket) throws IOException {
		
		clientSocket = aClientSocket;
				
		this.start();
	}

	@Override
	public void run() {
		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

			clientSentence = inFromClient.readLine();

			System.out.println(clientSentence);

			capitalizedSentence = clientSentence.toUpperCase() + '\n';

			outToClient.writeBytes(capitalizedSentence);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
