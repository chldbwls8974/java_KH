package day13.homeword.controller;

import java.util.Scanner;

import day13.homework.vo.VocabularyNote;




public class VocabularyNoteController {
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	
	public void run() {
		int menu;
		
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = sc.nextInt();
			// 메뉴에 따른 기능 실행
			runMenu(menu);
	
		} while(menu!=5);
		sc.close();
	}

	/** 메뉴를 출력하는 메서드
	 * 
	 */
	private void printMenu() {

		System.out.println("========== menu ==========");
		System.out.println("1. add word");
		System.out.println("2. delete word");
		System.out.println("3. modify word");
		System.out.println("4. print word");
		System.out.println("5. exit");
		System.out.println("==========================");
		System.out.print("input number of menu you want to work : ");
	}
	
	/** 메뉴에 따른 기능을 실행하는 메서드
	 * 매개변수 : 선택한 메뉴 > int
	 * 리턴타입 : void
	 * 메서드명 : runMenu
	 */
	private void runMenu(int menu) {
		
		switch(menu) {
		// 메뉴가 1이면 단어 추가 기능 실행
		case 1:
			insertWord();
			break;
			
			
		// 메뉴가 2이면 단어 삭제 기능 실행
		case 2:
			deleteWord();
			break;
			
			
		// 메뉴가 3이면 단어 수정 기능 실행
		case 3:
			updateWord();
			break;
			
			
		// 메뉴가 4이면 단어 출력 기능 실행
		case 4:
			printWord();
			break;
			
			
		// 메뉴가 5이면 프로그램 종료
		case 5:
			break;
			
			
		// 메뉴가 그 외이면 잘못된 메뉴라고 출력
		default:
		}
	
		
	}

	
	private void updateWord() {
		// 서브메뉴 출력
		printSubMenuUpdate();
		// 서브메뉴 출력
		int submenu = sc.nextInt();
		
		// 서브메뉴에 따른 기능 실행
		switch(submenu) {
		// 단어 수정
		case 1:
			// 수정할 단어
			System.out.println("==========================");
			System.out.print("Enter the word you want to modify : ");
			String word = sc.next();
			
			// 수정될 단어
			System.out.print("Enter the new word : ");
			String updateWord = sc.next();
			System.out.println("==========================");
			
			// 단어장에 있는 단어 수정 기능을 실행
			if(note.updateTitle(word, updateWord)) {
				System.out.println("success to modify");
			}
			else System.out.println("Failed");
			break;
			
		// 뜻 수정
		case 2:
			// 뜻을 수정할 단어를 입력
			System.out.println("==========================");
			System.out.print("Enter the word you want to modify : ");
			String title = sc.next();
			
			// 단어 출력하고 단어가 없으면 안내문구 출력 후 종료
			if(note.search(title)) {
				System.out.println("==========================");
				System.out.println("not found");
				System.out.println("==========================");
				return;
			}
			
			// 수정할 뜻의 번호 입력
			System.out.print("Enter the number of meaning you want to modify : ");
			int num = sc.nextInt();
			
			sc.nextLine();
			
			// 수정될 뜻 입력
			System.out.print("Enter the meaning you want to modify : ");
			String meaning = sc.nextLine();
			System.out.println("==========================");
			
			// 단어장에서 수정
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("Failed modification meaning");
			}
			else System.out.println("success to modify meaning");
			break;
			
			
			// 뜻 삭제
		case 3:
			// 뜻을 작제할 단어를 입력.
			System.out.println("==========================");
			System.out.print("Enter the word you want to delete : ");
			String title2 = sc.next();
						
			// 단어 출력하고 단어가 없으면 안내문구 출력 후 종료
			if(note.search(title2)) {
				System.out.println("==========================");
				System.out.println("not found");
				System.out.println("==========================");
				return;
			}
						
			// 수정할 뜻의 번호 입력
			System.out.print("Enter the number of meaning you want to modify : ");
			int num2 = sc.nextInt();
			System.out.println("==========================");
			if(!note.deleteMeaning(title2, num2)) {
			System.out.println("Failed delete meaning");
			}
			else {System.out.println("success to delete meaning");}
			
			break;
		}
	}
	

	
	private void printSubMenuUpdate() {
		System.out.println("======== sub menu ========");
		System.out.println("1. modify word");
		System.out.println("2. modify meaning");
		System.out.println("3. delete meaning");
		System.out.println("==========================");
		System.out.print("Enter the number of menu");
	}

	private void deleteWord() {
		// 삭제할 단어 입력
		System.out.print("Eneter the word you want to delete : ");
		String title = sc.next();
		// 해당 단어 삭제
		if(note.delete(title)) {
			System.out.println("success to delete");
		}
		else System.out.println("failed");
	}

	private void insertWord() {
		// 추가할 단어 입력
		System.out.print("Enter Word : ");
		String title = sc.next();
		
		// 단어에서 입력한 엔터 처리
		sc.nextLine(); 
		
		// 추가할 뜻을 입력
		System.out.print("Enter Meaning : ");
		String meaning = sc.nextLine();
		
		// 단어장에 추가
		int result = note.insert(title, meaning);
		
		switch(result) {
		case 1: System.out.println("success to add word"); break;
		case -1: System.out.println("success to add meaning"); break;
		case 0: System.out.println("Failed"); break;
		}
	}

	private void printWord() {
		// 서브메뉴출력
		printSubMenuPrint();
		
		// 서브메뉴 선택
		int submenu = sc.nextInt();
		
		switch(submenu) {
		// 서브메뉴가 1이면 전체 출력
		case 1:
			note.print();
			break;
		
		// 서브 메뉴가 2이면 검색
		case 2:
			// 검색할 단어 입력
			System.out.print("Enter the word you want to find : ");
			String title = sc.next();
			// 출력
			note.search(title);
			break;
		}
	}

	private void printSubMenuPrint() {
		System.out.println("======== sub menu ========");
		System.out.println("1. print whole word");
		System.out.println("2. search word");
		System.out.println("==========================");
		System.out.print("Enter the number of menu : ");
	}

	
	
}
