package day21.practice.baseball.vo;

import java.util.ArrayList;
import lombok.Data;

@Data
public class User {
	private String userId;
	private ArrayList<Integer> recordList = new ArrayList<>();
	
	
	public User(String userId, ArrayList<Integer> recordList) {
		this.userId = userId;
		this.recordList =new ArrayList<>();
		this.recordList.add(null);
	}
	
	public User(User u) {
		this.userId = u.userId;
		this.recordList = new ArrayList<>();
		this.recordList = u.recordList;
	}

	public void print(String userId) {
		System.out.println("Id : " + userId);
		System.err.println("Record : " + recordList);
		System.out.println("Runtime : " + recordList.size());
	}
	
	public void print() {
		System.out.println("Id : " + userId);
		System.err.println("Record : " + recordList);
		System.out.println("Runtime : " + recordList.size());
	}
	
	
	public void addRecord(int num) {
		recordList.add(num);
	}
	

}
