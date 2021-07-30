package co.deagumember.service;

import java.util.List;

import co.deagu.memberVO.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	MemberVO memberLogin(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
