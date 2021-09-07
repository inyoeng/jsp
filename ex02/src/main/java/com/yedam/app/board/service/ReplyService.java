package com.yedam.app.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;

@Repository
public interface ReplyService {
	public int insertRep(ReplyVO vo);
	public int updateRep(ReplyVO vo);
	public int deleteRep(ReplyVO vo);
	public ReplyVO readRep(ReplyVO vo);
	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") int bno);
	
}
