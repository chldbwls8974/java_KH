package arraylist;

public class StudentTest {

	public static void main(String[] args) {

		Student studentLee = new Student(1001, "Lee");
		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);
		
		Student studentKim = new Student(1002, "Kim");
		studentKim.addSubject("국어", 80);
		studentKim.addSubject("수학", 75);
		studentKim.addSubject("영어", 90);
		
		studentLee.showStudentInfo();
		System.out.println("===========================");
		studentKim.showStudentInfo();
	}

}
