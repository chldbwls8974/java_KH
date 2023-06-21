package practice;

public class Subject {
	private String subject;
	private int score;
	private double total;
	// 나중에 중간,기말 추가
	
	public Subject(String subject, int score) {
		this.subject = subject;
		this.score = score;
	}
	
	// 메서드
	
	// 과목 별 성적 출력 메서드
	public void print(String subject) {
		System.out.println("과목 : " + subject);
		System.out.println("성적 : " + score);
	}
	
	// 전체 과목 성적 출력 메서드
	public void print() {
		System.out.println("과목 : " + subject);
		System.out.println("성적 : " + score);
	}
	
	// 총합 계산 메서드 (평균, 표준편차 등등 구할 때 이용)
	
	// 
	
	
}
