package day21.practice.baseball.vo;

import day13.homework.vo.Word;

public class UserManager {

	private User userList[];
	
	private int userCount;
	
	//10명의 user만 저장 가능
	public UserManager() {
		userList = new User[10];
	}
	
	public UserManager(User userList[]) {
		this.userList = new User[userList.length];
		
		for(int i = 0 ; i < userList.length ; i++) {
			this.userList[i] = new User(userList[i]);
		}
		userCount = userList.length;
	}
	
	public void print() {
		System.out.println("=============");
		for(int i = 0 ; i < userCount ; i++) {
			userList[i].print();
			System.out.println("=============");
		}
	}
	
	/** add user
	 * 
	 */
	public void addUser(User user) {
		if(userCount==userList.length) {
			System.out.println("full!");
			return;
		}
		userList[userCount++] = new User(user);
		
	}
}
