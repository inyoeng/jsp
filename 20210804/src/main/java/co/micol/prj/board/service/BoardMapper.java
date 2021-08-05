package co.micol.prj.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import co.micol.prj.board.vo.CommentsVO;
import co.micol.prj.board.vo.SnsVO;

public interface BoardMapper {
	// 선호되지 않는 문법 @Select("select * from sns")
	List<SnsVO> snsSelectList();
	
	List<SnsVO> snsSelect(SnsVO vo);
	CommentsVO commentsSelect(CommentsVO vo);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelte(CommentsVO vo);
	
}
