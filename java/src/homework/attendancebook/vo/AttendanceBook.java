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
		// �̹� ��ϵ� �й��̸� ��� ���� : �л� Ŭ������ �й��� ���ؼ� ������ Ȯ�� �� �� �־����.
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
		// �̹� ��ϵ� �⼮ ����̸� ��� ����
		if(list.contains(check)) {
			return false;
		}
		list.add(check);
		
		Collections.sort(list, (o1,o2)->{
			// ��¥�� ������ �й������� ����
			if(o1.getDate().equals(o2.getDate())){
				return o1.getStd().getNum().compareTo(o2.getStd().getNum());
			}
			// ��¥�� �ٸ��� ��¥ ������ ����
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
