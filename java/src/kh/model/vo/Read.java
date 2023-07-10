package kh.model.vo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read {
	public static void main(String[] args) {
		try(FileInputStream fis2 = new FileInputStream("food0.txt")){
			int data;
			while((data = fis2.read()) != -1) {
				System.out.print((char)data);
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
