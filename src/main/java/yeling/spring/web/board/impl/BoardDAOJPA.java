package yeling.spring.web.board.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import yeling.spring.web.board.BoardVO;

@Repository
public class BoardDAOJPA {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void insertBoard(BoardVO vo) {
		System.out.println("JPA로 insertBoard() 기능 처리");
		manager.persist(vo);
	}
	@Transactional
	public void updateBoard(BoardVO vo) {
		System.out.println("JPA로 updateBoard() 기능 처리");
		manager.merge(vo);
	}
	@Transactional
	public void deleteBoard(BoardVO vo) {
		System.out.println("JPA로 deleteBoard() 기능 처리");
		manager.remove(manager.find(BoardVO.class, vo.getSeq()));
	}
	@Transactional
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JPA로 getBoard() 기능 처리");
		return (BoardVO) manager.find(BoardVO.class, vo.getSeq());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("JPA로 getBoardList() 기능 처리");
		return manager.createQuery("select vo from BoardVO vo order by vo.seq desc", BoardVO.class).getResultList();
	}
}
