package practice;

import lombok.Data;

@Data
public class Student {
	
	private static int serialNum = 1100; //고유번호
	private String studentId;
	private String studentName;
	private int residentYear;

	public Student() {	}
	
	public Student(String studentName, int residentYear) {
		this.studentName = studentName;
		this.residentYear = residentYear;
		serialNum++;
		studentId = ""+residentYear + serialNum ;
	}

	// student print method
	public void print() {
		System.out.println("====================");
		System.out.println(studentName);
		System.out.println("Resident Year : " + residentYear);
		System.out.println("StudentID : " + studentId);
	}
	

}