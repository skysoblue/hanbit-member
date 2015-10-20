package score;

import java.util.Comparator;
/**
 * @file_name : AscName.java 
 * @author    : coolbeat@naver.com
 * @date      : 2015. 10. 1.
 * @story     : 이름으로 오름차순
 */
public class AscName implements Comparator<ScoreVO>{

	@Override
	public int compare(ScoreVO front, ScoreVO back) {
		
		return front.getUserid().compareTo(back.getUserid());
		/**
		 * 뒤에 파라미터에 있는 앞글자와 비교해서
		 * 앞글자가 먼저 나오는 글자라면 그 글자부터 리터해라
		 */
	}
	
}
