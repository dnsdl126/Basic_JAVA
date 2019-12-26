package problem.bank;

import java.util.Scanner;

public class DDBankMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		int code = 0;

		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■무민은행");
			System.out.println("■ 1. 계좌 개설");
			System.out.println("■ 2. 입금");
			System.out.println("■ 3. 출금");
			System.out.println("■ 4. 계좌 조회");
			System.out.println("■ 5. 사용자 검색");
			System.out.println("■ 6. 프로그램 종료 ");
			// 1. 프로그램 전체반복
			// 2. 1~6번까지 번호만 허용 (나머지는 무한반복 다시 입력)
			// 3. 계좌개설 (INSERT)
			// 4. 계좌 조회 (SELECT, 전체조회)
			// 5. 사용자 검색(이름으로)
			// 6. 프로그램 종료
			while (true) {
				System.out.println("숫자를 입력하세요 ");
				System.out.println(">>숫자");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println(" 오류입니다. 다시 숫자를 입력하세요");
					continue;
				}
			}

			if (code == 1) {// 계좌 개설
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

				System.out.println("통장을 개설 합니다. 성함을 입력 하세요 ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.println("비밀번호를 입력 하세요 ");
				String pw = sc.nextLine();
				BankDTO bDto = new BankDTO(bname, pw);

				bDao.BankInsert(bDto);

			} else if (code == 2) { // 입금

				System.out.println(" 계좌번호를  입력 하세요 ");
				// sc.nextLine();
				int bno = sc.nextInt();

				System.out.println("입금할 금액를 입력 하세요 ");
				int money = sc.nextInt();

				bDao.Bankin(bno, money);

			} else if (code == 3) { // 출금
				while (true) {
					System.out.println(" 계좌번호를  입력 하세요 ");
					// sc.nextLine();
					int bno = sc.nextInt();

					sc.nextLine();
					System.out.println("비밀번호를 입력 하세요 ");
					String pw = sc.nextLine();

					bDao.Open(bno, pw);

					int succed = bDao.Open(bno, pw);
					
						if (succed == 1) {
						
							
							System.out.println("출금할 금액을 입력 하세요");
							int money = sc.nextInt();
							
							
							bDao.Bankout(bno, money);
							
							break;
						} else if (succed == 2) {
							System.out.println(" 없는 계좌이거나 암호가 틀렸습니다.");
							continue;
						}
					
				}

			}

			
			// 계좌번호
			// 패스워드
			// DB(계좌번호, 패스워드 select)
			// 값이 없는 경우
			// 없는 계좌이거나 암호가 틀렸습니다.
			// 메인

			// 값이 있는 경우
			// select 계좌번호 => 계좌잔액 출력
			// 출금 -> 출금>계좌잔액 = 금액이 부족합니다
			// 출금 -> update 계좌잔액 - 출금 = 계좌잔액
			// 출금완료

			else if (code == 4) { // 계좌조회

				System.out.println("조회할 계좌번호를 입력하세요");
				int bno = sc.nextInt();

				sc.nextLine();
				System.out.println(" 비밀번호를 입력하세요");
				String pw = sc.nextLine();

				bDao.BankSelect(bno, pw);

			} else if (code == 5) {// 사용자 검색

			} else if (code == 6) {

				System.out.println("프로그램을 종료 합니다.");
				System.exit(0);

			}

		}
	}
}