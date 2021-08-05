package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;

import co.micol.prj.comm.Command;
import co.micol.prj.service.FileInfoService;

public class Filelist implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletRequest response) {
		// TODO 목록 가져오기
		FileInfoService fileDao = new FileInfoService();
		request.setAttribute("files", fileDao.fileSelectList());
		
		return "file/filelist";
	}

}
