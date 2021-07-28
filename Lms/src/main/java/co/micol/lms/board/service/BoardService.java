package co.micol.lms.board.service;

import java.util.List;

import co.micol.lms.board.vo.BoardVO;


public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	int BoardUpdate(BoardVO vo);
}
