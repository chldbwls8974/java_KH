package testpractice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Ex {
	private Socket socket;
	
	public void read() {
		Thread t = new Thread(() -> {
			
			try {
				InputStream is = socket.getInputStream();
				
				while(true) {
					byte []bytes = new byte[1024];
					int readCount = is.read(bytes);
					
					if(readCount == -1) {break;}
					
					String str = new String(bytes);
					System.out.println(str);
				}
				
				if(is != null) {
					is.close();
				}
			}catch(Exception e) {
				System.out.println("Exception");
			}
			
		});
		t.start();
	}
	
	public void send() {
		Thread t = new Thread(() -> {
			try {
				OutputStream os = socket.getOutputStream();
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					String str = sc.nextLine();
					byte []bytes = str.getBytes();
					os.write(bytes);
					os.flush();
					
					if(str.equals("exit")) {
						socket.close();
						break;
					}
				}
				
			}catch(Exception e) {
				System.out.println("Exception");
			}
		});
		t.start();
	}
}
