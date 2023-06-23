package day18.homework.arithmetic.controller;

import day18.homework.arithmetic.service.Service;
import day18.homework.arithmetic.service.ServiceImp;

public class Controller {

	
	private Service service = new ServiceImp();
	
	public void run() {
		int menu = -1;
		
		service.printMenu();
		service.runMenu(menu);
		service.run();
	}
}
