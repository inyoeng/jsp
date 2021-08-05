package co.micol.prj.command;

import javax.servlet.http.HttpServletRequest;

import co.micol.prj.comm.Command;
import co.micol.prj.comm.DownloadFile;

public class FileDownload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletRequest response) {
		// TODO file download
		String path ="d://temp";  //실제 물리적 경로
		String orgFileName = request.getParameter("orgFile");
		String downFile= request.getParameter("downFile");//실제로 다운로드 할 팔일
	
		DownloadFile downLoadFile = new DownloadFile(path, orgFileName, downFile);
		boolean b = downLoadFile.isFileDown();
		
		if(!b) {
			request.setAttribute("message", "파일 다운 성공!>ㅇ<");
		}else {
			request.setAttribute("message", "파일 다운 실패!ㅠ^ㅠ");
		}
		return "file/fileUploadResult";
	}

}
