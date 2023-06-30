package day23.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class OutputStreamEx {

	public static void main(String[] args) {

		
		// 방법 1
		try(FileWriter fw = new FileWriter("output1.txt")){
			for(int i = 1 ; i <= 10 ; i++) {
				fw.write(i + " ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		// 방법 2
		try(FileOutputStream fos = new FileOutputStream("output11.txt")){
			for(int i = 1 ; i <= 10 ; i++) {
				fos.write(i);
		}} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
