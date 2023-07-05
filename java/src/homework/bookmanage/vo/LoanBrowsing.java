package homework.bookmanage.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanBrowsing implements Serializable {

	/**
	 * 
	 */
	private Book book;//���� ����
	private Date loanDate;//������
	private Date estiReturnDate;
	private Date returnDate;//�ݳ���

	public LoanBrowsing(Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
	}

	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(loanDate);
	}
}
