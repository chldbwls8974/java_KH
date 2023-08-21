package db.self.board.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.self.board.service.BoardService;
import db.self.board.service.BoardServiceImp;
import db.self.board.vo.BoardVO;

public class BoardController {

	private Scanner sc;
	private BoardService boardService;
	
	public BoardController(Scanner sc) {
		this.sc = sc;
		boardService = new BoardServiceImp();
	}

	public void run() {
		// TODO Auto-generated method stub
		// �Խñ� ���, ����, ����, �Խñ� ����Ʈ ��Ⱥ
		
		int menu;
		final int EXIT = 5;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertBoard();
			break;
		case 2:
			updateBoard();
			break;
		case 3:
			deleteBoard();
			break;
		case 4:
			printBoardList();
			break;
		case 5: 
			break;
		default:
				System.out.println("[�߸��� �޴� �Դϴ�.]");
		}
		
	}
	
	private void deleteBoard() {
		// �Խñ� ����
		// ������ �Խñ�.. �������� ����
		System.out.print("������ �Խñ� ��ȣ : ");
		int index = sc.nextInt();
		System.out.print("������ ������ �Է� :");
		sc.next();
		String title = sc.nextLine();
		System.out.print("�ۼ��� ���̵� : ");
		String id = sc.next();
		if(boardService.deleteBoard(index, title,id)) {
			System.out.println("[�Խñ� ���� ����]");
		}else {
			System.out.println("[�Խñ� ���� ����]");
		}
	}

	private void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	private void printBoardList() {
		ArrayList<BoardVO> list = boardService.getBoardList();
		for(BoardVO tmp : list) {
			System.out.println(tmp);
		}
	}

	private void insertBoard() {
		
		// ����, �ۼ��� ���̵� 
		System.out.print("���� : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("���̵� : ");
		String id = sc.next();
		if(boardService.insertBoard(title,id)) {
			System.out.println("[�Խñ� �ۼ� ����]");
		}else {
			System.out.println("[�Խñ� �ۼ� ����]");
		}
	}

	private void printMenu() {
		System.out.println("==== �Խ��� �޴� ====");
		System.out.println("1. �Խñ� ���");
		System.out.println("2. �Խñ� ����");
		System.out.println("3. �Խñ� ����");
		System.out.println("4. �Խñ� Ȯ��");
		System.out.println("5. �ڷΰ���");
		System.out.println("==================");
		System.out.print("�޴� ���� : ");
	}

}
