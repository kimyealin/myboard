package yeling.spring.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import yeling.spring.web.controller.Controller;
import yeling.spring.web.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α��� ó��");
		//1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		//2. �����ͺ��̽� ����ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		//3. ȭ�� �׺���̼�
		if(user != null){
			return "getBoardList.do";
		}else{
			return "login";
		}

	}
}
