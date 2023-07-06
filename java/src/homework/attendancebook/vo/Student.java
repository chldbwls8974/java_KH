package homework.attendancebook.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1783352694933062253L;
	//private Date date;
	private String name;
	private String num;
	//private String attendance;
	
	public Student(String num , String name) {
		this.num = num;
		this.name = name;
	}


	// 복사 생성자
	public Student(Student tmp) {
		this(tmp.num, tmp.name);
	}



	public String toString() {
		return num + "." + name + ": "  ;
		
	}

	
	// 학번으로만 객체가 같은지 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	
}
