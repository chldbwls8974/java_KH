package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Customer {
	
	// CID00001
	private static int count; // 고객 아이디 발급을 위한 클래스 변수 >> 등록된 고객 수 
	private final static String CID = "CID"; // 고객 아이디 앞부분
	private final static int MAX_SIZE = 5; // 숫자 뒷부분 00001의 최ㅐ대 사이즈
	
	private String customerId; //고객이 추가되면 자동으로 발급
	private String name;
	private String phoneNumber;
	
	// 생성자
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId();
	}

	
	//메서드
	private void generateCustomerId() {
		// 1 > 00001
		String num = "" + ++count;
		int length = num.length();
		
		for(int i = 0 ; i < MAX_SIZE - length ; i++) {
			num = "0" + num;
		}
		customerId = CID + num;
	}

	
	public void print() {
		System.out.println("고객 번호 : " + customerId);
		System.out.println("고객 이름 : " + name);
		System.out.println("전화 번호 : " + phoneNumber);
	}
	
	public void print(String name) {
		System.out.println("고객 번호 : " + customerId);
		System.out.println("고객 이름 : " + name);
		System.out.println("전화 번호 : " + phoneNumber);
	}
}
