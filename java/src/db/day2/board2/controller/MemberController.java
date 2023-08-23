package db.day2.board2.controller;

import java.util.Scanner;

import db.day2.board2.service.MemberService;
import db.day2.board2.service.MemberServiceImp;

public class MemberController {

	private Scanner sc;
	private MemberService memberService;
	
	public MemberController(Scanner sc) {
		this.sc = sc;
		memberService = new MemberServiceImp();
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
			System.out.println("[�߸��� �޴��Դϴ�.]");	
		}
	}


	private void printMenu() {
		System.out.println("====== ȸ�� �޴� =====");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ�� Ż��");
		System.out.println("3. �ڷ� ����");
		System.out.println("====================");
		System.out.print("�޴� ���� : ");
	}
	
	private void signUp() {
		System.out.println("ID: ");
		String id = sc.next();
		System.out.println("PW: ");
		String pw = sc.next();
		if(memberService.signUp(id,pw)) {
			System.out.println("[ȸ������ ����]");
		}else {
			System.out.println("[ȸ������ ����]");
		}
	}
	
	private void withdraw() {
		System.out.println("ID: ");
		String id = sc.next();
		System.out.println("PW: ");
		String pw = sc.next();
		if(memberService.withdraw(id,pw)) {
			System.out.println("[ȸ��Ż�� ����]");
		}else {
			System.out.println("[ȸ��Ż�� ����]");
		}
	}
	
}