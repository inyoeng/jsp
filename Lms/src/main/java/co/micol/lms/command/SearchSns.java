package co.micol.lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.lms.sns.service.SnsService;
import co.micol.lms.sns.serviceImpl.SnsServiceImple;
import co.micol.lms.sns.vo.SnsVO;

public class SearchSns implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 선택된 sns를 가져온다. 
		SnsService snsDao = new SnsServiceImple();
		List<SnsVO> list = new ArrayList<SnsVO>();
		
		int n = Integer.valueOf(request.getParameter("sNo"));
		list = snsDao.snsSelect(n);
		request.setAttribute("list", list);
		
		return "main/snsDetail";
	}

}
