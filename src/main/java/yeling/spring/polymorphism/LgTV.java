package yeling.spring.polymorphism;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("LgTV ��ü ����");
	}
	public void start() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void stop() {
		System.out.println("��ü ���� ���� ó���� ���� ó��");
	}
	public void powerOn() {
		System.out.println("LgTV ������ �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("LgTV ������ ����.");
	}
	public void volumeUp() {
		System.out.println("LgTV ������ �ø���.");
	}
	public void volumeDown() {
		System.out.println("LgTV ������ ������.");
	}
}
