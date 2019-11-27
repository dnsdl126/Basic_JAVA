package shop;

import java.util.Scanner;

public class ShopMain {

	public static void main(String[] args) {

		// 사용자에게 값을 입력 (회원관련 기능 구현)
		// 1. 회원가입
		// 2. 회원수정
		// 3. 회원탈퇴

		Scanner cs = new Scanner(System.in);
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println("▨shop ver 1.5");
		System.out.println("▨1.회원가입");
		System.out.println("▨2.회원수정");
		System.out.println("▨3.회원탈퇴");

		int num;
		// 사용자 키보드 정수 값을 입력받아 num 변수에 담는 코드

		while (true) {
			System.out.print("▨번호 >>");

			num = cs.nextInt();

			// 1,2,3 외의 값이 들어온 경우 Error 발생
			// 및 다시 번호를 입력받음
			// 1,2,3이 들어온 경우 while()문을 break

			if (num < 1 || num > 3) {
				System.out.println("Error>>1,2,3의 값을 다시 입력하세요");
				continue;
			} else {
				break;
			}

		}
//==> 사용자가 입력한 값은 1,2,3 중에 하나

		Member mem = new Member();
		if (num == 1) { // 회원가입
			String id = "J.changpu";
			String pw = "301119";
			String name = "지멧쨍";
			String result = mem.memInert(id, pw, name);
			//1.mem.memInert(id, pw, name); 값을 들고 가라 (보냄)
			//4.mem.memInert(id, pw, name);가 return 된 status를 담아서 
			//  String result에 담음 (가독성을 위해)
			if (result.equals("success")) {
				System.out.println("회원가입 성공! 메인 페이지로 이동합니다");
			} else {
				System.out.println("회원가입 실패! 에러 메시지 출력");
			}
			// 위에 String 값을 가지고가서
		} else if (num == 2) { // 회원 수정
			mem.memUpdate();
		} else if (num == 3) { // 회원 탈퇴
		
			{String id = "J.changpu";
			String pw = "301119";
			String name = "지멧쨍";
			String result = mem.memInert(id, pw, name);
			mem.memDelete(id, pw, name);
			}

		}
	}
}