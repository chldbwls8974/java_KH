package day17.practice.vo;

import lombok.Data;

// 판매 내역 : 누가 어떤 제품을 샀는지 관리하는 클래스
@Data
public class Sales {
	
	private Customer customer;
	private Product product;
	private int totalPrice; // 판매 내역의 총 금액 (전체 내격의 총 금액)
	
	public Sales(Customer customer, Product product	) {
		this.customer = customer;
		this.product = product;
		totalPrice = product.getAmount() * product.getPrice();
	}

	public void print() {
		System.out.println("========================");
		System.out.println("제품명 : " + product.getName());
		System.out.println("수량 : " + product.getAmount());
		System.out.println("고객명 : " + customer.getCustomerId());
		System.out.println("금액 : " + totalPrice);
	}
	
	
	
	
}
