package homework.manager.student.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Score implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kor;
	private int eng;
	private int math;
	
	
	public Score(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}


	public void update(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	
	public String toString() {
		return "kor : " + kor + "\n" 
				+ "eng : " + eng + "\n" 
				+ "math : " + math + "\n"
				+ "Sum score : " + (kor + eng + math) + "\n" 
				+ "Avg score: " + (double)(kor + eng + math)/3;
	}

}

