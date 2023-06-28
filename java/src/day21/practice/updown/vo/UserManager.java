package day21.practice.updown.vo;

import java.util.ArrayList;

public class UserManager {
	
	private ArrayList<User> userList;
	
	public UserManager() {
		userList = new ArrayList<User>();
	}

	public void addUser(User id, User list) {
		userList.add(id);
		userList.add(list);
	}

	public void printUser() {
		for(User user : userList) {
			System.out.println(user);
		}
		System.out.println();
	}

	public void addUser(String id, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		
	}


}
