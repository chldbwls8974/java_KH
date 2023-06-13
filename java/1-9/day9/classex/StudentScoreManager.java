package day9.classex;

public class StudentScoreManager {

	public static void main(String[] args) {

		// korScore를 인스턴스 또는 객체라고 부른다.
		
		// 밑 주석처럼 쓰면 한 줄로 해결이 가능하지만
		// 기본 생성자를 이용하면 4줄로 써야함
		// 생성자 오버로딩
		// Score1 korScore = new Score1(1,2,"korean Language);
		Score1 korScore = new Score1();
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		
		Score1 engScore = new Score1(1,2,"English");
		
		
	}

}

// 성적 클래스
class Score1{
	// 밑에 변수들을 필드라고 부름
	String title; // 과목명
	int grade; // 학년
	int semester; // 학기
	double total; // 총점수
	double midExam; // 중간고사
	double finalExam; // 기말고사
	double perform; // 수행평가
	
	// 생성자
	// (접근제어자) 메서드명(매개변수)  >> 기본 생성자인 경우 매개변수 생략
	
	// Score1 클래스의 기본 생성자	
	public Score1() {
		/*title의 기본값은? >> null
		 * grade의 기본값은? >> 0 
		 * total의 기본값은? >> 0.0
		 * 
		 * 기본 값이 아닌 다른 값으로 초기화를 해야하는 경우 기본생성자 내에서 초기화한다.
		 */
	}
	
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getMidExam() {
		return midExam;
	}

	public void setMidExam(double midExam) {
		this.midExam = midExam;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public double getPerform() {
		return perform;
	}

	public void setPerform(double perform) {
		this.perform = perform;
	}
	
}


// 학생 클래스
class Student1{
	String name; // 학생이름
	String residentNumber; // 주민번호
	int grade; // 학년
	int classNum; // 반
	int number; // 번호
	int admissionYear; // 입학년도
	Score1 korScore, engScore, mathScore;
	
}