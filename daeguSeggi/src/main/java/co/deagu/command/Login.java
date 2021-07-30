package co.deagu.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.deagu.board.service.BoardService;
import co.deagu.board.serviceImpl.BoardServiceImpl;
import co.deagu.boardVO.BoardVO;
import co.deagu.memberVO.MemberVO;
import co.deagumember.service.MemberService;
import co.deagumember.serviceImpl.MemberServiceImpl;

public class Login implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();//memberTable
		BoardService boardDao = new BoardServiceImpl();// boardTable

		MemberVO vo = new MemberVO();

		//세션객체 사용위해
		HttpSession session = request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password")); 
		String page="";
		
		vo = dao.memberLogin(vo);
		
		if(vo.getName() != null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAge());
			session.setAttribute("id", vo.getId());
			
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = boardDao.boardSelectList();
			request.setAttribute("boards", list);
			
			page="main.do";
		}else {
			page="loginForm.do";
		}
		return page;
		
	}
		
}
