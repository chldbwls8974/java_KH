package homework.bookmanage.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class LoanBrowsing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7917027580320843458L;
	/**
	 * 
	 */
	private Book book;//대출 도서
	private Date loanDate;//대출일
	private Date estiReturnDate;
	private Date returnDate;//반납일

	public LoanBrowsing(Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
		// 대출 기한을 이용하여 반납 예정일을 추가
		calculateReturnDate(loanPeriod);
	}

	private void calculateReturnDate(int loanPeriod) {
		if(loanDate == null) {
			return;
		}
		Long loanDateMs = loanDate.getTime(); // 대출일을 ms로 환산
		Long periodMs = loanPeriod * 24 * 60 * 60 * 1000L; 
		// new Date >>  현재 시간을 Date 객체로 생성
		// new Date(Long a) >> 1970년 1월 1일 0시를 기준으로 a밀리초만큼 흐른 날짜
		estiReturnDate = new Date(loanDateMs + periodMs);
	}

	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}

	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(returnDate);
	}
	
	public String getEstiReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(estiReturnDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(book);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanBrowsing other = (LoanBrowsing) obj;
		return Objects.equals(book, other.book);
	}



}
