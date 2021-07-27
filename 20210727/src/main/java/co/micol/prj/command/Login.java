package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.source.tree.MemberSelectTree;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정을 처리하는 곳. 
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		// 서버가 가지고 있는 세션객체 호출한다. 
		HttpSession session = request.getSession();
		System.out.println(session.getId()+"============uuid찍어보기");
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		
		//view페이지 만들기
		String page ="";
		
		if(!vo.getName().isEmpty()){ //vo.getName != null과 같음.
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			
			page= "member/loginSuccess";
			
		}else {
			String message = "존재하지 않는 아이디 또는 패스워드입니다.";
			request.setAttribute("message", message);
			page ="member/memberError";
		}
		return page;
	}

}
