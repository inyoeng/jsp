package com.yedam.app.board.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.ReplyVO;
import com.yedam.app.board.service.ReplyService;


@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired ReplyMapper replyMapper;
	
	@Override
	public int insertRep(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.insertRep(vo);
	}

	@Override
	public int updateRep(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.updateRep(vo);
	}

	@Override
	public int deleteRep(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.deleteRep(vo);
	}

	@Override
	public ReplyVO readRep(ReplyVO vo) {
		// TODO Auto-generated method stub
		return replyMapper.readRep(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		// TODO Auto-generated method stub
		return replyMapper.getList(cri, bno);
	}


}
