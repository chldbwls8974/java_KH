package day21.practice.baseball.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day21.practice.baseball.vo.RecordGame;




public class BaseballController {
	
	private Scanner sc = new Scanner(System.in);
	
	//기록을 저장하는 리스트
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

	/*
	private void recordGame() {
		System.out.println("record");
		System.out.println("input user id");
		String id = sc.next();
		
		
		System.out.println(list);
		System.out.println(list.size());
	}
	*/

	
	
	private void recordGame() {
		// TODO Auto-generated method stub
		
	}

	private void startGame() {
		System.out.println("start");
		
		System.out.println("input your userId");
		String id = sc.next();

		int num = random(1,100);
		int user = 0;
		int count = 0;
		
		
		System.out.println(num);
		
		while (num != user) {
			System.out.print("input number");
			user = sc.nextInt();
			if(num > user ) {System.out.println("Up!");}
			else if (num < user){System.out.println("Down!");}	
			count++;
		}
		
		RecordGame rec = new RecordGame(id, count);
		
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
