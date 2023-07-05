package homework.bookmanage.vo;

import java.util.ArrayList;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class Library {
	private String state; // loan, return
	private ArrayList<Book> lib = new ArrayList<>();
//	private String loanDate;
//	private String EstimatedReturnDate;
//	private String ReturnDate;
	
	// 대출일 : 현재 날짜
	// 반납 예정일 : 현재 날짜 + 14일
	// 반납 일자 : 현재 날짜
	// > 대출과 반납은 책 한권한권에 할당.. 
	
	// 같은 도서가 여러권
	// 도서 이름, 저자, 도서번호로 상태 확인 및 변경
	
	public void loan(String bookName, String author) {
		// 대출하고싶은 책 이름과 저자 입력
		// 보유하고 있는 책 권수와 대출 가능한 책 권수 출력
		// 만약 대출가능한 책이 없다면, 불가능하다고 출력
		// 대출이 가능하다면 대출완료를 출력하고 대출 가능한 책 권수 차감
		Stream<Book> bookstream = lib.stream();
		int count = (int) bookstream.filter(s->s.getBookName() == bookName && s.getBookAuthor() == author).count();
		bookstream = lib.stream();
		int proLoan = (int) bookstream.filter(s->s.getBookName() == bookName && s.getBookAuthor() == author && s.getState().equals("Available")).count();
		
		System.out.println(bookName + ": " + count + "/" + proLoan);
		
		if(proLoan > 0) {
			return;
		}
		
		System.out.println("Loan is not available.");
	}
}
