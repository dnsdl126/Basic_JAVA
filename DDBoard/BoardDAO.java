package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.DBManager;

public class BoardDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();

	public void BoardInsert(BoardDTO bDto) {

		try {

			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) " 
			           + "VALUES(seq_board.NEXTVAL, ?, ?, ?, ? )";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getTitle());
			pstmt.setString(2, bDto.getContent());
			pstmt.setString(3, bDto.getWriter());
			pstmt.setDate(4, bDto.getRegdate());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("게시글 등록 완료 ");
			} else {
				System.out.println("다시 등록 해주세요 ");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void BoardUpdate(BoardDTO bDto) {
		
		try {
			System.out.println(bDto.toString());
		conn = DBManager.getConnection(); 	
		String sql = "UPDATE tbl_board "
				   + "SET title = ?, "
				   + "content = ?, "
				   + "writer = ? "
				   + "WHERE bno = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, bDto.getTitle());
		pstmt.setString(2, bDto.getContent());
		pstmt.setString(3, bDto.getWriter());
		pstmt.setInt(4, bDto.getBno());
		
		int result = pstmt.executeUpdate();
		
		if(result >0) { 
			System.out.println(bDto.getBno() + "수정 완료");
		} else {
			System.out.println("수정실패");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

	public void BoardDelete(int bno) {
		
		try {
			
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board "
						+ "WHERE bno = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println( bno + "삭제완료");
			} else {
				System.out.println("삭제에 실패 하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public void BoardSelect() {

		try {

			conn = DBManager.getConnection();

			String sql = " SELECT * FROM tbl_board ";

			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			list.clear();
			while (rs.next()) {

				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BoardDTO bDto = new BoardDTO(bno, title, content, writer);// 1줄에 담는다

				list.add(bDto); // 1줄씩 내용이 추가가 됨

			}

			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
			System.out.println(" 번호 \t 제목\t\t 분류\t 작성자\t 작성일");
			for (BoardDTO line : list) {
				System.out.println(line.toString());

			}
			System.out.println("☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void BoardSearch(String title) {
		
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT * FROM tbl_board "
					   + "WHERE title LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			
			list.clear();
			
			while(rs.next()) {
		
				
				int bno = rs.getInt("bno");
				title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				
				BoardDTO bDto = new BoardDTO(bno, title, content, writer, regdate);
				list.add(bDto);
				
			}
			
			for(BoardDTO line : list) {// 한번에 출력 
				System.out.print(line.toString());
				System.out.println();
			}
			int number = list.size();
			System.out.println(number + "건 검색되었습니다.");
			
		} catch (Exception e) {
		
		} finally {
			
		}
		
	}

	public void BoardView() {
	}

	public void BoardSort() {
	}

}
