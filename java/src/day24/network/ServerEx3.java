package day24.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx3 {

	public static void main(String[] args) {
		

		int port = 5001;
		
		try(ServerSocket serverSocket = new ServerSocket(port);){

			while (true) {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				client.read();
				client.send();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
