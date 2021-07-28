package co.micol.lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.lms.board.service.BoardService;
import co.micol.lms.board.serviceImpl.BoardServiceImpl;
import co.micol.lms.board.vo.BoardVO;
import co.micol.lms.member.service.MemberService;
import co.micol.lms.member.serviceImpl.MemberServiceImpl;
import co.micol.lms.member.vo.MemberVO;

public class Login implements Command {

	@Override
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
