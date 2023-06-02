package inheriatance;

public class Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	// 기본 생성자,, 고객 한명이 새로 생성되는 customerGrade는 실버이고, bonusRatio는 0.01이다.
	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		}
	
	// 제품에 대해 지불해야 하는 금액을 계산하여 반환한다.
	// 할인되지 않는 경우 가격 그대로 반환한다.
	// 가격에 대해 보너스 포인트 비율을 적용하여 보너스 포인트를 적립한다.
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	// 고객 정보 출력
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 보너스 포인트는"  + bonusPoint + "입니다.";
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerGrade(){
		return customerGrade;
	}
	
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
}
