package yeling.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeling.spring.web.board.impl.BoardDAO;
import yeling.spring.web.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�� �󼼺��� ó��");
		//1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		//2. �����ͺ��̽� ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3. ����ȭ�� ����
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}

}
