package co.micol.lms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃처리
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "login.do";
	}

}
