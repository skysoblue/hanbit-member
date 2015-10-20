package score;

import java.util.List;

import global.DAO;

public class ScoreDAO extends DAO{
	// DML
	@Override
	public int insert(Object o) {
		// TODO Auto-generated method stub
		return super.insert(o);
	}
	
	// DQL
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return super.selectAll();
	}
	@Override
	public Object selectOneBy(String key) {
		// TODO Auto-generated method stub
		return super.selectOneBy(key);
	}
	public List selectSomeBy(){
		return null;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
