package gugudan;

import java.util.Scanner;

public class Gugumain {

	public static void main(String [] args) {
	// java는 프로그램 실행시 무조건
	// Main 메서드 부터 시작 
	
	// 구구단 2단 출력
		//2  * 1 = 2
		//2  * 2 = 4
		//2  * 3 = 6
		//2  * 4 = 8
		//2  * 5 = 10
		//2  * 6 = 12
		//2  * 7 = 14
		//2  * 8 = 16
		//2  * 9 = 18
		//3 * 1 = 3
		//3 * 2 = 6
		
		//1. 사용자에게 단수를 입력받는 부분
		//2. 구구단을 출력하는 부분
		Scanner sc = new Scanner(System.in); 
		// 자바가 객체생성 1단계를 해둔 상태 
		// Scanner는 내가 만든 Class가 아님 자바에서 빌려옴 
		// Scanner는 java libray안에 있는 설계 도면 
		// 내가 만든 Class가 아니기 때문에 import로 어디서 가지고 오는지 표시
		
		
		
		System.out.println("단수를 입력해 주세요");
		int dansu = sc.nextInt(); 
		// 단수 입력
		// sc.이라는 결과물에서 nextInt를 찾아라 
		// sc.nextInt(); => Sc.이라는 주소에 가보니 nextInt라는 기능이 있다.
		// nextInt : 사용자가 입력한 정수 값을 가지고와라 
		// 
		GuguPrint ggp = new GuguPrint();
		//GuguPrint 객체 생성해라 (도면)
		
		ggp.gugudan(dansu);
		// 인스턴스 사용 
		// Gugumain 갔다가 다시 옴 (호출) 
		// 끝이 아니다
		
	} // -> i가 9에서 끝났으므로 for문을 빠져 나옴
}
