package homework.manager.student.vo;

public class Interview {
	/* 학생 이름과 
	 * 면담 일자와
	 * 면담 내용
	 * 
	 * 기능
	 * 첫 면담이라면 학생과 면담 내용 새로 추가
	 * 학생의 면담 내용이 있다면 새로이 추가
	 * 면담 내용 삭제
	 * 학생 삭제
	 * 면담 내용 수정 
	 * 
	 * >> 단어장 참고
	 * */
	
	private String name;
	private String date;
	
	
	private String interview;
	public Interview(String name, String date) {
		this.name = name;
		this.date = date;
	}
	
	
}
