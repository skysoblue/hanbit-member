package score;

import java.util.Scanner;

public class ScoreMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ScoreService service = new ScoreServiceImpl();
		ScoreVO score = new ScoreVO();
		while (true) {
			System.out.println(
					"1:성적등록 2:학적부리스트보기 3:학번으로검색 4:이름으로검색 " + 
			"5:성적 상위순으로 순위출력 6:성적 하위순으로 순위출력(스왑) 7:이름 오름차순 출력  8:종료");

			switch (scanner.nextInt()) {
			case 1:
			//	ID 가 존재해야만 성적 입력이 가능함 !!!
			// 존재하지 않으면 본교 학생이 아닙니다. 메시지 보여주세요	
				System.out.println("아이디,자바,JSP,...");
			//	scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()
				
				service.input(score);
				break;
			case 2:
				System.out.println(service.getList());
				break;
			case 3:
				System.out.println("ID 을 입력해 주세요");
				// ID 가 존재해야만 성적 검색이 가능함 !!!
				String userid = scanner.next();
				System.out.println(service.searchByUserid(userid));
				break;
			case 4:
				System.out.println("검색할 이름");
				String name = scanner.next();
				System.out.println(service.searchByName(name));
				break;
			case 5:
				service.descByTotal();
				System.out.println(service.getList());
				break;
			case 6:
				service.ascByTotal();
				System.out.println(service.getList());
				break;
			case 7:
				service.ascByName();
				System.out.println(service.getList());
				break;
			case 8:
				return;
			default:
				break;
			}
		}
	}
}
