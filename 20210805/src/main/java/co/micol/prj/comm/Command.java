package co.micol.prj.comm;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	public String execute(HttpServletRequest request, HttpServletRequest response);
}
