package day16.homework;

import lombok.Data;

@Data
public class Fanta {
	private int amount;
	private int price = 1500 ;
	
	public Fanta() {}
	
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
	
	// 제품 출고
	public void release() {
		this.amount -= 1;
	}
	

}
