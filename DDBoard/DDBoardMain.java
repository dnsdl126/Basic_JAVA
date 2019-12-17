package problem.DDBoard;

import java.sql.Date;
import java.util.Scanner;

import problem.dotorybook.BookDTO;

public class DDBoardMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호 
		
		while(true) {
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		System.out.println("☆★ 무만 world 게시판☆★");
		bDao.BoardSelect();
		System.out.println("☆★1. 게시글 등록");
		System.out.println("☆★2. 게시글 수정");
		System.out.println("☆★3. 게시글 삭제");
		System.out.println("☆★4. 게시글 조회");
		System.out.println("☆★5. 게시글 검색");
		System.out.println("☆★6. 게시글 정렬");
		System.out.println("☆★7. 상세 게시글");
		System.out.println("☆★8. 만든이");
		System.out.println("☆★9. 프로그램종료");
		System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");

	

		while (true) {
			System.out.println("☆★번호>>");
			code = sc.nextInt();
			
			if (code >= 1 && code <= 9) {
				break;

			} else  {
				System.out.println("1~9번까지 숫자로 다시입력하세요");
				continue;
			}

		}
		
		if(code==1) {
			
			System.out.println("☆★게시글을 등록 합니다.☆★");
			
			System.out.println("☆★번호☆★");
			
			int bno = sc.nextInt();
			sc.nextLine();
			System.out.println("☆★제목☆★");
			String title = sc.nextLine();
			System.out.println("☆★분류☆★");
			String content = sc.nextLine();
			System.out.println("☆★글쓴이☆★");
			String writer = sc.nextLine();
			
			
			BoardDTO bDto = new BoardDTO(bno, title, content, writer);
			
			bDao.BoardInsert(bDto);
			
			
		} else if (code==2) { //☆★2. 게시글 수정
			
			System.out.println("수정할 게시물의 번호를 입력하세요 ");
			 System.out.println(">>번호");
			 sc.nextLine();
			 int bno = sc.nextInt();
			  
			  System.out.println(">>제목");
			  sc.nextLine();
			  String title = sc.nextLine();
			  
			  System.out.println(">>분류");
			  String content= sc.nextLine();
			 
			  System.out.println(">>작성자");
			  String writer = sc.nextLine();
			  
			  BoardDTO bDto = new BoardDTO(bno, title, content, writer);
			  
			  bDao.BoardUpdate(bDto);
			  
			
		} else if (code==3) {//☆★3. 게시글 삭제
			System.out.println("삭제할 게시글 번호를 입력하세요");
			int bno = sc.nextInt();
			
			bDao.BoardDelete(bno);
			
			
		} else if (code==4) {
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("게시글 목록 입니다 ");
			bDao.BoardSelect();
			
		} else if (code==5) {//☆★5. 게시글 검색
			
			System.out.println("검색할 게시글 제목을 입력하세요");
			sc.nextLine();
			String title = sc.nextLine();
			 System.out.println();
			 bDao.BoardSearch(title);
			
			
		} else if (code==6) {
			
		} else if (code==7) {
			
		} else if (code==8) {
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("☆★name : mooman world Board program");
			System.out.println("☆★Version: 1.7");
			System.out.println("☆★use : JAVA, ORACLE");
			System.out.println("☆★Date : 2019.12.17");
			System.out.println("☆★made by ZZangpu.loa");
			System.out.println("☆★dnsdl1217@naver.com");
		} else if (code==9) {
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println("☆★프로그램 종료");
			System.exit(0);
			
		}
		

	}

}
}