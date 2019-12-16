package problem.dotorybook;

import java.util.Scanner;

public class DotoryBookMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
			System.out.println("◆◇도토리 서점 관리 시스템 ver1.2");
			System.out.println("◆◇1.도서등록");
			System.out.println("◆◇2.도서수정");
			System.out.println("◆◇3.도서삭제");
			System.out.println("◆◇4.도서조회");
			System.out.println("◆◇5.도서검색");
			System.out.println("◆◇6.만든이");
			System.out.println("◆◇7.프로그램 종료");
			System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");

			int code = 0;
			while (true) {
				System.out.println("◆◇번호>>");
				code = sc.nextInt();

				if (code >= 1 && code <= 7) {
					break;
				} else {
					System.out.println("◆◇1~7 까지의 번호로 다시 입력하세요");
					continue;
				}
			}
			BookDAO dDao = new BookDAO();
			if (code == 1) {

				System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
				System.out.println("◆◇등록할 책 제목을 입력하세요");
				System.out.println("◆◇제목");
				sc.nextLine();
				String bname = sc.nextLine();
			
				System.out.println("◆◇책번호");
				String bno = sc.nextLine();
				System.out.println("◆◇책가격");
				int price = sc.nextInt();
				System.out.println("◆◇출판사");
				sc.nextLine();
				String company = sc.nextLine();
				System.out.println("◆◇저자");
				String writer = sc.nextLine();
				
				BookDTO bDto = new BookDTO(bname, price, company, writer);
				dDao.bookInsert(bDto);
			
			} else if (code == 2) {
				System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
				System.out.println("◆◇수정할 책 제목을 입력하세요");
				System.out.println("◆◇제목");
				sc.nextLine();
				String bname = sc.nextLine();
			
				System.out.println("◆◇책번호");
				String bno = sc.nextLine();
				System.out.println("◆◇책가격");
				int price = sc.nextInt();
				System.out.println("◆◇출판사");
				sc.nextLine();
				String company = sc.nextLine();
				System.out.println("◆◇저자");
				String writer = sc.nextLine();

				BookDTO bDto = new BookDTO(bname, price, company, writer);
				dDao.bookUpdate(bDto);
			} else if (code == 3) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒삭제할 책 제목를 알려주세요 ");
				System.out.println("▒▒번호>>");
				sc.nextLine();
				String bname = sc.nextLine();
				dDao.bookDelete(bname);
		
			} else if (code == 4) {
				System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
				System.out.println("◆◇현재 판매중인 도서 목록을 출력합니다.");
				dDao.bookSelete(); 

			} else if (code == 5) {
				System.out.println("◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇◆◇");
				System.out.println("◆◇책 제목을 입력하세요 ");
				sc.nextLine();
				String bname = sc.nextLine();
				
				dDao.bookSearch(bname);

			} else if (code == 6) {

			} else if (code == 7) {
				System.out.println("◆◇프로그램 종료 ");
				System.exit(0);
			}

		}

	}
}
