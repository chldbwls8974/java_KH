package day16.homework;

public class Fanta {
	private int amount;
	private int price = 1500 ;
	
	
	public Fanta(int amount, int price) {
		this.amount = amount;
		this.price = price;
	}
	
	public Fanta(Fanta fanta) {
		this.amount = fanta.amount;
		this.price = fanta.price;
	}
	
	// 제품 입고
	public void store(int amount) {
		this.amount += amount;
	}

}
