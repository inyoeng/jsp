package com.yedam.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.service.ReplyService;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	@Autowired ReplyService repService;
	
	
	//해당 게시글의 댓글만 조회
	@GetMapping("/")
	public List<ReplyVO> getlist(Criteria cri, @RequestParam int bno) {
		
		return repService.getList(cri, bno);
	}
	
	//한 개 조회
	@GetMapping("/{rno}")
	public ReplyVO readRep(@PathVariable int rno, ReplyVO vo) {
		vo.setRno(rno);
		return repService.readRep(vo);
	}
	//등록  post는 파라미터 질의 문자열(query String) -> id=100&name='dd'
	@PostMapping("/")   
	public ReplyVO insert(ReplyVO vo) {
		repService.insertRep(vo);
		return vo;
	}
	//수정, json 타입으로 받아와야함. put은 파라미터가 json으로 옴!{id:100, name:'dd'}
	@PutMapping("/")
	public ReplyVO update(@RequestBody ReplyVO vo) {
		repService.updateRep(vo);
		return repService.readRep(vo);
	}
	//삭제
	@DeleteMapping("/{rno}")
	public boolean delete(@PathVariable int rno, ReplyVO vo) {
		vo.setRno(rno);
		int r = repService.deleteRep(vo);
		return r==1? true: false;
	}
}
