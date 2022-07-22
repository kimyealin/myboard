package yeling.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import yeling.spring.web.board.DeleteBoardController;
import yeling.spring.web.board.GetBoardController;
import yeling.spring.web.board.GetBoardListController;
import yeling.spring.web.board.InsertBoardController;
import yeling.spring.web.board.UpdateBoardController;
import yeling.spring.web.user.LoginController;
import yeling.spring.web.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;

	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		//나중에 이 부분에 명령어(path)와 Controller객체가 추가됨
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
