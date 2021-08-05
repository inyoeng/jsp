package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;

import co.micol.prj.comm.Command;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletRequest response) {
		// TODO Auto-generated method stub
		
		
		return "home/home";
	}

}
