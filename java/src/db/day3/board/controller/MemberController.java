package db.day3.board.controller;

import java.util.Scanner;

import db.day3.board.service.MemberService;
import db.day3.board.service.MemberServiceImp;
import db.day3.board.vo.MemberVo;

public class MemberController {
	private MemberService memberService = new MemberServiceImp();

	public void run() {
		int menu;
		final int EXIT = 3;
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
			signUp();
			break;
		case 2: 
			withdraw();
			break;
		case 3:
			break;
		default:
			System.out.println("[잘못된 입력입니다.]");
		}
	}

	private void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		
		MemberVo member = new MemberVo(id,pw);
		
		if(memberService.withdraw(member)) {
			System.out.println("[회원 탈퇴 성공]");
		}else {
			System.out.println("[회원 탈퇴 실패]");
		}
	}

	private void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		System.out.print("비번확인 : ");
		String pw2 = sc.next();
		// 비번과 비번확인이 일치하지 않으면 종료
		if(!pw.equals(pw2)) {
			System.out.println("[비번 불일치]");
			return;
		}
		MemberVo member = new MemberVo(id,pw);
		if(memberService .signUp(member)) {
			System.out.println("[회원 가입 성공]");
		}else {
			System.out.println("[회원 가입 실패]");
		}
		
	}

	private void printMenu() {
		System.out.println("==== 회원 메뉴 ====");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 탈퇴");
		System.out.println("3. 뒤로가기");
		System.out.println("================");
		System.out.print("메뉴 선택 : ");
	}


}
