package homework.manager.student.controller;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import homework.manager.student.vo.Student;

public class StudentManager implements Program {
	/* 기본 메뉴 
	 * 학생 등록 -> 입학처리 -> 신규 학생 반배정 랜덤
	 * 학생 조회 -> 전체학생 조회, 학년별 조회, 반별 조회 등등,,,
	 * 학생 검색 -> 학생관리 서브 메뉴
	 * */
	
	/* 서브 메뉴 :: 학생 관리 
	 * 전학 
	 * 		입 : 추가
	 * 		출 : 삭제
	 * 졸업 : 삭제
	 * 진학 : 수정
	 * */
	
	
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	private ArrayList<Student> list = new ArrayList<>();
	private Student std = new Student();
	private int min = 1;
	private int max = 5;
	private Stream<Student> listStream = list.stream();
	
	public void run() {
		int menu = -1;
	
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
	}
	
	private void printMenu() {
		System.out.println("1. 신규 학생 등록");
		System.out.println("2. 학생 조회");
		System.out.println("3. 학생 검색");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			addStudent();
			break;
		case 2: 
			inquiryStudent(); // -> print 한가지만 만들어서 stream을 이용하여 조회할 것
			break;
		case 3: 
			searchStudent(); // -> 검색한 학생에 대한 서브메뉴 출력
			break;
		case 4: break;
		
		}
	}

	private void inquiryStudent() {
		// 학생 조회
		// 전체조회
		// 학년별 조회
		// 반별 조회
		System.out.println("=====학생 조회 서브 메뉴 =====");
		System.out.println("1. 전체 학생 조회");
		System.out.println("2. 학년 별 조회");
		System.out.println("3. 반 별 조회");
		System.out.println("=========================");
		System.out.print("메뉴를 입력하세요 : ");
		int menu = sc.nextInt();
		
		
		switch(menu) {
		case 1: 
			listStream = list.stream();
			listStream.forEach(name -> System.out.println(name));
			//listStream.forEach(name -> System.out.println(name));
			break;
		case 2:
			System.out.println("조회할 학년을 입력하세요.");
			final int grade1 = sc.nextInt();
			listStream = list.stream();
			listStream.filter(s -> s.getGrade() == grade1).forEach(name -> System.out.println(name));
			break;
		case 3:
			System.out.println("조회할 학년을 입력하세요.");
			final int grade2 = sc.nextInt();
			System.out.println("조회할 반을 입력하세요.");
			final int classnum2 = sc.nextInt();
			listStream = list.stream();
			listStream.filter(s -> s.getGrade() == grade2 && s.getClassNum() == classnum2).forEach(name -> System.out.println(name));
			break;
		}
		
		// 조회한 내용을 가지고 가공하는 것은 나중에 생각.
	}

	
	private void addStudent() {
		System.out.println("========= 신규 학생 등록 =========");
		System.out.println("학년과 번호, 이름, 주소를 입력하세요.");
		int grade = sc.nextInt();
		String name = sc.next();
		sc.nextLine();
		String address = sc.nextLine();
		int classnum = random(min,max);
		listStream = list.stream();
		int count = (int) (listStream.filter(s -> s.getGrade() == grade && s.getClassNum() == classnum).count()) + 1;
		
		Student tmp = new Student(grade, classnum, count, name, address);
		
		if(!list.contains(tmp)) {
			list.add(tmp);
			System.out.println("등록 성공!");
		}
	}

	
	// 학생 전출 및 면담,성적 관리 메뉴 연결
	private void searchStudent() {
		System.out.println("검색할 학생의 이름을 입력하세요.");
		String name1 = sc.next();
		listStream = list.stream();
		listStream.filter(s -> s.getName().equals( name1)).forEach(name -> System.out.println(name));
		
		System.out.println("해당 학생 관리 메뉴를 여시겠습니까?");
		char ans = sc.next().charAt(0);
		if(ans == 'y') {
			manageStudent();
		}
		else System.out.println("창을 닫습니다.");
	}

	// 학생 전출 및 면담,성적 관리 메뉴 연결
	private void manageStudent() {
		System.out.println("======== 학생 관리 메뉴 =======");
		System.out.println("1. 학생 전출 및 퇴학"); // 해당 학생 삭제 
		System.out.println("2. 면담 관리");
		System.out.println("3. 성적 관리");
		System.out.print("메뉴를 입력하세요");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			// delete
			break;
		case 2:
			//면담 관리 >> 조회 추가 삭제 수정
			break;
		case 3:
			// 성적 관리 >> 조회 추가 총점 
			System.out.println("성적 관리창에 접근합니다.");
			scoreManage();
			break;
			default:
				System.out.println("잘못 입력하셨습니다.");
		}
	}

	
	private void scoreManage() {
		System.out.println("1. 성적 조회");
		System.out.println("2. 성적 추가");
		System.out.print("메뉴를 입력하세요");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			/// 성적 조회
			break;
		case 2:
			std.addScore(); // 성적 추가
			break;
		case 3:
			
			default:
				System.out.println("잘못 입력하셨습니다.");
		}
	}

	// 학생 진학
	// 반배정 랜덤 (1~5반 사이에서)
	// 3학년인 경우 졸업 >> 삭제
	// if grade가 3보다 작으면 grade + 1, 아니면 삭제
	private void gradeUp() {
		
	}
	
	private int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()* (max - min + 1) + min);
	}
	
	

}
