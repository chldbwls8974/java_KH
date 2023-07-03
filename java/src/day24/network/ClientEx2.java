package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx2 {

	public static void main(String[] args) {

		int port = 5001;
		String ip = "192.168.30.12";// 1로 수정
		Socket socket = new Socket();
		
		
			try {
				socket.connect(new InetSocketAddress(ip,port));
				
				Thread sendThread = new Thread(()->{
					try{
						while(true) {
							Scanner sc = new Scanner(System.in);
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
							System.out.println("server : " + str); 
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				
				readThread.start();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
	}

