package problem.board;

import java.util.Scanner;
// 로그인 기능 추가
// Session = 로그인 yes or no
// userid = "login 유저 id"

// 가입되어있다 -> toes -> login ok
// 가입 되어ㅣ있지 않다 -> ID or pw가 틀렸습니다 -> 가입등록 

public class BoardMain {

	static String session = "NO"; // 로그인 유무 ( YES : LOGIN ON) , 수정 , 삭제 등 로그인 기능이 모두 필요하므로
									 // static으로 선언 해준다 
	static String userid="";
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO(); // 게시글 관련 기능들
		MemberDAO mDao = new MemberDAO(); // 회원 관련 기능
		int code = 0; // 사용자가 선택한 프로그램 번호
		

		while (true) {
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("☆★ 무만 world 게시판☆★");
			System.out.println("☆★0. 로그인");
			System.out.println("☆★1. 게시글 등록");
			System.out.println("☆★2. 게시글 수정");
			System.out.println("☆★3. 게시글 삭제");
			System.out.println("☆★4. 게시글 조회");
			System.out.println("☆★5. 게시글 검색");
			System.out.println("☆★6. 게시글 정렬");
			System.out.println("☆★7. 상세 게시글");
			System.out.println("☆★8. 만든이");
			System.out.println("☆★9. 로그아웃");
			System.out.println("☆★10. 프로그램 종료");
			if(BoardMain.session.equals("yes")) {
			System.out.println("☆★\"" + BoardMain.userid + "\"님 방문을 환영합니다 ");
			}
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");

			while (true) {
				System.out.println("☆★번호>>");
				code = sc.nextInt();

				if (code >= 0 && code <= 10) {
					break;

				} else {
					System.out.println("1~9번까지 숫자로 다시입력하세요");
					continue;
				}

			}

			if (code == 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("ID와 pw를 입력해 주세요");
				System.out.print("■■ ID>>");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("■■ PW>>");
				String pw = sc.nextLine();

				mDao.login(id, pw);
			} else if (code == 1) {
				
				if(BoardMain.session.equals("NO")) { // 로그인 no
					System.out.println("■■■■ 로그인이 필요 합니다");
					continue;
				}

				System.out.println("☆★게시글을 등록 합니다.☆★");

				sc.nextLine();

				System.out.println("☆★제목☆★");
				String title = sc.nextLine();
				System.out.println("☆★분류☆★");
				String content = sc.nextLine();
				
				String writer = BoardMain.userid;

				bDao.BoardInsert(title, content, writer);

			} else if (code == 2) { // ☆★2. 게시글 수정

				System.out.println("수정할 게시물의 번호를 입력하세요 ");
				System.out.println(">>번호");
				int bno = sc.nextInt();

				sc.nextLine();

				System.out.println(">>제목");
				String title = sc.nextLine();

				System.out.println(">>분류");
				String content = sc.nextLine();

				System.out.println(">>작성자");
				String writer = sc.nextLine();

				BoardDTO bDto = new BoardDTO(bno, title, content, writer);

				bDao.BoardUpdate(bDto);

			} else if (code == 3) {// ☆★3. 게시글 삭제
				if(BoardMain.session.equals("NO")) {
					System.out.println("■■■■ 로그인이 필요 합니다");
					continue;
				}
				System.out.println("삭제할 게시글 번호를 입력하세요");
				int bno = sc.nextInt();
				 
				
				
				
				String getuser = bDao.getWriter(bno);
				
				
				if ( BoardMain.userid.equals(getuser)) { //String 객체 자료형은 각자 주소를 가지고 오기 때문에 
					                                     // 주소가 아닌 값을 가지고 오려면 equals로 비교 해야한다
					
					bDao.BoardDelete(bno);
					System.out.println( bno + "삭제 완료 ");
					
				} else {
					
					System.out.println("삭제 실패 아이디가 일치하지 않습니다 ");
				}
				 


			} else if (code == 4) {
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("게시글 목록 입니다 ");
				bDao.BoardSelect();

			} else if (code == 5) {// ☆★5. 게시글 검색

				System.out.println("검색할 키워드를 입력하세요");
				sc.nextLine();
				String keyword = sc.nextLine();
				System.out.println();
				bDao.BoardSearch(keyword);

			} else if (code == 6) {
				System.out.println("게시글을 정렬 합니다");
				bDao.BoardSort();

			} else if (code == 7) {
				System.out.println("조회할 게시글 번호를 입력하세요");
				int bno = sc.nextInt();
				 bDao.BoardView(bno);

			} else if (code == 8) {
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("☆★name : mooman world Board program");
				System.out.println("☆★Version: 1.7");
				System.out.println("☆★use : JAVA, ORACLE");
				System.out.println("☆★Date : 2019.12.17");
				System.out.println("☆★made by ZZangpu.loa");
				System.out.println("☆★dnsdl1217@naver.com");
			} else if (code == 9) {// 로그아웃
				// 조건  1 : 로그인 되어있는 상태 -> 로그아웃진행
				// 조건  2 : 로그인이 되어 있지 않은 상태 -> 로그인이 되어있지 않다 경고문 
				
				if(BoardMain.session.equals("yes")) { // 로그인 되어있는 상태
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■"+BoardMain.userid+"님 로그아웃 되었습니다");
					BoardMain.session="NO";
					BoardMain.userid="";
				} else {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println(" 로그인이 필요한 기능 입니다.");
				}
				

			} else if (code == 10) {
				System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
				System.out.println("☆★프로그램 종료");
				System.exit(0);

			}


		}

	}

}
