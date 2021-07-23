package co.micol.member.service;

import java.util.List;

import co.micol.member.vo.MemberVO;

public interface MemberService {
	//crud
	
	//회원전체 목록 가져오기(R)
	List<MemberVO> memberSelectList();
	//회원 한명 조회(R)
	MemberVO memberSelect(MemberVO vo); 
	//회원 추가(c)
	int memberInsert(MemberVO vo);
	//(D)삭제
	int memberDelete(MemberVO vo);
	//(U)
	int memberUpdate(MemberVO vo);
}
