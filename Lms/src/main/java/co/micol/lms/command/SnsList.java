package co.micol.lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.lms.sns.service.SnsService;
import co.micol.lms.sns.serviceImpl.SnsServiceImple;
import co.micol.lms.sns.vo.SnsVO;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 
		SnsService snsDao = new SnsServiceImple();
		List<SnsVO> list = new ArrayList<SnsVO>();
		list = snsDao.SnsSelectList();
		request.setAttribute("list", list);
		
		return "main/snsList";
	}

}
