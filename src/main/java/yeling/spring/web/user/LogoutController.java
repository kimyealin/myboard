package yeling.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeling.spring.web.controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ó��");
		
		//1. �������� ����� ���� ��ü ����
		HttpSession session = request.getSession(false);
		session.invalidate();

		//2. ���� ���� �� ���� ȭ������ �̵�
		return "login";
	}

}
