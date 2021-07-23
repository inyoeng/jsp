package co.micol.member.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.command.Command;
import co.micol.member.command.MemberInsert;
import co.micol.member.command.MemberInsertForm;
import co.micol.member.command.MemberListCommand;
import co.micol.member.command.MemberSearchCommand;
import co.micol.member.command.mainCommand;
import co.micol.member.command.MemberSearchForm;



//@WebServlet("/FrontController") 이거 안쓰면 서블릿씀~ 오늘은 xml 가서 서블릿 메핑함. 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private HashMap<String, Command> map= new HashMap<String, Command>();

    public FrontController() {
        super();
       
    }


	public void init(ServletConfig config) throws ServletException {
		//command 객체 여기에다 map구조로 정리하여 등록한다. 
		map.put("/main.do", new mainCommand()); //홈
		map.put("/memberList.do", new MemberListCommand()); //회원목록
		map.put("/memberSearch.do", new MemberSearchCommand()); //회원검색
		map.put("/memberSearchForm.do", new MemberSearchForm()); // 회원검색 폼
		map.put("/memberInsertForm.do", new MemberInsertForm()); // 회원가입폼
		map.put("/memberInsert.do", new MemberInsert());  //회원가입
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service객체에서  command요청 분석하는 곳. 분석 및 처리, view page 선택하는 곳. 한 번만 만들고 복붙,,,,
		request.setCharacterEncoding("utf-8"); //한글 깨짐 방지
		//실제 요청을 분석
		String uri = request.getRequestURI();
		String context = request.getContextPath(); 
		//실제 요청페이지 구하기 : uri - context
		String path = uri.substring(context.length()); //ex) /main.do
		
		//Command command = new MainCommand();
		Command command = map.get(path); //인터페이스 command를 new mainCommand로 초기화 시켜줌. (command는 자기자신을 초기화할 수 없으니까 new maincommand)
		String viewPage = command.execute(request, response); //실행된 결과를 보여줄 페이지 선택. 
		
		if(!viewPage.endsWith(".do")) {
			//보여줄 페이지 선택하기
			viewPage = "WEB-INF/views/"+viewPage+".jsp";
		}
		
		RequestDispatcher dispatcer = request.getRequestDispatcher(viewPage);
		dispatcer.forward(request, response);
	}

}
