package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.serviceImpl.BoardServiceImpl;
import co.micol.prj.board.vo.SnsVO;
import co.micol.prj.common.Command;

public class SnsSelect implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 글 한 건 조회 댓글 여러건 조회
		BoardService boardDao = new BoardServiceImpl();
		SnsVO vo = new SnsVO();
		//vo.setcNo(1);
		vo.setSNo(Integer.parseInt(request.getParameter("sno"))); //lombok을 써서 이름이 조금 달라짐
		request.setAttribute("list", boardDao.snsSelect(vo));
		return "board/SnsSelect";
	}

}
