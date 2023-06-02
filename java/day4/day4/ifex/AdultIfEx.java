package day4.ifex;

import java.util.*;

public class AdultIfEx {

	public static void main(String[] args) {
		
	
		System.out.println("나이를 입력하시오: ");
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		
		if (age >= 20) {
			System.out.println("adult");
		}
		
		else {System.out.println("minor");}
		
		sc.close();
	}

}
