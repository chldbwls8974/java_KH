package homework.manager.student.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Interview implements Serializable{
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9209538671229053466L;
	private String date;
	private String interview;
	
	
	public Interview(String date, String interview) {
		this.date = date;
		this.interview = interview;
	}

	
	public void update(String date, String interview) {
		this.date = date;
		this.interview = interview;
	}
}
