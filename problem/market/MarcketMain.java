package problem.market;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MarcketMain {

	// 내부저장소
	// 관리자 계정 ID 와 PW 선언
	// 전역 변수
	String id = "admin";
	String pw = "1234";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		SaleDAO sDao = new SaleDAO();
		MarcketMain mm = new MarcketMain();
		int code;
		// 프로그램 시작
		// 지역변수 가 공백값
		String userid = "";
		String userpw = "";

		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■■■ Moomin Marcket System Ver1.0 ■■■");

		// 1. 마켓 메인 클레스에 login 메서드를 갈때 userid(공백), userpw(공백)를 가지고 가라

		// 4. while 에 true가 들어 와서 while 문 실행
		// do { // do{ } while (조건문); 조건문이 true일때 반복
		// while하고 차이점은 최초 do한번 실행 하고 진행

		// System.out.println("■■ [MSG] please login to use.");
		// System.out.print("■■ ID>>");
		// userid = sc.nextLine();
		// System.out.print("■■ ID>>");
		// userpw = sc.nextLine();
		// } while(mm.login(userid, userpw));
		// 로그인 성공 업무 시작
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■ 1. 제품 판매");
			System.out.println("■■■ 2. 제품 등록 & 추가");
			System.out.println("■■■ 3. 제품 수정");
			System.out.println("■■■ 4. 제품 삭제");
			System.out.println("■■■ 5. 제품 조회");
			System.out.println("■■■ 6. 제품 검색");
			System.out.println("■■■ 7. 일일 매출  현황 ");
			System.out.println("■■■ 8. 프로그램 종료");
			while (true) {
				System.out.println("■■■Code>> ");
				code = sc.nextInt();

				if (code >= 1 && code <= 8) {
					break;
				} else {
					System.out.println("번호를 다시 입력해 주세요");
					continue;
				}
			}

			if (code == 1) {
				System.out.println("■■■ 1. 제품 판매");
				System.out.println("■■■ 판매할 제품 번호를 입력 하세요");
				// 현재 등록된 제품중 재고가1보다 큰거 (즉 수량이 0이아닌 것)
				int tprice = 0;
				int cnt = 0;
				String sname = "";
				List<ProductDTO> list = pDao.selectUsePdt();
				pDao.selectUsePdt();

				while (true) {
					System.out.println(">> 구매할 번호");
					int buyCode = sc.nextInt();
					System.out.println(">> 구매할 수량");
					cnt = sc.nextInt();
					// 판매하려는 제품명
					int nowCnt = list.get(buyCode - 1).getCnt();
					// guswo worh
					sname = list.get(buyCode - 1).getPname();
					// 사용자가 구매하려는 제품의 1개 가격
					int price = list.get(buyCode - 1).getPrice();
					// 총가격 = 1개가격 * 구매수량
					tprice = price * cnt;
					// tbl_sale 에 판매한 기록을 저장

					if (nowCnt >= cnt) {
						break;
					} else {
						System.out.println("에러");
					}
				}
				HashMap<String, Object> map = new HashMap<>();
				map.put("sname", sname);
				map.put("cnt", cnt);
				map.put("tprice", tprice);
				int result = sDao.insertSale(map);
				if (result > 0) {
					System.out.println("판매성공 재고 - 합니다");
					// tbl_product에서 재고를 마이너스
					pDao.cntMinusPdt(sname, cnt);
				} else {
					System.out.println("Error");
				}
			} else if (code == 2) {
				// 1. 기존재고가 DB에 있었는지 확인
				// 2. 재고가 있으면 재고 추가 , 없으면 새로 등록
				// ex) 이름을 입력받는다 -> 이름이 있는지 DB검색 ->있으면 재고 추가 ->없으면 신규 등록
				System.out.println("■■■ 2. 제품 등록 & 추가");
				System.out.println("■■■ 제품 이름을 입력하세요 ");
				sc.nextLine();
				String pname = sc.nextLine();
				if (pDao.pdtAlready(pname)) {
					// 기존에 등록된 제품이므로 추가(UPDATE) 기능
					// 입고수량 입력 받아서 UPDATE
					System.out.println("입고수량을 입력하세요");
					int cnt = sc.nextInt();
					pDao.cntchange(cnt, pname);
				} else {
					// 최초 등록된 제품이므로 등록(INSERT) 기능
					// 제조회사, 가격, 입고수량 입력 받아서 INSERT
					System.out.println("상품을 등록합니다.");

					System.out.print(" >> 제조사 ");
					String company = sc.nextLine();

					System.out.print(">> 제품명 ");
					pname = sc.nextLine();

					System.out.print(">> 가격 ");
					int price = sc.nextInt();

					System.out.print(">> 입고수량 ");
					int cnt = sc.nextInt();

					pDao.insertPdt(company, pname, price, cnt);

				}

			} else if (code == 3) {
				System.out.println("■■■ 3. 제품 수정");
				sc.nextLine();
				System.out.println("■■■ 수정할 제품을 검색해 주세요");
				String keyword = sc.nextLine();
				pDao.pdtSearch(keyword);

				System.out.println("변경할 제품의 번호를 입력하세요");
				int pno = sc.nextInt();
				sc.nextLine();
				System.out.println(">> 제품 이름");
				String pname = sc.nextLine();
				System.out.println(">> 제조사");
				String company = sc.nextLine();
				System.out.println(">> 가격");
				int price = sc.nextInt();
				System.out.println(">> 수량");
				int cnt = sc.nextInt();

				pDao.pdtUpdate(pno, pname, company, price, cnt);

			} else if (code == 4) {
				System.out.println("■■■ 4. 제품 삭제");
				sc.nextLine();
				System.out.println("삭제할 제품 명을 입력하세요");
				String pname = sc.nextLine();

				if (pDao.pdtAlready(pname)) {

					pDao.pdtDelete(pname);

				} else {
					System.out.println("등록되지 않은 상품입니다.");

				}
			} else if (code == 5) {
				System.out.println("■■■ 5. 제품 조회");
				pDao.pdtSelect();

			} else if (code == 6) {
				System.out.println("■■■ 6. 제품 검색");
				sc.nextLine();
				System.out.println("■■■ 검색할 제품 이름을 검색해 주세요");

				String keyword = sc.nextLine();

				pDao.pdtSearch(keyword);

			} else if (code == 7) {
				
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■일일매출 현황 입니다.");
				sDao.dashBoard();
				

			} else if (code == 8) {

				System.out.println("■■ [MSG] Exit the program.");
				System.exit(0);

			}
		}
	}
	// 메인메서드 (static ) 객체 생성없이 쓸수 있지만 login 메서드는 객체 생성을 해야 한다
	// MarcketMain mm = new MarcketMain으로 객 체 생성을 해서 사용

	public boolean login(String userid, String userpw) { // 2. userid 와 userpw는 왓는데 공백 상태

		Boolean flag = true; // 로그인 유무 판별 (true : 실패 , false:성공)

		if (userid.equals(id) && userpw.equals(pw)) {
			flag = false;
			System.out.println("환영합니다. 관리자님 ");
		} else {
			System.out.println("■■ [MSG] Login denied.");

		}
		return flag; // 돌아갈때 true를 가지고 돌아간다

	}

}