package day16.homework;

import lombok.Data;

@Data
public class Person {
	private int money;

	public Person(int money) {
		this.money = money;
	}
	
	private void accumulate(int money) {
		this.money -= money;
	}
}
