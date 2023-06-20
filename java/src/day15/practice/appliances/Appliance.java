package day15.practice.appliances;

import lombok.Data;

@Data
public class Appliance {
	//private String product;
	//private String stock[];
	private int stockCount;
	
	public Appliance() {}

	/*
	public Appliance(String product, String stock) {
		this.product = product;
		this.stock = new String[30];
		this.stock[0] = stock;
		stockCount++;
	}
	
	public Appliance(String product) {
		this.product = product;
		this.stock = new String[30];
	}
	
	public Appliance(Appliance A) {
		this.product = A.product;
		this.stock = new String[30];
		
		for(int i = 0 ; i < A.stockCount ; i++) {
			stock[i] = A.stock[i];
		}
		stockCount = A.stockCount;
	}
	
*/
	// Print out inventory
	public void print() {
		System.out.println("stock: " + stockCount);
	}
	
	// Create Initial Inventory Tv 
	public void createTv(int num) {
		HomeAppliance homeappliances[] = new HomeAppliance[num];
		for(int i = 0 ; i < num ; i++) {
			homeappliances[stockCount++] = new TV();
		}
	}
	
	// Create Initial Inventory Aircon
	public void createAir(int num) {
		HomeAppliance homeappliances[] = new HomeAppliance[num];
		for(int i = 0 ; i < num ; i++) {
			homeappliances[stockCount++] = new AirConditioner();
		}
	}
	
	// Create Initial Inventory radio
	public void createRadio(int num) {
		HomeAppliance homeappliances[] = new HomeAppliance[num];
		for(int i = 0 ; i < num ; i++) {
			homeappliances[stockCount++] = new Radio();
		}
	}

	// Total count
	public void totalCount() {
		
	}



}


class HomeAppliance{
	int price;
	int total;
	int totalCount;
	void salePrice() {
		total += price;
	}
	void saleCount() {
		totalCount++; // 수정 필요
	}
}


class TV extends  HomeAppliance{
	int price = 10000;
}


class AirConditioner extends  HomeAppliance{
	int price = 20000;
}


class Radio extends  HomeAppliance{
	int price = 5000;
}
