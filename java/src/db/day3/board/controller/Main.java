package db.day3.board.controller;

import java.util.Scanner;

public class Main {
	
	private static MemberController memberController = new MemberController();
	private static BoardController boardController = new BoardController();
	
	public static void main(String[] args) {
		int menu;
		final int EXIT = 3;
		Scanner sc = new Scanner(System.in);	
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("================");
		}while(menu != EXIT);
		
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1: 
			memberController.run();
			break;
		case 2: 
			boardController.run();
			break;
		case 3:
			System.out.println("[���α׷� ����]");
			break;
		default:
			System.out.println("[�߸��� �Է��Դϴ�.]");
		}
		
	}

	private static void printMenu() {
		System.out.println("====== �޴� =====");
		System.out.println("1. ȸ������");
		System.out.println("2. �Խ��� ����");
		System.out.println("3. ���α׷� ����");
		System.out.println("================");
		System.out.print("�޴� ���� : ");
	}

}
