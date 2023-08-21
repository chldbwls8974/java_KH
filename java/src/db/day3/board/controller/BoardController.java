package db.day3.board.controller;

import java.util.List;
import java.util.Scanner;

import db.day3.board.service.BoardService;
import db.day3.board.service.BoardServiceImp;
import db.day3.board.vo.BoardVo;

public class BoardController {
	private BoardService boardService = new BoardServiceImp();
	
	public void run() {
		int menu;
		final int EXIT = 5;
		Scanner sc = new Scanner(System.in);
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
			selectAllBoard();
			break;
		case 5:
			break;
		default:	
			System.out.println("[�߸��� �Է��Դϴ�.]");
		}
	}
	
	private void selectAllBoard() {
		// ��ü �Խñ� ��ȸ 
		List<BoardVo> boardList = boardService.getBoardList();
		
		for(BoardVo tmp : boardList) {
			System.out.println(tmp);
		}
		
	}


	private void deleteBoard() {
		// ������ �Խñ� ���� (�Խñ� ��ȣ, ����)
				Scanner sc = new Scanner(System.in);
				System.out.print("������ �Խñ� ��ȣ : ");
				int num = sc.nextInt();
				System.out.print("�ۼ��� ���̵� : ");
				String id = sc.next();
				
				BoardVo board = new BoardVo(num, null, id);
				
				if(boardService.deleteBoard(board)) {
					System.out.println("[�Խñ� ���� ����]");
				}else {
					System.out.println("[�Խñ� ���� ����]");
				}
		
	}

	private void updateBoard() {
		// ������ �Խñ� ���� (�Խñ� ��ȣ, ����)
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Խñ� ��ȣ : ");
		int num = sc.nextInt();
		System.out.print("������ �Խñ� ���� : ");
		sc.nextLine();
		String title = sc.nextLine();
		
		BoardVo board = new BoardVo(num, title, null);
		
		if(boardService.updateBoard(board)) {
			System.out.println("[�Խñ� ���� ����]");
		}else {
			System.out.println("[�Խñ� ���� ����]");
		}
	
	}

	private void insertBoard() {
		// �Խñ� ���� �Է� (�ۼ���, �Խñ� ����)
		Scanner sc = new Scanner (System.in);
		System.out.print("���� : ");
		String title = sc.nextLine();
		System.out.print("�ۼ��� : ");
		String id = sc.next();
		
		BoardVo board = new BoardVo(title,id);
		
		if(boardService.insertBoard(board)) {
			System.out.println("[�Խñ� �ۼ� ����]");
		}else {
			System.out.println("[�Խñ� �ۼ� ����]");
		}
		
	}

	private void printMenu() {
		System.out.println("=== �Խ��� �޴� ===");
		System.out.println("1. �Խñ� ���");
		System.out.println("2. �Խñ� ����");
		System.out.println("3. �Խñ� ����");
		System.out.println("4. �Խñ� ��ȸ");
		System.out.println("5. �ڷΰ���");
		System.out.println("================");
		System.out.print("�޴� ���� : ");
	}

}
