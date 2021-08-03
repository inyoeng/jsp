package co.mico.prj.member.service;

import java.util.List;

import co.mico.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
}
