package kh.model.vo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class cont {
	private transient Scanner sc = new Scanner(System.in);
	//private Food food = new Food("apple", 20);
	
	public void run() {
		System.out.println("input filename");
		String fileName = sc.next();
		fileSave(fileName);
	}
	
	private void fileSave(String fileName) {
		try(
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
				System.out.println("input name kcal");
				String name = sc.next();
				int kcal = sc.nextInt();
				Food food = new Food(name, kcal);
			
			
				oos.writeObject(food);
				oos.flush();
					
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
}
