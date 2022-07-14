package yeling.spring.web.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService)container.getBean("userService");
		
		//�α��α�� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("yeling");
		vo.setPassword("spring");
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		}else {
			System.out.println("�α��� ����");
		}
		container.close();
	}
}
