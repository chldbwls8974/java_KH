package day24.thread;

import lombok.Data;

//@Data
public class User extends Thread{
	private PassBook pb;
	String name;
	
	public User(String name, PassBook pb) {
		this.name = name;
		this.pb = pb;
	}
	
	@Override
	public void run() {
		pb.depoit(name, 10000);
	}
	
}

@Data
class PassBook{
	private int balance;
	public synchronized void depoit(String name, int money) {
		this.balance += money;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " : "+ money);
		System.out.println("balance : " + this.balance);
	}
}
