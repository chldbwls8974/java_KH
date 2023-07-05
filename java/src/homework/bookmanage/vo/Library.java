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
	
	// ������ : ���� ��¥
	// �ݳ� ������ : ���� ��¥ + 14��
	// �ݳ� ���� : ���� ��¥
	// > ����� �ݳ��� å �ѱ��ѱǿ� �Ҵ�.. 
	
	// ���� ������ ������
	// ���� �̸�, ����, ������ȣ�� ���� Ȯ�� �� ����
	
	public void loan(String bookName, String author) {
		// �����ϰ���� å �̸��� ���� �Է�
		// �����ϰ� �ִ� å �Ǽ��� ���� ������ å �Ǽ� ���
		// ���� ���Ⱑ���� å�� ���ٸ�, �Ұ����ϴٰ� ���
		// ������ �����ϴٸ� ����ϷḦ ����ϰ� ���� ������ å �Ǽ� ����
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
