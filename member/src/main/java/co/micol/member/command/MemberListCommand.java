package co.micol.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.member.service.MemberService;
import co.micol.member.serviceImpl.MemberServiceImpl;
import co.micol.member.vo.MemberVO;

public class MemberListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원전체 목록보기
		MemberService dao = new MemberServiceImpl(); // 인터페이스 모델로 초기화해서 모델을 dao라는 이름으로 호출
		List<MemberVO> members = new ArrayList<MemberVO>();
		members =dao.memberSelectList(); //모델에서 데이터 가져옴
		request.setAttribute("list", members); //페이지에 값을 전달하기위해 request에
		return "member/memberList"; //보여줄 페이지 선택
	}

}
