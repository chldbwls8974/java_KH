package day16.homework;

public class Coke {
	private int amount;
	private int price = 2000;
	
	
	public Coke(int amount, int price) {
		this.amount = amount;
		this.price = price;
	}
	
	public Coke(Coke coke) {
		this.amount = coke.amount;
		this.price = coke.price;
	}
	
	// 제품 입고
	public void store(int amount) {
		this.amount += amount;
	}
	
	//
}
