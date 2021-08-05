package co.micol.prj.command;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.micol.prj.comm.Command;
import co.micol.prj.img.vo.FileInformationVO;
import co.micol.prj.service.FileInfoService;

public class Fileupload implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletRequest response) {
		// TODO 파일 업로드
		FileInfoService fileDao = new FileInfoService();
		FileInformationVO vo = new FileInformationVO();
		int maxFileSize =  1024 *1024 *100; //최대 파일 사이즈 
		
		//System.out.println(request.getParameter("subject")); 못가져와서 null뜸 -> multipartrequest써여
	
		try {
			MultipartRequest part = new MultipartRequest(request, "d:/temp/", maxFileSize, "utf-8", new DefaultFileRenamePolicy()); //객체 생성되면서 자도으로 파일 업로드 하네
	
			String upfileName = part.getFilesystemName("fileName"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
			String orgfileName = part.getOriginalFileName("fileName"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
			

			vo.setSubject(part.getParameter("subject"));
			vo.setFileName(orgfileName);
			vo.setDownFile(upfileName);// 같은 파일 올라오는거 방지위해서 올릴때는 uuid, 내려받을 때는 originname(fileName)
//			
			//System.out.println(vo.getFileName()+vo.getSubject());
			
			int n = fileDao.fileInsert(vo);
			
			if( n != 0) {
				request.setAttribute("message", vo.getFileName()+"파일 업로드 성공");
			}else {
				request.setAttribute("message", orgfileName+"파일 업로드 실패");
			}
	
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "file/fileUploadResult";
	}

}
