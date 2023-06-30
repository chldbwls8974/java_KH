package day23.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputStreamEx {

	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("output11.txt")){
			int data;
			while((data = fis.read())!= -1) {
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
