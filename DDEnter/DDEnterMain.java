package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 1. 화면에 출력하는 부분
		while (true) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒더블디 엔터 관리 시스템 ");
			System.out.println("▒▒1. 아티스트 등록");
			System.out.println("▒▒2. 아티스트 수정");
			System.out.println("▒▒3. 아티스트 해지");
			System.out.println("▒▒4. 아티스트 조회");
			System.out.println("▒▒5. 아티스트 검색");
			System.out.println("▒▒6. 프로그램 종료");
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

			
			// 2.사용자가 실행할 프로그램을 입력받는 부분
			int code = 0;
			while (true) {
				System.out.println("번호>>");
				code = sc.nextInt();
				// 사용자가 1~6까지 입력하기 전까지 계속 번호를 반복하도록
				if (code >= 1 && code <= 6) {
					break;
				} else {
					System.out.println("1~6까지만 입력하세요");
					continue;
				}
				// 사용자가 1~6까지 입력하기 전까지
				// 계속 번호를 입력하게 도는 반복문 (경고문도 출력)

			}
			
			//사용자가 입력한값이 1~6인경우에만 넘어온다.
			MemberDAO mDao = new MemberDAO(); //MemberDAO 기능이 필요해서 불러 왔군 
			
			if(code == 1) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒계약할 아티스트 정보를 입력해 주세요 ");
				System.out.println("▒▒ 이름>>");
				sc.nextLine();//한줄개행
				String aname = sc.nextLine();
				System.out.println("▒▒ 분야>>");
				String major = sc.nextLine();
				System.out.println("▒▒ 그룹유무(y/n)>>");
				String groupyn = sc.nextLine();
				System.out.println("▒▒ 그룹이름>>");
				String groupnm = sc.nextLine();
				System.out.println("▒▒ 연봉>>");
				int sal = sc.nextInt();
				
				MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal);
				mDao.memInsert(mDto);
			}else if(code == 2) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒수정할 아티스트 번호를 알려주세요 ");
				System.out.println("▒▒번호>>");
				sc.nextLine();//한줄개행
				String ano = sc.nextLine();
				System.out.println("▒▒ 이름>>");
				String aname = sc.nextLine();
				System.out.println("▒▒ 분야>>");
				String major = sc.nextLine();
				System.out.println("▒▒ 그룹유무(y/n)>>");
				String groupyn = sc.nextLine();
				System.out.println("▒▒ 그룹이름>>");
				String groupnm = sc.nextLine();
				System.out.println("▒▒ 연봉>>");
				int sal = sc.nextInt();
				
				//이름, 전공, 그룹유무, 그룹이름, 연봉
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);
				
				mDao.memUpdate(mDto);
			}else if(code == 3) {// 아티스트 삭제 
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒삭제할 아티스트 번호를 알려주세요 ");
				System.out.println("▒▒번호>>");
				sc.nextLine();
				String ano = sc.nextLine();
				mDao.memDelete(ano);
			
			}else if(code == 4) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒회사에 소속된 아티스트 명단입니다. "); //전체 조회
				mDao.memSelect();
			}else if(code == 5 ) {
				System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
				System.out.println("▒▒검색할 아티스트의 이름을 입력하세요 "); //전체 조회
				System.out.println("▒▒이름>>");
				sc.nextLine();
				String aname = sc.nextLine();
				
				mDao.memSerch(aname);
			}else if(code == 6) {
				
				System.out.println("프로그램 종료");
				System.exit(0);
			}

		}

	}
}
