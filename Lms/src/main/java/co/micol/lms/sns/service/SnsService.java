package co.micol.lms.sns.service;

import java.util.List;

import co.micol.lms.sns.vo.CommentsVO;
import co.micol.lms.sns.vo.SnsVO;

public interface SnsService {
	List<SnsVO> SnsSelectList();//전체 글 목록
	List<SnsVO> snsSelect(int no);
	
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelete(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
	
	
}
