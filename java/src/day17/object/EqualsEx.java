package day17.object;

import java.util.Objects;

import lombok.Data;

public class EqualsEx {

	public static void main(String[] args) {
		
		Customer list[] = {
				new Customer("hong", "01022222222"),
				new Customer("lim", "01033333333"),
				new Customer("kim", "01044444444"),
		};
		
		Customer customer = new Customer("hong", "01022222222");
		
		/*
		// equals()가 오버라이딩 안됐을 때 고객이 명단에 있는지 조회
		for(Customer tmp : list) {
			if(tmp.getPhoneNum().equals(customer.getPhoneNum())) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
		*/
		
		//equals()가 오버라이딩 됐을 때 고객이 명단에 있는지 조회
		for(Customer tmp : list) {
			if(tmp.equals(customer)) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}

}

@Data
class Customer{
	private String id;
	private String name;
	private String phoneNum;
	
	public Customer(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(phoneNum, other.phoneNum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNum);
	}
	
	
}