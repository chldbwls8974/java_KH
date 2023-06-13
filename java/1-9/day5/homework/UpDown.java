package day5.homework;

import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {

		//UpDownEx
		// 1에서 100사이의 랜덤 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요.
		
		// 만약에 랜덤한 수가 45라면
		// input: 50
		// 출력 Down!
		// input : 40
		// 출력 Up!
		// 맞출때 까지 반복, 맞추면 반복문 탈출
		
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;
		
		int random =(int)( Math.random()*(max - min + 1) + min);
		int num = 0;
	
		
		while (random != num) {
			System.out.println("input number");
			num = sc.nextInt();
			if(random > num ) {System.out.println("Up!");}
			else if (random < num){System.out.println("Down!");}	
		}
		
		System.out.println("Good!!" );
		
		sc.close();
	}

}
