package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃
		HttpSession session = request.getSession();
		String message = session.getAttribute("name") +"님 정상 로그아웃 되었습니다.";
		//session.invalidate(); //기본이 세션을 삭제함. =session.remove():uuid는 그대로 (로그인 전에 넣어둔 장바구니 로그인 후에도 계속되게)
		session.removeAttribute("name");
		session.removeAttribute("author");
		
		request.setAttribute("message", message);
		
		return "member/memberError";
	}

}
