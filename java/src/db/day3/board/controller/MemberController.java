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
			System.out.println("[�߸��� �Է��Դϴ�.]");
		}
	}

	private void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��� : ");
		String pw = sc.next();
		
		MemberVo member = new MemberVo(id,pw);
		
		if(memberService.withdraw(member)) {
			System.out.println("[ȸ�� Ż�� ����]");
		}else {
			System.out.println("[ȸ�� Ż�� ����]");
		}
	}

	private void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String id = sc.next();
		System.out.print("��� : ");
		String pw = sc.next();
		System.out.print("���Ȯ�� : ");
		String pw2 = sc.next();
		// ����� ���Ȯ���� ��ġ���� ������ ����
		if(!pw.equals(pw2)) {
			System.out.println("[��� ����ġ]");
			return;
		}
		MemberVo member = new MemberVo(id,pw);
		if(memberService .signUp(member)) {
			System.out.println("[ȸ�� ���� ����]");
		}else {
			System.out.println("[ȸ�� ���� ����]");
		}
		
	}

	private void printMenu() {
		System.out.println("==== ȸ�� �޴� ====");
		System.out.println("1. ȸ�� ����");
		System.out.println("2. ȸ�� Ż��");
		System.out.println("3. �ڷΰ���");
		System.out.println("================");
		System.out.print("�޴� ���� : ");
	}


}
