package day23.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class StreamEx1 {

	public static void main(String[] args) {
		FileInputStream fis =null;
		
		/* test.txt는 상대 경로 : 기준은 프로젝트 폴더가 기준
		 * */
		// 파일을 수동으로 닫는 코드
//		try {
//			
//			fis = new FileInputStream("test.txt");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println("File not found!");
//		} finally {
//			// 프로그램 종료 전 사용했던 파일을 닫아줌
//			if(fis!= null) {
//				try {
//					fis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		
		// 파일을 작성하는 예제
		// byte로 받는 방법 >> 한글이 깨짐
		Scanner sc = new Scanner(System.in);
		try(FileOutputStream fos = new FileOutputStream("test.txt")) {
			System.out.println("input: ");
			for(int i = 0 ; i <5 ; i++) {
				char ch = sc.next().charAt(0);
				fos.write(ch);
			}
		}catch(FileNotFoundException e1) {
			System.out.println("File not found!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		// 파일을 읽는 예제
		try(FileInputStream fis2 = new FileInputStream("test.txt")){
			int data;
			while((data = fis2.read()) != -1) {
				System.out.println((char)data);
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
