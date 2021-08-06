package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.service.UiTestService;
import co.micol.prj.serviceImple.UiTestServiceImpl;
import co.micol.prj.uiTest.vo.UiTestVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 확인하기
		UiTestService uiDao = new UiTestServiceImpl();
		UiTestVO vo = new UiTestVO();
		
		HttpSession session = request.getSession();
		
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = uiDao.login(vo);
		
		
	String page ="";
		
		if(!vo.getAuthor().isEmpty()){ 	
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			request.setAttribute("member", uiDao.login(vo));
			
			
			page= "home/loginResult";
			
		}else {
			String message = "존재하지 않는 아이디 또는 패스워드입니다.";
			request.setAttribute("message", message);
			page ="member/memberError";
		}
		return page;

	}

}
