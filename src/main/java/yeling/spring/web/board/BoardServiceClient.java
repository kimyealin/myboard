package yeling.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		//1.스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.스프링 컨테이너로부터 BoardServiceImpl 객체를 lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//3.글 등록 기능 테스트
		BoardVO vo = new BoardVO();
//		vo.setSeq(1000);
		vo.setTitle("안녕나애링");
		vo.setWriter("기매링");
		vo.setContent("방가워");
		boardService.insertBoard(vo);
		
		//4.글 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--> " + board.toString());
		}
		
		//5.스프링 컨테이너 종료
		container.close();
	}
}
