package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class StudentManager3 {
	private Scanner sc = new Scanner(System.in);		
	private List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
			);
	private Stream<Student> stream = list.stream();
	
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
			stream = list.stream();
			stream.forEach(name -> System.out.println(name));
			break;
		case 2: 
			System.out.print("input grade: ");
			final int grade1 = sc.nextInt();
			stream = list.stream();
			stream.filter(s -> s.getGrade() == grade1).forEach(name -> System.out.println(name));
			break;
		case 3: 
			System.out.println("input grade, classnum, num: ");
			final int grade2 = sc.nextInt();
			final int classnum2 = sc.nextInt();
			final int num2 = sc.nextInt();
			stream = list.stream();
			/*
			stream.filter(s -> s.getGrade() == grade2 && s.getClassNum()==classnum2 && s.getNum() == num2)
			.forEach(name -> System.out.println(name));
			*/
			stream.filter(s -> s.equals(new Student(grade2, classnum2, num2,null))).forEach(name -> System.out.println(name));
			break;
		case 4: break;
		default:
		}
	}



}
