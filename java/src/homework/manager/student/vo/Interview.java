package homework.manager.student.vo;

import java.util.Objects;

import lombok.Data;

@Data
public class Interview {
	/* 학생 이름과 
	 * 면담정보 >> 일자와 내용이 함께
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
	/*
	private String name;
	private String date;
	//private String interview[];
	private ArrayList<String> interview = new ArrayList<>();
	
	
	public Interview(String name, String date, ArrayList<String> interview) {
		this.name = name;
		this.date = date;
		//this.interview = new String[6];
		this.interview = interview;
	}
	
	public Interview(Interview I) {
		this.name = I.name;
		this.date = I.date;
		this.interview = I.interview;
	}
	
	public void print(String name) {
		System.out.println("========== 면담내용 조회 =========");
		System.out.println("이름 : " + name);
		
	}*/
	
	private String date;
	private String interview;
	
	
	public Interview(String date, String interview) {
		this.date = date;
		this.interview = interview;
	}

//
//	@Override
//	public int hashCode() {
//		return Objects.hash(date, interview);
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Interview other = (Interview) obj;
//		return Objects.equals(date, other.date) && Objects.equals(interview, other.interview);
//	}
	
	public void update(String date, String interview) {
		this.date = date;
		this.interview = interview;
	}
}
