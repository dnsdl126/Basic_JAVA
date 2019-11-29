package problem.fafatouch;

import java.util.Scanner;

public class FaFaMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// sc 노란줄은 경고 표시는 경고 표시이다
		// 어떤 기능을 빌려서 사용할 경우 반드시 반납을 해야한다
		// 1. 파일 입력&출력 File I/O (i:intput / O:output)
		// 2. 데이터 베이스 관련 작업

		// 메인메뉴를 저장하는 5칸 짜리 배열 생성
		String[][] mainMenu = new String[5][2];
		                      // new 부분이 실제 배열을 생성
		// [5][2]
		// [5]는 메뉴
		// [2]는 메뉴이름[0]/ 메뉴가격[1]
		mainMenu[0][0] = "파파버거";
		mainMenu[1][0] = "맥치킨버거";
		mainMenu[2][0] = "와퍼버거";
		mainMenu[3][0] = "싸이버거";
		mainMenu[4][0] = "빅맥버거";
		mainMenu[0][1] = "4500";
		mainMenu[1][1] = "5500";
		mainMenu[2][1] = "6000";
		mainMenu[3][1] = "4700";
		mainMenu[4][1] = "5500";

		// 사이드메뉴를 저장하는 5칸 짜리 배열 생성
		String[][] sideMenu = new String[5][2];

		sideMenu[0][0] = "감자튀김";
		sideMenu[1][0] = "양념감자";
		sideMenu[2][0] = "치즈스틱";
		sideMenu[3][0] = "맥너겟";
		sideMenu[4][0] = "스위트콘";
		sideMenu[0][1] = "1500";
		sideMenu[1][1] = "2000";
		sideMenu[2][1] = "2000";
		sideMenu[3][1] = "2500";
		sideMenu[4][1] = "1700";

		// 음료메뉴를 저장하는 5칸 짜리 배열 생성
		String[][] drinkMenu = new String[5][2];

		drinkMenu[0][0] = "코카콜라";
		drinkMenu[1][0] = "스프라이트";
		drinkMenu[2][0] = "마운틴듀";
		drinkMenu[3][0] = "오렌지쥬스";
		drinkMenu[4][0] = "초코쉐이크";
		drinkMenu[0][1] = "2000";
		drinkMenu[1][1] = "2000";
		drinkMenu[2][1] = "2000";
		drinkMenu[3][1] = "3000";
		drinkMenu[4][1] = "2500";
		
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒파파터치 주문 프로그램");
			System.out.println("▒==메인메뉴==");
			System.out.println("▒1.파파버거");
			System.out.println("▒2.맥치킨버거");
			System.out.println("▒3.와퍼버거");
			System.out.println("▒4.싸이버거");
			System.out.println("▒5.빅맥버거");
			System.out.print("▒번호>>");
			// 사용자가 주문한 메인 메뉴 번호!
			int mainNum = sc.nextInt();
	
			System.out.println("▒==사이드메뉴==");
			System.out.println("▒1.감자튀김");
			System.out.println("▒2.양념감자");
			System.out.println("▒3.치즈스틱");
			System.out.println("▒4.맥너겟");
			System.out.println("▒5.스위트콘");
			System.out.print("▒번호>>");
			// 사용자가 주문한 메인 메뉴 번호!
			int sideNum = sc.nextInt();
	
			System.out.println("▒==음료==");
			System.out.println("▒1.코카콜라");
			System.out.println("▒2.스프라이트");
			System.out.println("▒3.마운틴듀");
			System.out.println("▒4.오렌지쥬스");
			System.out.println("▒5.쵸코쉐이크");
			System.out.print("▒번호>>");
			// 사용자가 주문한 메인 메뉴 번호!
			int drinkNum = sc.nextInt();
	
			// 총 주문금액 계산!
			// 메인메뉴 가격 : mainMenu[mainNum-1][0])
			// 사이드메뉴 가격 : sideMenu[mainNum-1][0])
			// 음료메뉴 가격 : drinkMenu[mainNum-1][0])
			// int totprice = 메인메뉴가격 + 사이드메뉴가격+음료가격
			// 출력!!
	
			int mPrice = Integer.parseInt(mainMenu[mainNum - 1][1]);
			//Integer.parseInt : String(문자열)을 숫자로 바꿔줌
			// 사용자 번호는 1번부터 시작하지만
			// 인덱스는 0번부터 이기 때문에 -1 이 필요
			int dPrice = Integer.parseInt(sideMenu[sideNum - 1][1]);
			int oPrice = Integer.parseInt(drinkMenu[drinkNum - 1][1]);
	
			int totPrice = mPrice + dPrice + oPrice;
	
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒고객님께서 주문하신 메뉴는");
			System.out.println("▒ " + mainMenu[mainNum - 1][1]); // 메인메뉴
			System.out.println("▒ " + sideMenu[sideNum - 1][1]); // 사이드메뉴
			System.out.println("▒ " + drinkMenu[drinkNum - 1][1]); // 음료메뉴
			System.out.println("▒ 총 주문 금액은" + totPrice + "원 입니다");
			System.out.print("▒ 주문하시겠습니까?(y/n)");
			// 엔터키는 2가지 기능을 가지고 있음
			// 1. 입력기능
			// 2. 한줄개행(\n)
			// sc.nextInt()는 정수값만 받기 때문에 한줄개행
			// 코드를 무시하지만 sc.nextLine()은 문자열을
			// 입력받아 한줄개행코드를 입력으로 받음...
			// sc.nextLine()을 사용해서 한줄개행입력을
			// 대신 받아주는 부분이 필요함
			while(true){
			sc.nextLine(); // 한줄개행 맏는 부분
			String order = sc.nextLine(); // 키보드로 문자열 받기
			System.out.println(order);
			String smallAns = order.toLowerCase(); // 소문자변환
			if (smallAns.equals("y")) {
				while (true) // 무한반복 코드는 꼭 빠져나오는 코드 작성해야함 
					{
					// 결제금액 입력
					System.out.println("결제금액>>");
					int money = sc.nextInt();
					// 지불금액이 총 구매 액보다 작은 경우
	
					if (totPrice > money) {
						System.out.println("금액이 부족합니다");
						continue; 
						// 다음 반복으로 넘어가지 말고 
						// 여기서 다시 처음으로 돌아가라
						// 사용자 한테는 다시 결제금액 표시 창으로 돌아감 
					} else {
						if (totPrice < money) {
							System.out.println((money - totPrice) + "거스름돈 받아가세요.");
						}
						// 지불금액 == 결제금액
						// 지불금액 > 결제금액(거스름돈 주고)
						System.out.println("결제완료! 고객님 맛있게 드세요:)");
					
						break;
					}
				}
				
			} else if(order.equals("n")||order.equals("N")) {
				continue;
				// 시스템 처음으로 돌아가세요!
			}else {System.out.println("y or n을 입력해주세요");
				
			}
			
		
		//sc.close();

	}

}
}