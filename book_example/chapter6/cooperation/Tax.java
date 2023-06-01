package cooperation;

public class Tax {
	int taxNumber;
	int passengerCount;
	int money;
	
	public Tax(int taxNumber) {
		this.taxNumber = taxNumber;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.println("택시" + taxNumber + "번의 승객은 " + passengerCount + "명이고, 요금은 " + money + "입니다.");
	}
}
