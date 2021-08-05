package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.CyperText;
import co.micol.prj.command.FileDownload;
import co.micol.prj.command.Filelist;
import co.micol.prj.command.Fileupload;
import co.micol.prj.command.Home;
import co.micol.prj.command.Thumbnail;
import co.micol.prj.command.fileUploadForm;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
   
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/home.do", new Home());
		map.put("/fileUpload.do", new Fileupload());
		map.put("/fileUploadForm.do", new fileUploadForm());
		map.put("/filelist.do", new Filelist());
		map.put("/fileDownload.do", new FileDownload());
		map.put("/thumbnail.do", new Thumbnail());
		map.put("/cyperText.do", new CyperText());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		
		String viewPage = command.execute(request, request);
		
		if (!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/"+viewPage+".jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
				
	}

}
