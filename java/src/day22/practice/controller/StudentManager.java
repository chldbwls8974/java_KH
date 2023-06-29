package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class StudentManager implements Program{
	private Scanner sc = new Scanner(System.in);		
	private List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
			);
	
	public void run() {
		printMenu();
		int menu = sc.nextInt();
		runMenu(menu);
	}
	
	
	public void printMenu() {
		System.out.println("람다식 없이 실행 중....");
		System.out.println("1. 학생 전체출력");
		System.out.println("2. 학생 학년출력");
		System.out.println("3. 학생 검색출력");
		System.out.println("4. 종료");
		
		System.out.println("===========");
		System.out.print("메뉴를 입력하세요: ");
		
	}
	
	
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			System.out.println(list);
			break;
		case 2: 
			printGrade();
			break;
		case 3: 
			search();
			break;
		case 4: break;
		default:
		}
	}


	private void printGrade() {
		System.out.println("검색할 학년 입력");
		int grade = sc.nextInt();
		
		for(Student tmp: list) {
			if(tmp.getGrade() == grade) {
				System.out.println(tmp);
			}
		}
	}


	public void search() {
		//int index = 0;
		System.out.println("grad");
		int grade = sc.nextInt();
		System.out.println("classnum");
		int classnum = sc.nextInt();
		System.out.println("num");
		int num = sc.nextInt();
		
		
		for(Student tmp: list) {
			if(tmp.equals(new Student(grade, classnum, num, ""))) {
				System.out.println(tmp);
			}
		}
	}
}
