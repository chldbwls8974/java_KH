package day15.polymorphism;


public class InstancePolymotphismEx {

	public static void main(String[] args) {
		/* 티비 한대,
		 * 에어컨 두대,
		 * 라디오 3대를 객체로 생성
		 */
		
		
		RemoteControl remocon = new RemoteControl();
		
		/*
		TV tv = new TV();
		AirConditioner aircon1 = new AirConditioner();
		AirConditioner aircon2 = new AirConditioner();
		Radio radio1 = new Radio();
		Radio radio2 = new Radio();
		Radio radio3 = new Radio();
		
		remocon.turnOn(tv);
		remocon.turnOn(aircon1);
		remocon.turnOn(aircon2);
		remocon.turnOn(radio1);
		remocon.turnOn(radio2);
		remocon.turnOn(radio3);
		
		System.out.println("===========");
		
		remocon.turnOff(tv);
		remocon.turnOff(aircon1);
		remocon.turnOff(aircon2);
		remocon.turnOff(radio1);
		remocon.turnOff(radio2);
		remocon.turnOff(radio3);
		*/
		
		
		/*
		TV tv = new TV();
		AirConditioner aircons[] = new AirConditioner[2];
		Radio radios[] = new Radio[3];
		
		for(int i = 0; i < aircons.length ; i++) {
			aircons[i]= new AirConditioner();
		}
		
		for(int i = 0; i < radios.length ; i++) {
			radios[i]= new Radio();
		}
		
		remocon.turnOn(tv);
		for(AirConditioner aircon : aircons) {
			remocon.turnOn(aircon);
		}
		
		for(Radio radio : radios) {
			remocon.turnOn(radio);
		}
		*/
		
		
		// 포함 다형성 예제
		// 부모 클래스의 배열을 이용해서 자식 클래스들을 관리
		// 가전제품 객체를 하나 만들어서 
		int tvCount = 1, airconCount = 2, radioCount = 3;
		int total = tvCount + airconCount + radioCount;
		HomeAppliance homeappliances[] = new HomeAppliance[total];
		int count = 0;
		
		// tv 1대 생성
		for(int i = 0 ; i < tvCount ; i++) {
			homeappliances[count++] = new TV(); // 업캐스팅
		}
		
		for(int i = 0 ; i < airconCount ; i++) {
			homeappliances[count++] = new AirConditioner(); // 업캐스팅
		}
		
		for(int i = 0 ; i < radioCount ; i++) {
			homeappliances[count++] = new Radio(); // 업캐스팅
		}
		
		for(HomeAppliance homeAppliance : homeappliances) {
			remocon.turnOn(homeAppliance);
		}
		
		System.out.println("==========");
		
		// 라디오의 전원을 끔
		for(HomeAppliance homeAppliance : homeappliances) {
			// 라디오로 다운캐스팅이 가능한 객체만 끔 >> 라디오만 끔
			if(homeAppliance instanceof Radio) {
			remocon.turnOff(homeAppliance);
			Radio radio = (Radio)homeAppliance;  // 다운캐스팅
			System.out.println(radio.frequency);
			}
		}
		
		
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

class RemoteControl{
	public void turnOn(HomeAppliance appliance) {
		appliance.turnOn();
		System.out.println("power on!");
	}
	public void turnOff(HomeAppliance appliance) {
		appliance.turnOff();
		System.out.println("power off!");
	}
}


class TV extends  HomeAppliance{
	boolean power;
	int channel;
}


class AirConditioner extends  HomeAppliance{
	boolean power;
	double currentTemperature;
	double desiredTemperature;
}


class Radio extends  HomeAppliance{
	boolean power;
	double frequency;
}