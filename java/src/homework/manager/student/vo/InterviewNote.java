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
	
	public String toString() {
		return name + interviewNote;
	}

	
	public void addInterview(String name, String interview) {
		
	}
	
}
