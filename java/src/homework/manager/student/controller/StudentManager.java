package homework.manager.student.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import homework.manager.student.vo.Student;

public class StudentManager implements Program {


	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	private ArrayList<Student> list = new ArrayList<>();
	private Student std = new Student();
	private int min = 1;
	private int max = 5;
	private Stream<Student> listStream = list.stream();
	
	public void run() {
		int menu = -1;
		load();
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
		save();
	}
	
	private void save() {
		// 학생정보 저장
		// >> 리스트 >> 하나씩 꺼내서 저장
		// 저장 >> outputstream
		// 객체단위로 저장 >> objectoutputstream
		
		try(FileOutputStream fos = new FileOutputStream("src/homework/manager/student/student.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)	){
					for(Student tmp: list) {
						oos.writeObject(tmp);
					}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/homework/manager/student/student.txt"))){
			while(true) {
				Student tmp = (Student)ois.readObject();
				list.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No files to import.");
		}catch(EOFException e) {
			System.out.println("File Read Complete!");
		}catch (IOException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("Student Class not found");
		} 		
	}

	private void printMenu() {
		System.out.println("1.add new Student");
		System.out.println("2.Inquiry Student");
		System.out.println("3.Search Student");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			addStudent();
			break;
		case 2: 
			inquiryStudent(); 
			break;
		case 3: 
			searchStudent(); 
			break;
		case 4: break;
		
		}
	}

	private void inquiryStudent() {
		System.out.println("===== Inquiry =====");
		System.out.println("1.whole student");
		System.out.println("2.grade");
		System.out.println("3. grade and class");
		System.out.println("=========================");
		System.out.print("input menu: ");
		int menu = sc.nextInt();
		
		
		switch(menu) {
		case 1: 
			listStream = list.stream();
			listStream.forEach(name -> System.out.println(name));
			break;
		case 2:
			System.out.println("input grade.");
			final int grade1 = sc.nextInt();
			listStream = list.stream();
			listStream.filter(s -> s.getGrade() == grade1).forEach(name -> System.out.println(name));
			break;
		case 3:
			System.out.println("input grade");
			final int grade2 = sc.nextInt();
			System.out.println("input classnum");
			final int classnum2 = sc.nextInt();
			listStream = list.stream();
			listStream.filter(s -> s.getGrade() == grade2 && s.getClassNum() == classnum2).forEach(name -> System.out.println(name));
			break;
		}
		
	}

	
	private void addStudent() {
		System.out.println("========= ADD STUDENT =========");
		System.out.print("Input grade, name, address: ");
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
			System.out.println("Success!!");
		}
	}

	
	private void searchStudent() {
		System.out.println("Input want to search student information");
		System.out.println("grade, classnum, name: ");
		int grade =sc.nextInt();
		int classNum = sc.nextInt();
		String name1 = sc.next();
		listStream = list.stream();
		listStream.filter(s -> s.equals(new Student(grade, classNum, 0, name1, null))).forEach(name -> System.out.println(name));
		
		System.out.println("Would you like to open the Student Management menu? (y/n)");
		char ans = sc.next().charAt(0);
		if(ans == 'y') {
			manageStudent();
		}
		else System.out.println("FINISHED!!");
	}

	private void manageStudent() {
		// 나가기 누를때까지 반복문 추가
		System.out.println("======== Student Management =======");
		System.out.println("1. delete student"); // �빐�떦 �븰�깮 �궘�젣 
		System.out.println("2. inquiry interview");
		System.out.println("3. inquiry score");
		System.out.print("input menu : ");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			deleteStudent();
			break;
		case 2:
			interviewManage();
			break;
		case 3:
			scoreManage();
			break;
			default:
				System.out.println("�옒紐� �엯�젰�븯�뀲�뒿�땲�떎.");
		}
	}

	
	private void interviewManage() {
		System.out.println("1. inquiry interview");
		System.out.println("2. add interview");
		System.out.print("input menu");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			std.printInterview();
			break;
		case 2:
			std.addInterview(); 
			break;
		case 3:
			
			default:
				System.out.println("Exit the Student Management Menu");
		}
	}

	private void deleteStudent() {
		System.out.println("enter student information you want to delete");
		System.out.println("grade, classNum, name");
		int grade = sc.nextInt();
		int classNum = sc.nextInt();
		String name = sc.next();
		Student tmp = new Student(grade, classNum, 0, name, null);
		list.remove(tmp);
		
	}

	private void scoreManage() {
		System.out.println("1. inquiry score");
		System.out.println("2. add score");
		System.out.print("input menu");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			std.printScore();
			break;
		case 2:
			std.addScore(); 
			break;
		case 3:
			
			default:
				System.out.println("Exit the Student Management Menu");
		}
	}

	// �븰�깮 吏꾪븰
	// 諛섎같�젙 �옖�뜡 (1~5諛� �궗�씠�뿉�꽌)
	// 3�븰�뀈�씤 寃쎌슦 議몄뾽 >> �궘�젣
	// if grade媛� 3蹂대떎 �옉�쑝硫� grade + 1, �븘�땲硫� �궘�젣
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
