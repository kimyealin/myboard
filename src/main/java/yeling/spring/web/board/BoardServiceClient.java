package yeling.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		//1.������ �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.������ �����̳ʷκ��� BoardServiceImpl ��ü�� lookup
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		//3.�� ��� ��� �׽�Ʈ
		BoardVO vo = new BoardVO();
//		vo.setSeq(1000);
		vo.setTitle("�ȳ糪�ָ�");
		vo.setWriter("��Ÿ�");
		vo.setContent("�氡��");
		boardService.insertBoard(vo);
		
		//4.�� �˻� ��� �׽�Ʈ
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("--> " + board.toString());
		}
		
		//5.������ �����̳� ����
		container.close();
	}
}
