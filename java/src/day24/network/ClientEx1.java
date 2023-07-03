package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import org.xml.sax.InputSource;

public class ClientEx1 {

	public static void main(String[] args) {

		int port = 5001; // 서버 포트 번호
		Scanner sc = new Scanner(System.in);
		
		// 1. 소켓 생성

		
		//2. 연결요청
		try(Socket socket = new Socket();) {
			socket.connect(new InetSocketAddress(port));
			System.out.println("connect!!");
			// 3. 작업
			// 서버에 데이터 전송을 위해 outputstream 생성
			OutputStream os = socket.getOutputStream();
			String str = sc.nextLine();
			byte [] bytes = str.getBytes(); // 데이터를 바이트로 변환
			os.write(bytes);
			os.flush(); // 꽉 차야지 보낼 수 있기때문에 flush 를 통해서 데이터를 밀어준다
			InputStream is = socket.getInputStream();
			bytes = new byte[1024];
			int readCount = is.read(bytes);
			str = new String(bytes);
			System.out.println("server : " + str);
			
			is.close();			
			os.close();
			
		} catch (IOException e) {
			System.out.println("connection refused!");
			e.printStackTrace();
		}
		
	}

}
