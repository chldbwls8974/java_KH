package testpractice;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		
		int port = 5001;
		String ip = "192.168.30.12";
		Socket socket = new Socket();
		
		try {
			socket.connect(new InetSocketAddress(ip, port));
			
			Ex pr = new Ex(socket);
			pr.read();
			pr.send();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
