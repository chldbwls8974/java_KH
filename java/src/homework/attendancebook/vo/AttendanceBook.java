package homework.attendancebook.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Data;

@Data
public class AttendanceBook implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6550340216688499291L;
	private List<Attendance> list = new ArrayList<>();
	private List<Student> stdList = new ArrayList<>();
	
	
	public boolean addStudent(Student tmp) {
		// 이미 등록된 학번이면 등록 실패 : 학생 클래스가 학번을 통해서 같은지 확인 할 수 있어야함.
		if(stdList.contains(tmp)) {
			return false;
		}
		stdList.add(tmp);
		Collections.sort(stdList,(o1,o2)->{
			return o1.getNum().compareTo(o2.getNum());
		});
		System.out.println(stdList);
		return true;
	}


	public boolean insertAttendance(Attendance check) {
		// 이미 등록된 출석 기록이면 등록 실패
		if(list.contains(check)) {
			return false;
		}
		list.add(check);
		
		Collections.sort(list, (o1,o2)->{
			// 날짜가 같으면 학번순으로 정렬
			if(o1.getDate().equals(o2.getDate())){
				return o1.getStd().getNum().compareTo(o2.getStd().getNum());
			}
			// 날짜가 다르면 날짜 순으로 정렬
			return o1.getDate().compareTo(o2.getDate());
		});
		return true;
	}
	
	public String toString() {
		return ((Attendance) list).getDate() +  list.toString() ;
	}
	
	public void printAttendance() {
		if(list.size()==0) {
			return;
		}
		String dateStr="";
		for(Attendance tmp : list) {
			if(!dateStr.equals(tmp.getDateStr())) {
				System.out.println(tmp.getDateStr());
				dateStr = tmp.getDateStr();
			}
			System.out.println(tmp);
		}
	}
	
}
