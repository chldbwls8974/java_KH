package homework.attendancebook.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Attendance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3257592784573494059L;
	// 학생을 추가하고
	// 날짜를 입력 받고
	// 그 날짜에 학생의 출석 여부를 입력받고
	// 날짜별로 출력한다.
	
	private Date date;
	private Student std;
	private boolean attendance;
	
	// 생성자
	public Attendance(Date date, Student std, char state ) {
		this.date = date;
		this.std = std;
		this.attendance = state == 'O'?true:false;
	}
	
	public String toString() {
		return std.toString() + " : " + (attendance ? "O" :"X"); 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(date, other.date) && Objects.equals(std, other.std);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, std);
	}
	
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
}
