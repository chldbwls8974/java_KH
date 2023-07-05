package homework.bookmanage.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6218734392462901994L;
	private String bookName;
	private String bookAuthor;
	private String bookISBM;
	private int bookNum;
	private String state;
	
	public Book(String bookName, String bookAuthor, String bookISBM, int bookNum) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookISBM = bookISBM;
		this.bookNum = bookNum;
		this.state = "Available";
	}


	// 대출 상태 변환
	public void changeState() {
		if(state.equals("Available")) {
			this.state = "on loan";
			return;
		}
		if(state.equals("on loan")) {
			this.state = "Available";
			return;
		}
		
	}
	
	public String toString() {
		return "bookName: " + bookName + "\n" + "bookAuthor: " + bookAuthor + "\n" + "bookISBM: " + bookISBM + "\n" + "bookNum: " + bookNum + "\n" + state;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookNum == other.bookNum;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookNum);
	}
	
	
}
