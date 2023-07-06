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
		System.out.println("===== �⼮ =====");
		System.out.print("��¥�� �Է��ϼ���. (���� : yyyy-MM-dd)");
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
			System.out.println("��¥ ������ �ƴմϴ�.");
			return;
		}
		
		List<Student> stdList = book.getStdList();
		
		for(Student tmp : stdList) {
			System.out.println(tmp  + ":");
			char state;
			do {
				state =sc.next().charAt(0);
			}while(state!= 'O' && state!= 'X');
		
			//�⼮�ο� üũ
			// �л� ����, ����� �̿��Ͽ� �⼮ ��ü�� ����
			// ���߿� �л� ���� ����� �߰��ǵ� ���� �⼮ ����� �����Ǹ� �ȵǱ� ������ ���� �����ڸ� �̿�
			Attendance check = new Attendance(date,new Student(tmp),state);
		
			if(!book.insertAttendance(check)) {
				System.out.println("�̹� ��ϵ� �⼮�Դϴ�.");
			} else {
				System.out.println("�⼮ üũ�� �߽��ϴ�.");
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
		System.out.println("�л� ���");
		System.out.println("�л� ��ȣ�� �̸��� �Է��ϼ���.");
		String num = sc.next();
		String name = sc.next();
		
		Student tmp = new Student(num, name);
		boolean insertSuccess = book.addStudent(tmp);
		
		if(insertSuccess) {
			System.out.println("�л� ���� �߰� ����");
		} else
			System.out.println("�л� ���� �߰� ����");
		stdList.add(tmp);
	}


	private void printMenu() {
		System.out.println("1. �л����");
		System.out.println("2. �⼮");
		System.out.println("3. �⼮�� Ȯ��");
		System.out.println("4. ����");
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
		System.out.println(book.getList());		// ���߿� �ּ�ó��
		
	}
}
