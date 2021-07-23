package co.micol.member.vo;

public class MemberVO {
	//멤버 속성들, 맴버 객체 들어있음. vo 또는 dto(data trans obj)
	//member테이블과 1:1메칭. 컬럼명, 데이터 타입이 일치하도록 만들어야함.(컬럼=변수=html메인변수) 
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
	
	//기본 생성자
	public MemberVO() {
		
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
}
