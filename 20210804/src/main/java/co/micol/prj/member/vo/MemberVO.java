package co.micol.prj.member.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String phone;
	private char state;
	
	private String check; //로그인 or 검색 상태를 체크한다. 
	
}
