package co.micol.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//main.do 요청시 처리하는 곳~!
		//여기에 db관련~~
		
		return "main/home";
	}

}
