package yeling.spring.web.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yeling.spring.web.board.impl.BoardDAO;
import yeling.spring.web.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세보기 처리");
		//1. 검색할 게시글 번호 추출
		String seq = request.getParameter("seq");

		//2. 데이터베이스 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		//3. 응답화면 구현
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}

}
