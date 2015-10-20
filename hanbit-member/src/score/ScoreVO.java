package score;

import java.io.Serializable;

import global.SQL;

public class ScoreVO implements SQL, Serializable{
	private static final long serialVersionUID = 1L;
	private String userid;
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String insert() {
		String query = "insert into score values(score_seq.nextval,?,?...)";
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectOneBy(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectSomeBy(String s1, String s2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String make(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getTotal(){
		return 0;
	}

}
