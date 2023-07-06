package day23.iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIOStreamEx {

	public static void main(String[] args) {

		// 문자 단위로 읽어오는 예제
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			
			while(fr.read(buffer) != -1) {
				System.out.print(buffer);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("exception");
		}
		
		
		// 문자 단위로 쓰는 ㅇㅖ제
		// filewriter생서ㅇ자( 파일명, 이어쓰기 여부) >> true 입력시 자동 만ㄷ르어지기
		// >> 이어쓰기 여부가  true이면 이어서 작성
		try(FileWriter fw = new FileWriter("file.txt", true)){
			String str ="Hello World!\n";
			fw.write(97);
			String str2 = "Hi, javja\n";
			fw.write(100);
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

}
