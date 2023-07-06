package homework.manager.student.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Interview implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9209538671229053466L;
	private Date date;
	private Student student;
	private String interview;
	
	
	public Interview(Date date, Student student, String interview) {
		this.date = date;
		this.student = student;
		this.interview = interview;
	}

	
	public void update(Date date, String interview) {
		this.date = date;
		this.interview = interview;
	}
	
	public String toString() {
		return interview;
	}
}
