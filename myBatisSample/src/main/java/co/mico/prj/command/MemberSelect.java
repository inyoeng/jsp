package co.mico.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mico.prj.common.Command;
import co.mico.prj.member.service.MemberService;
import co.mico.prj.member.vo.MemberVO;
import co.mico.prj.serviceImpl.MemberServiceImpl;

public class MemberSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService memDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = memDao.memberSelect(vo);
		request.setAttribute("select", vo);
		return "member/memberSelect";
	}

}
