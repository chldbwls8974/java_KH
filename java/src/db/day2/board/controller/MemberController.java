package db.day2.board.controller;

import java.sql.Connection;
import java.util.Scanner;

import db.day2.board.service.MemberService;
import db.day2.board.service.MemberServiceImp;

public class MemberController {

	private Connection con;
	private Scanner sc;
	private MemberService memberService;
	
	public MemberController(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
		memberService = new MemberServiceImp(con,sc);
	}

	public void run() {
		
		int menu;
		final int EXIT = 3;
		
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
			System.out.println("[잘못된 메뉴입니다.]");	
		}
	}


	private void printMenu() {
		System.out.println("====== 회원 메뉴 =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원 탈퇴");
		System.out.println("3. 뒤로 가기");
		System.out.println("====================");
		System.out.print("메뉴 선택 : ");
	}
	
	private void signUp() {
		System.out.println("ID: ");
		String id = sc.next();
		System.out.println("PW: ");
		String pw = sc.next();
		if(memberService.signUp(id,pw)) {
			System.out.println("[회원가입 성공]");
		}else {
			System.out.println("[회원가입 실패]");
		}
	}
	
	private void withdraw() {
		System.out.println("ID: ");
		String id = sc.next();
		System.out.println("PW: ");
		String pw = sc.next();
		if(memberService.withdraw(id,pw)) {
			System.out.println("[회원탈퇴 성공]");
		}else {
			System.out.println("[회원탈퇴 실패]");
		}
	}
	
}
