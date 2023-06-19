package day14.polymorphism;

public class PolymorphismEx1 {

	public static void main(String[] args) {
		/* 매개변수의 다형성
		 * 리모컨으로 여러 제품의 전원을 켜는 예제
		 * 제품 : TV, 에어컨, 라디오
		 * 리모컨 클래스, TV클래스, 에어컨 클래스, 라디오 클래스
		 * 
		 * */
		
		TV tv1 = new TV();
		Radio radio1 = new Radio();
		AirConditioner aircon1 = new AirConditioner();
		RemoteControl remocon1 = new RemoteControl();
		
		remocon1.turnOn(tv1); // TV를 켜는 기능
		remocon1.turnOn(aircon1); // 에어컨을 켜는 기능
		remocon1.turnOn(radio1); // 라디오를 켜는 기능
		
		System.out.println("=====================");
		// 매개변수의 다형성 이용
		TV1 tv2 = new TV1();
		Radio1 radio2 = new Radio1();
		AirConditioner1 aircon2 = new AirConditioner1();
		RemoteControl1 remocon2 = new RemoteControl1();
		
		HomeAppliance appliance = tv2; // 업캐스팅
		
		remocon2.turnOn(appliance); // 가전을 켜는 기능
		remocon2.turnOn(aircon2); // 가전을 켜는 기능
		remocon2.turnOn(radio2); // 가전을 켜는 기능
		remocon2.turnOff(tv2);
		remocon2.turnOff(aircon2);
		remocon2.turnOff(radio2);
	}

}

class RemoteControl{
	public void turnOn(TV tv) {
		tv.turnOn();
		System.out.println("power on!");
	}
	public void turnOn(AirConditioner aircon1) {
		aircon1.turnOn();
		System.out.println("power on!");
	}
	public void turnOn(Radio radio) {
		radio.turnOn();
		System.out.println("power on!");
	}
}


class TV{
	boolean power;
	int channel;
	void turnOn() {
		power = true;
	}
}


class AirConditioner{
	boolean power;
	double currentTemperature;
	double desiredTemperature;
	void turnOn() {
		power = true;
	}
}


class Radio{
	boolean power;
	double frequency;
	void turnOn() {
		power = true;
	}
}



class HomeAppliance{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
}

class RemoteControl1{
	public void turnOn(HomeAppliance appliance) {
		appliance.turnOn();
		System.out.println("power on!");
	}
	public void turnOff(HomeAppliance appliance) {
		appliance.turnOff();
		System.out.println("power off!");
	}
}


class TV1 extends  HomeAppliance{
	boolean power;
	int channel;
}


class AirConditioner1 extends  HomeAppliance{
	boolean power;
	double currentTemperature;
	double desiredTemperature;
}


class Radio1 extends  HomeAppliance{
	boolean power;
	double frequency;
}









