package com.yedam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;

public interface ReplyMapper {
	public int insertRep(ReplyVO vo);
	public int updateRep(ReplyVO vo);
	public int deleteRep(ReplyVO vo);
	public ReplyVO readRep(ReplyVO vo);
	//여러건 보내고 싶을 때~
	public List<ReplyVO> getList(@Param("cri") Criteria cri, @Param("bno") int bno);
	
}
