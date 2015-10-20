package member2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HanbitCom {
	/**
	 * "안녕하세요".substring(1,3);  0이상 2미만
	 * "녕하"
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * CRUD
		 * Create : 추가
		 * Read : 검색
		 * Update : 수정
		 * Delete : 삭제
		 */
		String id = "", pass ="";
		Scanner scanner = new Scanner(System.in);
		MemberService service = MemberServiceImpl.getInstance();
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO m = new MemberVO();
		while (true) {
			System.out.println("1 : 회원가입  2: 로그인  3:총회원수 4:ID검색  "
					+ "5:조건검색 6:회원정보수정 7:전체회원정보 9:회원탈퇴  10:종료");
			
			switch (scanner.nextInt()) {
			case 1:
				System.out.println("아이디 입력하세요");
				String userid = scanner.next();
				if (dao.selectOneBy(userid).getUserid() != null) {
					System.out.println("이미 가입된 아이디 입니다.");
					break;  // 다시 처음 입력명령문으로 되돌아감
				}
				System.out.println("비번 입력하세요");
				String password = scanner.next();
				System.out.println("이름 입력하세요");
				String name = scanner.next();
				System.out.println("성별 입력하세요");
				String gender = scanner.next();
				System.out.println("생년 입력하세요");
				String birth = scanner.next();
				System.out.println("이메일 입력하세요");
				String email = scanner.next();
				System.out.println("주소 입력하세요");
				String addr = scanner.next();
				System.out.println("전화번호 입력하세요");
				String phone = scanner.next();
				MemberVO temp = new MemberVO( userid,  password,  name, 
						 birth,  phone,  email,
						 gender,  addr);
				if (dao.insert(temp) == 1) {
					System.out.println("회원가입 성공");
				}
				System.out.println("회원가입 실패");
				break;
			case 2:
				System.out.println("로그인 할 ID, 비번을 입력 해주세요");
				String loginId = scanner.next();
				String loginPass = scanner.next();
				m = dao.login(loginId, loginPass);
				if (m != null) {
					System.out.println("환영합니다.");
				} else {
					System.out.println("로그인 실패입니다.");
				}
				break;
			case 3:
				System.out.println(dao.count()+"명 입니다.");
				break;
			case 4:
				System.out.println("검색할 ID 입력 : ");
				String searchId = scanner.next();
				searchByID(dao, searchId); // 메소드 리팩토링 
				break;
			case 5:
				System.out.println("검색할 항목을 정해주세요. 1:이름 2:주소 3:성별");
				int sub = scanner.nextInt();
				switch (sub) {
				case 1: 
					System.out.println("검색할 이름 입력 : ");
					list = dao.selectSomeBy("name", scanner.next());
					break;
				case 2:
					System.out.println("검색할 주소 입력 : ");
					list = dao.selectSomeBy("addr", scanner.next());
					break;
				case 3:
					System.out.println("검색할 성별 입력(남:M , 여:W) : ");
					list = dao.selectSomeBy("gender", scanner.next());
					break;
				default:
					break;
				}
				for (MemberVO vo : list) {
					System.out.println(vo);
				}
				break;
			case 6:
				System.out.println("로그인 할 ID, 비번을 입력 해주세요");
				String loginId2 = scanner.next();
				String loginPass2 = scanner.next();
				m = dao.login(loginId2, loginPass2);
				if (m != null) {
					System.out.println("환영합니다.");
				}else{
					System.out.println("다시 로그인 해주세요");
					break;
				}
				System.out.println("수정할 항목을 정해주세요.(비번 : password, 주소 : addr)");
				String column = scanner.next();
				System.out.println("수정값을 입력하세요");
				String changeVal = scanner.next();
				switch (column) {
				case "password":
					m.setPassword(changeVal);
					dao.update(m);
					break;
				case "addr":
					m.setAddr(changeVal);
					dao.update(m);
					break;

				default:break;
				}
				System.out.println("정보가 수정되었습니다.");
				searchByID(dao, loginId2);
				break;
			case 7:
				list = dao.selectAll();
				for (MemberVO mem : list) {
					System.out.println(mem);
				}
				break;
			case 9:
				System.out.println("삭제할 ID 입력");
				System.out.println(service.remove(scanner.next()));
				break;
			case 10: return;
			default:
				break;
			}
		}
	}

	private static void searchByID(MemberDAO dao, String searchId) {
		MemberVO m;
		m =dao.selectOneBy(searchId);
		if (m.getUserid() != null) {
			System.out.println(m.toString());
		}else{
			System.out.println("검색할 ID가 존재하지 않습니다.");
		}
	}
}
