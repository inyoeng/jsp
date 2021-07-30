package co.deagu.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.deagu.command.Command;
import co.deagu.command.Login;
import co.deagu.command.LoginForm;
import co.deagu.command.Main;

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
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		map.put("/main.do", new Main());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
	
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) { //"home.do" 리다이렉트 됨
	         if(!viewPage.endsWith(".jsp")) {
	            viewPage = viewPage + ".tiles";
	         }else {         //타일즈 안태우는 방법(home/home)
	            viewPage = "/WEB-INF/views/" + viewPage;
	         }
	      }
		      
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	

}
