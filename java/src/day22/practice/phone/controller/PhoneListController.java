package day22.practice.phone.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import day22.practice.phone.vo.PhoneList;

public class PhoneListController {

	
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 5;
	private ArrayList<PhoneList> list = new ArrayList<>();
	private Stream<PhoneList> stream = list.stream();
	
	public void run() {
		int menu = -1;
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
		
		
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			addPhone();
			break;
		case 2: 
			modifyPhone();
			break;
		case 3: 
			searchPhone();
			break;
		case 4: 
			printPhoneList();
			break;
		default:
		}
	}

	private void printPhoneList() {
		for(PhoneList tmp : list) {
			System.out.println(tmp);
		}
	}

	private void searchPhone() {
		System.out.println("====================");
		System.out.println("검색하실 번호의 정보를 입력하세요.");
		String phone = sc.next();
		
		for(PhoneList tmp : list) {
			if(list.equals(phone)) {
				System.out.println(tmp);
			}
		}
	}

	private void modifyPhone() {
		System.out.println("====================");
		System.out.println("수정할 번호의 정보를 입력하세요 (이름과 번호)");
		String name = sc.next();
		//sc.next();
		String phone = sc.next();
		
		PhoneList tmp = new PhoneList(name, phone);
		
		int index = list.indexOf(tmp);
		if(index == -1) {
			System.out.println("====================");
			System.out.println("수정할 번호가 없습니다.");
			return;
		}
		
		System.out.println("수정할 번호의 정보를 입력하세요 (이름과 번호)");
		name = sc.next();
		//sc.next();
		final String phone1 = sc.next();
		
		//tmp = new PhoneList(name, phone1); // 새로 입력 받은것으로 생성한거
		
		stream = list.stream();
		int count = (int) stream.filter(s -> s.equals(new PhoneList(null,phone1))).count();
		
		// 핸드폰 번호만 비교
		if(count != 0) {
			System.out.println("====================");
			System.out.println("이미 있는 번호입니다..");
			return;
		}
		
		list.get(index).update(name, phone1);
	}

	private void addPhone() {
		System.out.println("====================");
		System.out.println("추가할 번호의 정보를 입력하세요 (이름과 번호)");
		String name = sc.next();
		String phone = sc.next();
		
		PhoneList tmp = new PhoneList(name, phone);
		
		if(!list.contains(tmp)) {
			list.add(tmp);
			System.out.println("====================");
			System.out.println("추가되었습니다.");
			return;
		}
		System.out.println("====================");
		System.out.println("실패");
	}
	
	private void checkNum() {
		
	}

	private void printMenu() {
		System.out.println("====================");
		System.out.println("1. 추가");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 전체 조회");
		System.out.println("5. 나가기");
		System.out.println("====================");
		System.out.print("input menu : ");
	}
}
