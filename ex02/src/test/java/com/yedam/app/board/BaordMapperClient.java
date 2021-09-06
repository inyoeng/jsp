package com.yedam.app.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.domain.BoardVO;
import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class BaordMapperClient {
	@Autowired BoardService boardMapper;
	//@Autowired BoardVO vo;
	@Test
	public void getList() {
		Criteria cri = new Criteria(1,10);
		cri.setType("T");
	    cri.setKeyword("헤헤");
		log.info(boardMapper.getList(cri).toString());
	}

	//@Test
	public void insert() {
		//boardVO 생성하고 
		//insert 호출
		BoardVO vo = new BoardVO();
		vo.setTitle("박보검 잘생겨따");
		vo.setContent("gg");
		vo.setWriter("박보검");
		
		boardMapper.insert(vo);
		//boardMapper.read(vo);
		log.info(boardMapper.read(vo).toString());
		
	}
	//@Test
	public void delete() {
		BoardVO vo = new BoardVO();
		vo.setBno(6);
		boardMapper.delete(vo);
		log.info(boardMapper.getList().toString());
	}
	//@Test
	//@Rollback
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setContent("수정된 내용");
		vo.setTitle("수정된 제목");
		vo.setWriter("서강준");
		
		int result =boardMapper.update(vo);
		assertEquals(result, 1);
		log.info(boardMapper.read(vo).toString());
	}
	//@Test
	public void read() {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo = boardMapper.read(vo);
		log.info(vo.toString());
	}
}
