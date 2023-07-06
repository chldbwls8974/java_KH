package homework.attendancebook.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import homework.attendancebook.vo.Attendance;
import homework.attendancebook.vo.AttendanceBook;
import homework.attendancebook.vo.Student;

public class Controller {
	
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	private AttendanceBook book = new AttendanceBook();
	private ArrayList<Student> stdList = new ArrayList<>();
	private ArrayList<AttendanceBook> bookList = new ArrayList<>();

	public void run() {
		int menu = -1;
		String bookFileName = "src/homework/attendancebook/attendancebook.txt";
		loadBook(bookFileName);
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
		saveBook(bookFileName);
	}


	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			addStudent();
			break;
		case 2: 
			checkAttendance();
			break;
		case 3: 
			printAttendance();
			break;
		case 4: break;
		
		}
	}


	private void printAttendance() {
		book.printAttendance();
	}


	private void checkAttendance() {
		System.out.println("===== 출석 =====");
		System.out.print("날짜를 입력하세요. (형식 : yyyy-MM-dd)");
		String day = sc.next();
//		Date now = new Date();
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		boolean result = Pattern.matches(day, format.format(now));
//		
//		System.out.println(result);
		
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = format.parse(day);
		}catch(ParseException e) {
			System.out.println("날짜 형식이 아닙니다.");
			return;
		}
		
		List<Student> stdList = book.getStdList();
		
		for(Student tmp : stdList) {
			System.out.println(tmp  + ":");
			char state;
			do {
				state =sc.next().charAt(0);
			}while(state!= 'O' && state!= 'X');
		
			//출석부에 체크
			// 학생 정보, 출결을 이용하여 출석 객체를 생성
			// 나중에 학생 삭제 기능이 추가되도 기존 출석 기록은 삭제되면 안되기 때문에 복사 생성자를 이용
			Attendance check = new Attendance(date,new Student(tmp),state);
		
			if(!book.insertAttendance(check)) {
				System.out.println("이미 등록된 출석입니다.");
			} else {
				System.out.println("출석 체크를 했습니다.");
			}
			
			
//		for(int i = 0 ; i < stdList.size() ; i++) {
//			System.out.println(stdList.get(i));
//			char ch = sc.next().charAt(0);
//			if(ch == 'O') {
//				attendance = true;
//			} else {
//				attendance = false;
//			}
		
			//Attendance tmp = new Attendance(now,stdList.get(i),attendance);
		
			
		}
		//System.out.println(book.getList());
	}


	private void addStudent() {
		System.out.println("학생 등록");
		System.out.println("학생 번호와 이름을 입력하세요.");
		String num = sc.next();
		String name = sc.next();
		
		Student tmp = new Student(num, name);
		boolean insertSuccess = book.addStudent(tmp);
		
		if(insertSuccess) {
			System.out.println("학생 정보 추가 성공");
		} else
			System.out.println("학생 정보 추가 실패");
		stdList.add(tmp);
	}


	private void printMenu() {
		System.out.println("1. 학생등록");
		System.out.println("2. 출석");
		System.out.println("3. 출석부 확인");
		System.out.println("4. 종료");
	}


	private void saveBook(String fileName) {
		try(
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					oos.writeObject(book);
			} catch (IOException e) {
				e.printStackTrace();
			}			
	}


	private void loadBook(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
				book= (AttendanceBook)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot file import!");
		}catch(EOFException e) {
			System.out.println("File Read Complete!");
		}catch (IOException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("A Class not found");
		} 	
		System.out.println(book.getList());		// 나중에 주석처리
		
	}
}
