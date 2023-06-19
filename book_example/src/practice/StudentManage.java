package practice;

import lombok.Data;

@Data
public class StudentManage {
	
	private static int serialNum = 1100; //고유번호
	String studentId;
	String studentName;
	int residentYear;
	String address;
	

	public StudentManage() {
		serialNum++;
		studentId = ""+residentYear + serialNum ;
	}

}
