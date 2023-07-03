package day24.thread;

public class SynchronizedEx1 {

	public static void main(String[] args) throws InterruptedException {	
		PassBook pb = new PassBook();
		User user1 = new User("Hong", pb);
		User user2 = new User("Hong fa", pb);
		user1.start();
		user2.start();
		
	}
}

