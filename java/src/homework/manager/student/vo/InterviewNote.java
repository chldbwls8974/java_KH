package homework.manager.student.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import lombok.Data;

@Data
public class InterviewNote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		System.out.println("======= 硫대떞 �궡�슜 議고쉶 =======");
		System.out.println("�씠由� : " + name);
		for(Interview tmp : interviewNote) {
			System.out.println(tmp);
		}
	}
	

	
	// �븰�깮怨� 硫대떞 �궡�슜�씠 二쇱뼱吏�硫�
	// �뾾�뒗 �븰�깮�씠硫� �븰�깮�쓣 異붽��븯怨�, �엳�뒗 �븰�깮�씠硫� 硫대떞 �궡�슜留� �깉濡� 異붽�
	public void addInterview(String name, String interview) {
		
	}
	
	// 硫대떞 �궡�슜 �닔�젙
	
	
	//
}
