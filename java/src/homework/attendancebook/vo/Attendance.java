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
	// �л��� �߰��ϰ�
	// ��¥�� �Է� �ް�
	// �� ��¥�� �л��� �⼮ ���θ� �Է¹ް�
	// ��¥���� ����Ѵ�.
	
	private Date date;
	private Student std;
	private boolean attendance;
	
	// ������
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
