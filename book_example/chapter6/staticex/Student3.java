package staticex;

public class Student3 {
	private static int serialNum = 22000;
	int studentID;
	String studentName;
	int studentCardID;
	
	public Student3() {
		serialNum++;
		studentID = serialNum;
		studentCardID = studentID + 100;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}
	
	public static int getSerialNum() {
		int i = 10;
		return serialNum;
	}
	
	public static void setSerialNum(int serialNum) {
		Student3.serialNum = serialNum;
	}

}
