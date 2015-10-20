package member2;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {
		return instance;
	} 
	Map<String,Object> map = new HashMap<String,Object>();
	MemberVO member = new MemberVO();
	@Override
	public void join(String id, String pass, String name, String age, String addr) {
		member.setUserid(id);
		member.setPassword(pass);
		member.setName(name);
		member.setBirth(age);
		member.setAddr(addr);
		map.put(id, member);
	}
	/**
	 *  환영합니다. 서울에 사시는 30세 홍길동님.
	 *  비번이 다릅니다. 다시 입력하세요
	 *  입력하신 ID 는 존재하지 않거나, 일치하지 않습니다. 다시 입력해 주세요.
	 *  Map 에서 밸류값만 가져오는 메소드는 map.get("키값")
	 */
	@Override
	public String login(String id, String pass) {
		
		String result = "";
		
		if(map.containsKey(id)){  // 맵에 키값으로 검색 ID가 있다면
			MemberVO temp = new MemberVO();
			temp = (MemberVO) map.get(id);  // 왜 ? map에서 value 가 Object 이기 때문
			if (temp.getPassword().equals(pass)) {
				result = "환영합니다."+temp.getAddr()+"에 사시는 "+temp.getBirth()+"세 "+temp.getName()+"님.";
			} else {
				result = "비번이 다릅니다. 다시 입력하세요";
			}
		}else{
			result = "입력하신 ID 는 존재하지 않거나, 일치하지 않습니다. 다시 입력해 주세요.";
		}
		
		return result;
	}
	/**
	 * 전체 회원수 
	 */
	@Override
	public int count() {
		return map.size();
	}
	/**
	 * ID로 회원검색
	 */
	@Override
	public MemberVO searchById(String id) {
		return (MemberVO) map.get(id);
	}
	/**
	 * 비번변경
	 */
	@Override
	public String changePass(String id,String pass) {
		String result ="";
		MemberVO taget = (MemberVO) map.get(id);
		if (taget != null) {
			taget.setPassword(pass);
			result ="비밀번호가 변경되었습니다.";
		}else{
			result = "비밀번호가 변경되지 않았습니다.";
		}
		return result;
	}
	/**
	 * 회원탈퇴
	 */
	@Override
	public String remove(String id) {
		String result =null;
		Object m = map.remove(id); // 리턴값이 value
		if (m != null) {
			result = "입력하신 ID "+id+"가 삭제되었습니다.";
		} else {
			result = "삭제하려는 ID가 없습니다. 다시 입력하세요";
		}
		return result;
	}
}









