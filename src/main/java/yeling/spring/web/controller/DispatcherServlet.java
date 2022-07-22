package yeling.spring.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeling.spring.web.board.BoardVO;
import yeling.spring.web.board.impl.BoardDAO;
import yeling.spring.web.user.UserVO;
import yeling.spring.web.user.impl.UserDAO;

@WebServlet(name = "action", urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//1. Ŭ���̾�Ʈ ���� ����
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2.HandlerMapping�� ���� path�� �ش��ϴ� Controller�� �˻�
		Controller controller = handlerMapping.getController(path);
		
		//3. �˻��� Controller�� ����
		String viewName = controller.handleRequest(request, response);
		
		//4. ViewResolver�� ���� viewName�� �ش��ϴ� ȭ�� �˻�
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}
		
		//5. �˻��� ȭ������ �̵�
		response.sendRedirect(view);
		
	}
}
