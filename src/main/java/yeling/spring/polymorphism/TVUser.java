package yeling.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
//		TV tv = new SamsungTV();
//		TV tv = new LgTV();
//		BeanFactory factory = new BeanFactory();
//		TV tv = (TV)factory.getBean(args[0]);
		
		// 1. Spring �����̳ʸ� ����
		AbstractApplicationContext factory= new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring �����̳ʷκ��� �ʿ��� ��ü�� ��û
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		//3. Spring �����̳ʸ� ����
		factory.close();
	}
}
