package day6.practice;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;
		
		
		int num = 0;
		char ans = 'y';
	
		
			while ( ans != 'n') {
				int random =(int)( Math.random()*(max - min + 1) + min);
				
				do {
					System.out.println("input number");
					num = sc.nextInt();
					if(random > num ) {System.out.println("Up!");}
					else if (random < num){System.out.println("Down!");}
				} while (random != num); {System.out.println("Good!!" );}
					
				System.out.println("continue? (y/n) ");
				ans = sc.next().charAt(0);}
		
		System.out.println("Exit!" );
		
		sc.close();
	}

}
