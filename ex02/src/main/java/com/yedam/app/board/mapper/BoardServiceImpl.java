package com.yedam.app.board.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.domain.BoardVO;
import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired BoardMapper boardMapper;
	
	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.insert(vo);
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.update(vo);
	}

	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.delete(vo);
	}

	@Override
	public BoardVO read(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.read(vo);
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		// TODO Auto-generated method stub
		return boardMapper.getTotalCount(cri);
	}


}
