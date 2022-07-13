package yeling.spring.polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	//������ ������ �̿�
	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV ��ü ���� : ������ ������");
		this.speaker = speaker;
	}
	//���� ���� ����
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV ��ü ���� : ������ ������ - ���߸���");
		this.speaker = speaker;
		this.price = price;
	}

	//setter�޼��� �̿�
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() �޼��� ȣ��");
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		System.out.println("setPrice() �޼��� ȣ��");
		this.price = price;
	}

	//	public void start() {
//		System.out.println("��ü �ʱ�ȭ �۾� ó��");
//	}
//	public void stop() {
//		System.out.println("��ü ���� ���� ó���� ���� ó��");
//	}
	public void powerOn() {
		System.out.println("SamsungTV ������ �Ҵ�. (���� : " + price + ")");
	}
	public void powerOff() {
		System.out.println("SamsungTV ������ ����.");
	}
	public void volumeUp() {
//		System.out.println("SamsungTV ������ �ø���.");
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("SamsungTV ������ ������.");
		speaker.volumeDown();
	}
}
