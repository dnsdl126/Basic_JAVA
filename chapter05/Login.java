package chapter05;

import java.util.Scanner;

public class Login {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1.view단
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒ == LOGIN SYSTEM ==");
		System.out.println("▒ id >>");
		String id = sc.nextLine(); // 1_ 아이디 값을 받아라
		System.out.println("▒ pw >>");
		String pw = sc.nextLine(); // 2_ 패스워드 값을 받아라 
		// System.out.println(id + "," + pw);

		// 2. 로그인 기능을 구현(비즈니스 로직)
		// id, pw -> 데이터베이스에서 현재 회원이지 여부를 판단
//		             id, pw와 같은 유저가 있는지 확인 
//		             -> yes or no
//		             -> yes : 환영합니다 회원님~
//		             -> no : id or pw가 틀렸습니다.

		// 로그인시 회원판별기능을 사용하기 위한 객체 생성
		MemberDAO mDao = new MemberDAO(); 
		MemberDTO mDto = new MemberDTO(id, pw); // 3_ 매게변수 id와 pw 값을 가지고 가라 
		                                       // mDto (admin과 1234가담긴)
		

		int result = mDao.logingCheck(mDto);// 질문을 가지고 가서 변수 값을 가지고 돌아
		
		if(result==1) {
			System.out.println("재방문을 환영합니다!!");
		} else {
			System.out.println("id 또는 pw가 틀렸습니다.");
			
		}
		// 756를 입력하면
		// 7 + 5 + 6 을 진행해서
		// 결과가 18이 나와야함
		
	}

}
