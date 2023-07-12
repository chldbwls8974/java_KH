package kh.model.vo;

import java.io.Serializable;
import java.util.Scanner;

public class Food implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571448215459432725L;

	private String name;
	private int kcal;
	
	public Food() {}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	public String toString() {
		return "name : " + name + kcal +"kcal";
	}
}