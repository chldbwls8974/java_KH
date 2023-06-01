package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		
		Student studentLee = new Student();
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.serialNum);
		studentLee.serialNum++;
		
		Student studentSon = new Student();
		studentSon.setStudentName("손수경");
		System.out.println(studentSon.serialNum);
		System.out.println(studentLee.serialNum); //serialNum은 static 변수로 모든 인스턴스가 공유하고 있으므로 이지원의 serialNum도 증가되어 출력됨.
	
	}

}
