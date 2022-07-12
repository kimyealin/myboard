package yeling.spring.polymorphism;

public class SamsungTV implements TV{
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	public void start() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void stop() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}
	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV 볼륨을 올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV 볼륨을 내린다.");
	}
}
