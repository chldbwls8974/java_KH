package day24.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		int port = 5001;  // 1.포트 번호 설정
		
		ServerSocket serverSocket = null;
		
		try {
			// 2. 서버 소켓 생성
			serverSocket = new ServerSocket(port);
			// 3. 대기
			while(true) {
				System.out.println("Waiting...");
				
				// 4. 연결 요청이 오면 수락
				Socket socket = serverSocket.accept();
				System.out.println("Connect!");
				
				//5. 작업
				// 항상 읽어와야하는 것은 아님. 
				// 클라이언트에서 보낸 데이터를 가져오기 위해 inputstream 생성
				InputStream is = socket.getInputStream();
				byte []bytes = new byte[1024];
				int readCount = is.read(bytes);  // read 는 많은 오버라이딩 형태를 가지고 있음
				String str = new String(bytes);
				System.out.println("Data: " + str);
				
				// 클라이언트로 데이터를 보내기 위해 outputstream생성
				OutputStream os = socket.getOutputStream();
				String str1 = sc.nextLine();
				bytes = str.getBytes();
				os.write(bytes);
				os.flush();
				
				os.close();
				is.close();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
