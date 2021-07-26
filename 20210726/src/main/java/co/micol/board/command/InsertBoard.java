package co.micol.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.service.BoardService;
import co.micol.board.serviceImpl.BoardServiceImpl;
import co.micol.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 둥록
		BoardService dao = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbWriter(request.getParameter("bWriter"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		
		int n = dao.boardInsert(vo);
		
		//validation 해보기
		String page="";
		if(n !=0) {
			page="boardList.do";
		}else {
			page="board/boardErrorPage";
		}
		
		return page;
	}

}
