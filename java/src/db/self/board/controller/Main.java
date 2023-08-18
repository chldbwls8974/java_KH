package db.self.board.controller;

import java.sql.*;
import java.util.Scanner;

public class Main {
	
	private static MemberController memberController;
	private static BoardController boardController;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(sc);
		boardController = new BoardController(sc);
		do {
			// �޴� ���
			printMenu();
			
			// �޴� ����
			menu = sc.nextInt();
			
			// �޴� ����
			runMenu(menu);
		}while(menu!=EXIT);
		
		
		
		sc.close();
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
			System.out.println("[�߸��� �޴��Դϴ�.]");
		}
	}

	private static void printMenu() {
		System.out.println("======= �޴� ========");
		System.out.println("1. ȸ�� �޴�");
		System.out.println("2. �Խ��� �޴�");
		System.out.println("3. ����");
		System.out.println("====================");
		System.out.print("�޴� ���� :");
	}

}
