package day21.homework.updown.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import day21.homework.updown.vo.RecordGame;

public class UpdownController {
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<RecordGame> list = new ArrayList<>();	
	
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
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}		
		
		
	}

	private void startGame() {
		System.out.println("start");
		
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
		

		System.out.println("input your userId");
		String id = sc.next();

		RecordGame rec = new RecordGame(id,count);
		list.add(rec);
		
		// if list.size < rank
		// add
		
		// list.size > rank
		// compare count
		// if count < rank 
		// not add
		// else if count >= rank
		// add
		
		
	}

	
	private void sort() {
		for(int i = 0; i<list.size()-1; i++) {
			for(int j = 0; j<list.size()-1; j++) {
				if(list.get(j).getCount() > list.get(j+1).getCount()) {
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
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
