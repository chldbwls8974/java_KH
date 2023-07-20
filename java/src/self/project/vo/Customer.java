package self.project.vo;

public class Customer {
	private String name;
	private String phoneNum;
	private int pointScore;
	private String level;
	
	public Customer(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.pointScore = 0;
		this.level  = "beginner";
	}
	
	private void sumPoint(int pointScore){
		this.pointScore += pointScore;
	}
	
	private void controlLevel(){
		if(pointScore > 5000) {
			// 오천점 이상 vip
			level =  "vip";
		}
	}
	
}
