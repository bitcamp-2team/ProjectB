
public class UserVo {
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	
	
	
	
	/** 생성자 알맞게 수정하세요*/
	public UserVo(String id, String pw, String name, String phoneNum) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
	}
	public UserVo() {} // 기본생성자

	/*
	 * 로그인 상태라는 상태값을 만들기
	 * */
	
	/** getter,setter */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	
}
