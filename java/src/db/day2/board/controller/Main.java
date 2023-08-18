package db.day2.board.controller;

import java.sql.*;
import java.util.Scanner;

public class Main {
	
	private static Connection con = null; 
	private static MemberController memberController;
	private static BoardController boardController;

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
		
		con = connect(url, dbId, dbPw);

		if(con!=null) {
		System.out.println("[���� ����]");
		}else {
			System.out.println("[���� ����]");
			return;
		}
		
		
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(con, sc);
		boardController = new BoardController(con, sc);
		do {
			// �޴� ���
			printMenu();
			
			// �޴� ����
			menu = sc.nextInt();
			
			// �޴� ����
			runMenu(menu);
		}while(menu!=EXIT);
		
		
		
		sc.close();
		close(con);
			
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

	private static Connection connect(String url, String id, String pw) {
		try {
			return DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	private static void close(Connection con) {
			// ������ connection�� �ݾ���
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
		}
	}
}
