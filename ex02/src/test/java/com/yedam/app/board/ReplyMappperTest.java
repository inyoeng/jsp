package com.yedam.app.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.mapper.ReplyMapper;
import com.yedam.app.board.service.ReplyService;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class ReplyMappperTest {
	@Autowired ReplyMapper repMapper;
	@Autowired ReplyService repService;
	@Test
	public void insert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		int bno = (int) vo.getBno();
		vo.setReply("우와");
		vo.setReplyer("나");
		repMapper.insertRep(vo);
		//log.info(repMapper.getList(null, bno).toString());
		log.info(repService.getList(null, bno).toString());
		
	}
	
	//@Test
	public void getList() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(1);
		int bno = (int) vo.getBno();
		log.info(repMapper.getList(null,bno).toString());
	}
	
	//@Test
		public void read() {
			ReplyVO vo = new ReplyVO();
			vo.setRno(1);
			log.info(repMapper.readRep(vo).toString());
		}
	
	//@Test
	public void delete() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(5);
		vo.setBno(1);
		
		int bno = (int) vo.getBno();
		repMapper.deleteRep(vo);
		log.info(repMapper.getList(null,bno).toString());
	}
	
	//@Test
	public void update() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(1);
		vo.setReply("수정된 댓글");
		vo.setReplyer("댓작성자");
		repMapper.updateRep(vo);
		log.info(repMapper.readRep(vo).toString());
	}
}
