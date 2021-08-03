package co.mico.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mico.prj.command.MemberSelect;
import co.mico.prj.command.memberList;
import co.mico.prj.common.Command;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
	
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/memberList.do", new memberList());
		map.put("/memberSelect.do", new MemberSelect());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.execute(request, response);
		
		
		//viewReserve 나중에 만들기.
		if(!viewPage.endsWith(".do")) {
			viewPage ="WEB-INF/views/" +viewPage +".jsp";
		}
		
		System.out.println(viewPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
