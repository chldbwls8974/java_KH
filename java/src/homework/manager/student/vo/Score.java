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
		return "援��뼱 �꽦�쟻 : " + kor + "\n" + "�쁺�뼱 �꽦�쟻 : " + eng + "\n" + "�닔�븰 �꽦�쟻 : " + math + "\n"
	+ "�젏�닔 珥앺빀 : " + (kor + eng + math) + " 	" + "�젏�닔 �룊援� : " + (double)(kor + eng + math)/3;
	}

}

