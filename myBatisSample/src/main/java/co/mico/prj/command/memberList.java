package co.mico.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mico.prj.common.Command;
import co.mico.prj.member.service.MemberService;
import co.mico.prj.member.vo.MemberVO;
import co.mico.prj.serviceImpl.MemberServiceImpl;

public class memberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService memberDao = new MemberServiceImpl();
		List<MemberVO> list = memberDao.memberSelectList();
		request.setAttribute("members", list);
		
		return "member/memberList";
	}

}
