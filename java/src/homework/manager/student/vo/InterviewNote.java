package homework.manager.student.vo;

import java.util.ArrayList;
import java.util.Objects;

import lombok.Data;

@Data
public class InterviewNote {

	private String name;
	private ArrayList<Interview> interviewNote = new ArrayList<>();
	
	public InterviewNote(String name, ArrayList<Interview> interviewNote) {
		this.name = name;
		this.interviewNote = interviewNote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(interviewNote, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterviewNote other = (InterviewNote) obj;
		return Objects.equals(interviewNote, other.interviewNote) && Objects.equals(name, other.name);
	}
	
	
	public void update(String name, ArrayList<Interview> interviewNote) {
		this.name = name;
		this.interviewNote = interviewNote;
	}
	
	public void print(String name) {
		System.out.println("======= 면담 내용 조회 =======");
		System.out.println("이름 : " + name);
		for(Interview tmp : interviewNote) {
			System.out.println(tmp);
		}
	}
	

	
	// 학생과 면담 내용이 주어지면
	// 없는 학생이면 학생을 추가하고, 있는 학생이면 면담 내용만 새로 추가
	public void addInterview(String name, String interview) {
		
	}
	
	// 면담 내용 수정
	
	
	//
}
