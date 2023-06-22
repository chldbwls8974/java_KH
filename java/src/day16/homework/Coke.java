package day16.homework;

import lombok.Data;

@Data
public class Coke {
	private int amount;
	private int price = 2000;
	
	public Coke() {}
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
	
	// 제품 출고
	public void release() {
		this.amount -= 1;
	}
	
}
