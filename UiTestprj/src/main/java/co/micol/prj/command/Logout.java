package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String message = session.getAttribute("id") +"님 정상 로그아웃 되었습니다.";
		
		session.removeAttribute("id");
		session.removeAttribute("author");
		
		request.setAttribute("message", message);
		
		
		return "home/logoutResult";
	}

}
