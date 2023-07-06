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
	private Book book;//���� ����
	private Date loanDate;//������
	private Date estiReturnDate;
	private Date returnDate;//�ݳ���

	public LoanBrowsing(Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
		// ���� ������ �̿��Ͽ� �ݳ� �������� �߰�
		calculateReturnDate(loanPeriod);
	}

	private void calculateReturnDate(int loanPeriod) {
		if(loanDate == null) {
			return;
		}
		Long loanDateMs = loanDate.getTime(); // �������� ms�� ȯ��
		Long periodMs = loanPeriod * 24 * 60 * 60 * 1000L; 
		// new Date >>  ���� �ð��� Date ��ü�� ����
		// new Date(Long a) >> 1970�� 1�� 1�� 0�ø� �������� a�и��ʸ�ŭ �帥 ��¥
		estiReturnDate = new Date(loanDateMs + periodMs);
	}

	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(loanDate);
	}

	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(returnDate);
	}
	
	public String getEstiReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
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
