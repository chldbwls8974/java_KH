package day17.practice.service;

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public class ShopServiceImp implements ShopService{


	@Override
	public int store(Product[] list, int productCount, Product product) {
		
		// 입고할 제품이 없으면 입고하지 않고, 기존 제품 수를 아람.
		if(product == null) {
			return productCount;
		}
		
		// 제품리스트가 없으면
		if(list == null) {
			return 0;
		}
		
		// 제품리스트의 크기가 productCount보다 작으면
		if(list.length < productCount) {
			return list.length;
		}
		
		// 제품수가 잘못되면(음수이면)
		if(productCount < 0) {
			return 0;
		}
		
		int index = indexOf(list, productCount, product);
		
		// 기존 제품 입고
		if(index!= -1) {
			list[index] = store(product.getAmount());
			return productCount;
		}
		
		// 배열이 꽉차
		if(productCount == list.length) {
			return productCount;
		}
		
		// 새제품 입고
		list[productCount] = new Product(product);
		
		return productCount + 1;
	}

	
	private int indexOf(Product[] list, int productCount, Product product) {
		
		// 제품 정보가 없거나 제품명이 없으면 못참음
		if(product == null || product.getName() == null) {
			return -1;
		}
		
		//제품 리스트가 없으면
		if(list == null) {
			return -1;
		}
		
		// 검색할 제품수가 잘못 입력되면
		if(productCount > list.length || productCount < 0) {
			productCount = list.length;
		} 
		
		
		for(int i = 0 ; i < productCount ; i++) {
			
			// 제품 리스트에서 꺼낸 제품 정보를 tmp에 저장
			Product tmp = list[i];
			
			// 제품리스트에 있는 제품이 없거나 이름이 없거나 찾을 제품명이 없으면 못찾음
			if(tmp == null || tmp.getName() == null || product.getName() == null) {
				return -1;
			}
			if(list[i].getName().equals(product.getName())) {
				return i;
			}
		}
		return -1;
		
	}


	
	
	public void printProduct(Product[]  list, int productCount, String search) {
		if(list==null || search == null) {
			System.out.println("제품 정보 없음");
			return ;
		}
		
		int index = indexOf(list, productCount, new Product(search));
		
		if(index == -1) {
			System.out.println("제품정보 없음");
			return;
		}
		list[index].print();
	}


	@Override
	public int sell(Product[] list, int productCount,
			Customer[] customerList, int customerCount, Sales[] salesHistory, int salesCount,
			String name, int amount, String phoneNumber) {
			
		// 각 리스트의 존재를 확인
		if(list == null || customerList == null || salesHistory == null) {
			return -1;
		}
		
		// 각 리스트가 넘치는지 확인
		if(list.length < productCount || customerList.length < customerCount || salesHistory.length < salesCount	) {
			return -1;
		}
		
		int productIndex = indexOf(list, productCount, new Product(name));
		int customerIndex = indexOf(customerList, customerCount, phoneNumber);
		
		
		// 판매 정보 생성
		Product sellProduct = new Product(list[productIndex]);
		sellProduct.setAmount(amount);
		Sales sales = new Sales(customerList[customerIndex], sellProduct);
		
		// 판매된 제품의 재고량을 수정
		list[productIndex].release(amount);
		
		// 판매 리스트에 판매 정보 추가
		salesHistory[salesCount] = sales;
		
		return salesCount + 1;
	}


	private int indexOf(Customer[] customerList, int customerCount, String phoneNumber) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int registerCustomer(Customer[] customerList, int customerCount, Customer customer) {
		if(customerList == null || customerCount < 0 || customer == null || customer.getPhoneNumber() == null || customerList.length <= customerCount) {
			return -1;
		}
		
		for(int i = 0 ; i < customerCount ; i++) {
			if(customerList[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -1;
			}
		}
		
		customerList[customerCount] = new Customer(customer);
		return customerCount + 1;
	}


	




	
}
