package score;

import java.util.ArrayList;

public interface ScoreService {
	// DML
	public void input(ScoreVO score);
	
	// DQL
	public ArrayList<ScoreVO> getList();
	public ScoreVO searchByUserid(String userid);
	public ArrayList<ScoreVO> searchByName(String name);
	public void descByTotal();  // 성적을 내림차순으로 정렬(300,270,230,...)
	public ArrayList<ScoreVO> ascByName();   // 성적을 이름에 따라 오름차순(ㄱ,ㄴ,ㄷ...)
	public void ascByTotal(); // 성적을 오름차순으로 정렬(230,270,300...)
}
