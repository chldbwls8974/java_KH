package day16.homework;

import lombok.Data;

@Data
public class Soda {

	private int amount=10;
	private int price = 1300;
	
	public Soda() {}
	
	public Soda(int amount, int price) {
		this.amount = amount;
		this.price = price;
	}
	
	public Soda(Soda soda) {
		this.amount = soda.amount;
		this.price = soda.price;
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
