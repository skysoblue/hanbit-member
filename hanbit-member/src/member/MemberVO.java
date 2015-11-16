package member;

import java.io.Serializable;

import global.SQL;

public class MemberVO implements Serializable, SQL{
	
	private static final long serialVersionUID = 1L;
	
	private String userid; // 아이디  =>hong => 'hong'
	private String password; // 비번
	private String name; // 회원이름
	private String birth; // 나이
	private String phone; // 전화번호
	private String email; // 이메일
	private String gender; // 성별
	private String addr; // 주소
	private String regdate; // 등록일
	private String profile; // 프로필사진
	public String property;
	
	public static MemberVO instance = new MemberVO();
	public static MemberVO getInstance(){
		return instance;
	}
	
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String userid, String password, String name, 
			String birth, String phone, String email,
			String gender, String addr) {
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.addr = addr;
		this.profile = "default.png";
	}
	
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getAddr() {
		return addr;
	}
	public String getRegdate() {
		return regdate;
	}
	public String getProfile() {
		return profile;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setProfile(String profile) {
		this.profile = "default.png";
	}
	
	@Override
	public String toString() {
		return " 회원 [아이디=" + userid 
				+ ", 비밀번호=" + password 
				+ ", 이름=" + name 
				+ ", 생년=" + birth
				+ ", 전화번호=" + phone 
				+ ", 이메일=" + email 
				+ ", 성별=" + gender 
				+ ", 주소=" + addr 
				+ ", 등록일=" + regdate 
				+ ", 프로필 사진=" + profile + "]";
	}
	/**
	 * executeUpdate
	 * 추가
	 * System.out.printf("hello ?, Good bye ? ",name,name2);
	 */
	
	@Override
	public String insert() {
		String query = "insert into member "
				+ "(userid, password,  name, birth, phone, email, "
				+ "gender, addr, regdate, profile)values(?,?,?,?,?,?,?,?,sysdate,?)";
		// ? => %s
		// %d 숫자
				
		return query;
	}
	@Override 
	public String update() {
		String query = "update member"
				+" set password = ?,"
				+ "addr = ?"
				+ "where userid = ?";
		return query;
	}
	@Override
	public String delete() {
		String query = "delete from member"
				+ " where userid= ?";
		return query;
	}
	@Override
	public String selectAll() {
		String query = "select * from member";
		return query;
	}
	
	@Override
	public String selectOneBy(String s) {
		String query = "select * from member where userid ="+this.make(s);
		return query;
	}
	@Override
	public String count() {
		// 오라클에서 as 는 결과값에 키값을 주는 역할을 한다.
		// 키값은 rs 가 해당 value 를 가져올 때 사용된다.
		// 따로 정하지 않으면, 컬럼명이 키값이 된다
		String query = "select count(*) as count from member";
		return query;
	}
	@Override
	public String make(String s) {
		// make(java) => 'java'
		return "'"+s+"'";
	}

	@Override
	public String selectSomeBy(String s1, String s2) {
		String query = "select * from member where "+s1+" ="+this.make(s2);
		return query;
	}
	
}
