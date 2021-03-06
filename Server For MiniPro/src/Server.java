import java.net.*;
import java.io.*;
import java.util.*;


public class Server {
	static java.util.Date serverCreate;
	private static int maxClients = 0;
	
	public static void main(String[] args) {

		// Creating a thread for the server
		new Thread(() -> {
			try {
				ServerSocket server = new ServerSocket(7845);
				serverCreate = new java.util.Date();
				System.out.println("The Server Was Created: " + serverCreate);

				while (maxClients < 4 || maxClients == 4) {
					// Listen to clients
					Socket socket = server.accept();
					// adding to the number of clients connected
					maxClients++;
					InetAddress inetAddress = server.getInetAddress();
					System.out.println("Client " + maxClients + "'s host name is " + inetAddress.getHostName());
					System.out.println("Client " + maxClients + "'s IP Address is " + inetAddress.getHostAddress());
					// Creating a new thread for each client connecting
					new Thread(new HandleAClient(socket)).start();
				} 
				
			} catch (IOException ex) {
				System.err.println(ex);
			}

		}).start();
	}

}

class HandleAClient implements Runnable {
	private Socket socket;


	HandleAClient(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			// data recieved and send
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());

			while (true) {
			

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}