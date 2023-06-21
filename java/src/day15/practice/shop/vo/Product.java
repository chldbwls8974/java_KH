package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Product {
	// 멤버변수 : 제품 판매와 관련된 제품 정보
	private String name;// 제품명
	private String modelName;	// 모델명
	private int price; // 가격
	private int amount; // 수량
	private String category; // 분류
	
	
	// 생성자
	public Product() {}
	
	public Product(String name, String modelName, int price, int amount, String category) {
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	
	public Product(String name, int amount) {
		
	}
	

	public Product(Product product) {
		this.name = product.name;
		this.modelName = product.modelName;
		this.price = product.price;
		this.amount = product.amount;
		this.category = product.category;
	}

	// 메서드
	/** 제품 입고 기능 >> 현재 수량에 주어진 수량을 누적
	 * 
	 * @param amount
	 */
	public void store(int amount) {
		// 창고에 제품을 추가해야하는데 음수가 오면 안됨
		if(amount < 0) {
			return;
		}
		//this.amount += amount;
		accumulate(amount);
	}
	
	/** 제품 출고 기능 >> 현재 수량에서 주어진 수량을 감소
	 * 
	 */
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		//this.amount -= amount;
		accumulate(-amount);
	}
	
	private void accumulate(int amount) {
		this.amount += amount;
	}
	
	/** 제품 정보 출력 기능
	 * 
	 */
	public void print(String name) {
		System.out.println("제품명 : " + name);
		System.out.println("모델명 : " + modelName);
		System.out.println("가격 : " + price);
		System.out.println("수량 : " + amount);
		System.out.println("분류 : " + category);
	}
}
