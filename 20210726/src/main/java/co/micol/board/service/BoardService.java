package co.micol.board.service;

import java.util.List;

import co.micol.board.vo.BoardVO;

public interface BoardService {
	//public 안쓰면 protected 디촐트 들어감.
	
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo); //한 행 조회
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
}
