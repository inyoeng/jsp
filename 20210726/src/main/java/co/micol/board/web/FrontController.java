package co.micol.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.command.BoardList;
import co.micol.board.command.Command;
import co.micol.board.command.DeleteBoard;
import co.micol.board.command.HomeCommand;
import co.micol.board.command.InsertBoard;
import co.micol.board.command.InsertForm;
import co.micol.board.command.UpdateBoard;
import co.micol.board.command.UpdateForm;
import co.micol.board.xcommand.BoardSelect;


@WebServlet("*.do") //어노테이션 없이 서블릿매핑 ->web.xml에 정리할 필요 x
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
  
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO  사용할 command를 정의 (command를 생성한다는 개념)
		map.put("/home.do", new HomeCommand());
		map.put("/boardList.do", new BoardList());
		map.put("/boardSelect.do", new BoardSelect());
		map.put("/insertForm.do", new InsertForm());
		map.put("/insertBoard.do", new InsertBoard());
		map.put("/updateForm.do", new UpdateForm());
		map.put("/updateBoard.do", new UpdateBoard());
		map.put("/deleteBoard.do", new DeleteBoard());
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 실제 수행할 부분을 분석하고 실행하고, 리턴페이지 돌려줌. 
		
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());// 실제 path수행
		//System.out.println(path);
		
		Command command = map.get(path);//path에 home.do-> homeCommand
		String viewPage = command.execute(request, response);
		
		//view reserve 만들기
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
