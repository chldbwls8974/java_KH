package day24.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx3 {

	public static void main(String[] args) {

		int port = 5001;
		String ip = "192.168.30.12";// 1로 수정
		Socket socket = new Socket();
		
		
			try {
				socket.connect(new InetSocketAddress(ip,port));
				
				// 연결이 완료되면, 읽기 쓰기 기능을 클래스로 연결하여 실행
				Client client = new Client(socket);
				client.read();
				client.send();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
	}

