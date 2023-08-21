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
		// 게시글 등록, 수정, 삭제, 게시글 리스트 조횐
		
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
				System.out.println("[잘못된 메뉴 입니다.]");
		}
		
	}
	
	private void deleteBoard() {
		// 게시글 삭제
		// 삭제할 게시글.. 제목으로 삭제
		System.out.print("삭제할 게시글 번호 : ");
		int index = sc.nextInt();
		System.out.print("삭제할 제목을 입력 :");
		sc.next();
		String title = sc.nextLine();
		System.out.print("작성자 아이디 : ");
		String id = sc.next();
		if(boardService.deleteBoard(index, title,id)) {
			System.out.println("[게시글 삭제 성공]");
		}else {
			System.out.println("[게시글 삭제 실패]");
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
		
		// 제목, 작성자 아이디 
		System.out.print("제목 : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("아이디 : ");
		String id = sc.next();
		if(boardService.insertBoard(title,id)) {
			System.out.println("[게시글 작성 성공]");
		}else {
			System.out.println("[게시글 작성 실패]");
		}
	}

	private void printMenu() {
		System.out.println("==== 게시판 메뉴 ====");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 확인");
		System.out.println("5. 뒤로가기");
		System.out.println("==================");
		System.out.print("메뉴 선택 : ");
	}

}
