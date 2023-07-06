package homework.bookmanage.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Stream;

import homework.bookmanage.vo.Book;
import homework.bookmanage.vo.LoanBrowsing;

public class Controller {
	
	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Book> listBook = new ArrayList<>();
	private ArrayList<LoanBrowsing> listLoan = new ArrayList<>();
	
	public void run() {
		
		int menu = -1;
		String bookFileName = "src/homework/bookmanage/book.txt";
		String loanFileName = "src/homework/bookmanage/loan.txt";
		loadBook(bookFileName);
		loadLoan(loanFileName);
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
		saveBook(bookFileName);
		saveLoan(loanFileName);
	}
	
	private void saveLoan(String fileName) {
		try(
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
					for(LoanBrowsing tmp : listLoan) {
						oos.writeObject(tmp);
					}
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}
	
	private void loadLoan(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				LoanBrowsing tmp = (LoanBrowsing)ois.readObject();
				listLoan.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot file import!");
		}catch(EOFException e) {
			System.out.println("File Read Complete!");
		}catch (IOException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Loan Class not found");
		} 	
		System.out.println(listBook);
		
	}
	
	
	

	private void saveBook(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Book tmp : listBook) {
					oos.writeObject(tmp);
				}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	private void loadBook(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				Book tmp = (Book)ois.readObject();
				listBook.add(tmp);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Cannot file import!");
		}catch(EOFException e) {
			System.out.println("File Read Complete!");
		}catch (IOException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Book Class not found");
		} 	
		System.out.println(listBook);
			
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			addBook();
			break;
		case 2: 
			loanBook(); 
			break;
		case 3: 
			returnBook(); 
			break;
		case 4: break;
		
		}
	}

	private void returnBook() {

		System.out.println("Please enter the information of the book you want to return");
		System.out.print("BookNum");
		int num = sc.nextInt();
		
		int index = listBook.indexOf(new Book(null, null, null,num));
		if(index == -1) {
			System.out.println("������ ������ �ƴմϴ�.");
			return;
		}
		
//		LoanBrowsing lb 
//		= new LoanBrowsing(listBook.get(index) , null , 14);
		listBook.get(index).changeState();
//		
		System.out.println("Success!!");
//		System.out.println("�ݳ��� : " + lb.getReturnDateStr());
		Book changeState = listBook.get(index);
//		listBook.get(index).changeState();
		
		
		
		int lbIndex = listLoan.lastIndexOf(new LoanBrowsing(changeState, null, 14));
		System.out.println(lbIndex);
		
		LoanBrowsing tmpLb = listLoan.get(lbIndex);
		tmpLb.setReturnDate(new Date());
		System.out.println("������ : " + tmpLb.getLoanDateStr());
		System.out.println("�ݳ��� : " + tmpLb.getReturnDateStr());
		
	}

	private void loanBook() {
		System.out.println("Please enter the information of the book you want to loan");
		System.out.print("Bookname, BookAuthor");
		sc.nextLine();
		String name = sc.nextLine();
		//sc.nextLine();
		String author = sc.next();
		

		// �����ϰ��� �ϴ� å�� ���� å�� �Ǽ�
		Stream<Book> bookstream = listBook.stream();
		int count = (int) bookstream.filter(s->s.getBookName().equals(name) && s.getBookAuthor().equals(author)).count();
		
		// �����ϰ��� �ϴ� å �� ���� ������ �� �� 
		bookstream = listBook.stream();
		int proLoan = (int) bookstream.filter(s->s.getBookName().equals(name) && s.getBookAuthor().equals(author) && s.getState().equals("Available")).count();
		
		// �����ϴ� å�� ��ȣ
		// �� �Ǽ� 7�� ���� ���� �Ǽ� 5�� >> ����� å ��ȣ count - proLoan + 1
		System.out.println(name + ": " + count + "/" + proLoan);
		
		if(proLoan > 0) {
		
			System.out.println("Please enter the book number of the book you want to check out");
			int num = sc.nextInt();
			// �Է��� ������ȣ�� å�� �ҷ��ͼ� ����Ǿ��ٰ� ����ϰ�
			// ������ å�� ���¸� ���� ������ ��ȯ

			int index = listBook.indexOf(new Book(null, null, null,num));
			Date loanDate = new Date();
			listBook.get(index).changeState();
			LoanBrowsing lb 
			= new LoanBrowsing(listBook.get(index) , loanDate , 14);
			
			System.out.println("Success!!");
			System.out.println("������ : " + lb.getLoanDateStr());
			System.out.println("�ݳ� ������ : " + lb.getEstiReturnDateStr());
			return;
		}
		
		System.out.println("impossible to borrow");
		
	}

	private void addBook() {
		System.out.println("Please enter the information of the book you want to add");
		sc.nextLine();
		String name = sc.nextLine();
		String author = sc.next();
		String ISBM = sc.next();
		int num = sc.nextInt();
		// ���� ��ȣ,,�� ��� ������ ������ >> ��� �������
		Book tmp = new Book(name, author, ISBM,num);
		
		// ������ȣ �ߺ� üũ
		if(listBook.contains(tmp)) {
			System.out.println("�̹� ��ϵ� ���� ��ȣ�Դϴ�. Ȯ�����ּ���.");
			return;
		}
		
		listBook.add(tmp);
		System.out.println(listBook);
	}

	private void printMenu() {
		System.out.println("1. add book");
		System.out.println("2. a book loan");
		System.out.println("3. return of books");
		System.out.println("4. exit");
	}

	



}
