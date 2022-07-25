package yeling.spring.web.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import yeling.spring.web.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {		
		System.out.println("글 등록 처리");
		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 수정 처리");	
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());
		boardDAO.updateBoard(vo);		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세보기 처리");
		model.addAttribute("board", boardDAO.getBoard(vo)); 
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
/*			@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword, BoardDAO boardDAO, Model model) {
		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + condition);
		System.out.println("검색 단어 : " + keyword);*/
		
		System.out.println("글 목록 검색 처리");
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		model.addAttribute("boardList", boardDAO.getBoardList(vo)); //Model정보 저장
		return "getBoardList.jsp";
	}
}
