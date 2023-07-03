package day24.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpEx {

	public static void main(String[] args) {
		InetAddress inetAddress = null;
		
		try {
			// 이름이 localhost인 곳의 	IP 주소 정보를 가져옴
			inetAddress = InetAddress.getByName("localhost");
			inetAddress = InetAddress.getByName("www.naver.com");
			//System.out.println(inetAddress);

			inetAddress = InetAddress.getLocalHost();
			InetAddress [] address = InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : address) {
				System.out.println(tmp);
			}


		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
