package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day21.practice.updown.vo.UserManager;




public class UpdownController {
	
	private Scanner sc = new Scanner(System.in);
	private UserManager player = new UserManager();
	private ArrayList<Integer> list = new ArrayList<>();	
	
	public void run() {
		int menu = 0;
		do {
			printMenu();
			menu = sc.nextInt();
			running(menu);
			
		}while(menu!=3);
	}

	private void printMenu() {
		System.out.println("1. play");
		System.out.println("2. record");
		System.out.println("3. exit");
	}
	
	private void running(int menu) {
		switch(menu) {
		case 1:
			startGame();
			break;
		case 2:
			recordGame();
			break;
		case 3:
			break;
		}
		
	}

	
	private void recordGame() {
		// TODO Auto-generated method stub
		
	}

	private void startGame() {
		System.out.println("start");
		
		System.out.println("input your userId");
		String id = sc.next();


		int num = random(1,100);
		int user = 0;
		
		
		System.out.println(num);
		
		while (num != user) {
			System.out.print("input number");
			user = sc.nextInt();
			list.add(user);
			if(num > user ) {System.out.println("Up!");}
			else if (num < user){System.out.println("Down!");}	
		}
		player.addUser(id,list);
		
	}
	
	
	
	private int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()* (max - min + 1) + min);
	}
}
