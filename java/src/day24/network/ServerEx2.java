package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx2 {

	public static void main(String[] args) {
		

		int port = 5001;
		
		try(ServerSocket serverSocket = new ServerSocket(port);){

			while (true) {
				Socket socket = serverSocket.accept();
				
				
				Thread sendThread = new Thread(()->{
					Scanner sc = new Scanner(System.in);
					try{
						while(true) {
							String str = sc.nextLine();
							byte [] bytes = str.getBytes();
							OutputStream os = socket.getOutputStream();
							os.write(bytes);
							os.flush();
							
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				sendThread.start();
				
				Thread readThread = new Thread(()->{
						try{
						InputStream is = socket.getInputStream();
						while(true) {
							byte [] bytes = new byte[1024];
							is.read(bytes);
							String str = new String(bytes);
							System.out.println("client : " + str); 
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
				readThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
