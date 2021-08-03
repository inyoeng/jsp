package co.mico.prj.member.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String phone;
	private char State;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getState() {
		return State;
	}

	public void setState(char state) {
		State = state;
	}
	
}
