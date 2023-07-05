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
import homework.bookmanage.vo.Library;
import homework.bookmanage.vo.LoanBrowsing;

public class Controller {
	
	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Book> listBook = new ArrayList<>();
	
	public void run() {
		
		int menu = -1;
		String fileName = "src/homework/bookmanage/book.txt";
		loadBook(fileName);
		do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		}while(menu!=EXIT);
		saveBook(fileName);
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
		listBook.get(index).changeState();
		
		
		
	}

	private void loanBook() {
		System.out.println("Please enter the information of the book you want to loan");
		System.out.print("Bookname, BookAuthor");
		sc.nextLine();
		String name = sc.nextLine();
		//sc.nextLine();
		String author = sc.next();
		

		// 대출하고자 하는 책과 같은 책의 권수
		Stream<Book> bookstream = listBook.stream();
		int count = (int) bookstream.filter(s->s.getBookName().equals(name) && s.getBookAuthor().equals(author)).count();
		
		// 대출하고자 하는 책 중 대출 가능한 권 수 
		bookstream = listBook.stream();
		int proLoan = (int) bookstream.filter(s->s.getBookName().equals(name) && s.getBookAuthor().equals(author) && s.getState().equals("Available")).count();
		
		// 대출하는 책의 번호
		// 총 권수 7권 대출 가능 권수 5권 >> 대출될 책 번호 count - proLoan + 1
		System.out.println(name + ": " + count + "/" + proLoan);
		
		if(proLoan > 0) {
		
			System.out.println("Please enter the book number of the book you want to check out");
			int num = sc.nextInt();
			// 입력한 도서번호의 책을 불러와서 대출되었다고 출력하고
			// 대출한 책의 상태를 대출 중으로 변환

			int index = listBook.indexOf(new Book(null, null, null,num));
			Date loanDate = new Date();
			listBook.get(index).changeState();
			LoanBrowsing lb 
			= new LoanBrowsing(listBook.get(index) , loanDate , 14);
			
			System.out.println("Success!!");
			System.out.println("Loan Date : " + lb.getLoanDateStr());
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
		// 도서 번호,,는 어떻게 지정할 것인지 >> 등록 순서대로
		Book tmp = new Book(name, author, ISBM,num);
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
