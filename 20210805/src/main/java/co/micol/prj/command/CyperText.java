package co.micol.prj.command;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import co.micol.prj.comm.Command;
import co.micol.prj.comm.SHA_256;

public class CyperText implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletRequest response) {
		// TODO Auto-generated method stub
		SHA_256 cyper = new SHA_256();
		String stream = "Hello1234";
		try {
			String cyperText = cyper.encrypt(stream);
			
			System.out.println("원문 : "+stream); //원문
			System.out.println("암호문 : "+cyperText);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
