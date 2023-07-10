package testpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Flush {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try{
			fw = new FileWriter("test11.txt");
			fw.write(97);
			
			fw.write(65);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try(FileInputStream fis2 = new FileInputStream("test11.txt")){
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


