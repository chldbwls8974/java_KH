package day17.practice.service;

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public interface ShopService {

	// 제품을, 수량을 추가하는 메서드 (없는 제품이면 제품 추가)
	int store(Product[] list, int productCount, Product product);

	// 제품명이 주어지면 제품정보를 출력하는 메서드
	void printProduct(Product[] list, int productCount, String search);



	int sell(Product[] list, int productCount,Customer[] customerList, int customerCount,Sales[] salesHistory,
			int salesCount, String name, int amount, String phoneNumber);

	int registerCustomer(Customer[] customerList, int customerCount, Customer customer);



}
