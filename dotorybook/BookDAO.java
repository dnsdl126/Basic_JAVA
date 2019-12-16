package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.DDEnter.DBManager;

public class BookDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();

	public void bookInsert(BookDTO bDto) {
		System.out.println(bDto.toString());
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
							+ " VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bDto.getBname());
				pstmt.setInt(2, bDto.getPrice());
				pstmt.setString(3, bDto.getCompany());
				pstmt.setString(4, bDto.getWriter());
				
				int result = pstmt.executeUpdate();
				if(result>0) {
					System.out.println(bDto.getBname()+"등록완료 되었습니다.");
				}else {
					System.out.println("등록실패");
				}
				
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
	}

	public void bookUpdate(BookDTO bDto) {
		System.out.println(bDto.toString());
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_book " 
						+ "SET bno = ?, "
						+ "price = ?, " 
						+ "company = ?, " 
						+ "writer = ? "
						+ "WHERE bname = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBno());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			pstmt.setString(5, bDto.getBname());

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(bDto.getBname() + "수정완료했습니다.");
			} else {
				System.out.println("수정실패했습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void bookDelete(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_book "
					   + "WHERE bname = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname );
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				
				System.out.println(bname + "삭제하였습니다.");
			} else {
				System.out.println("삭제에 실패 하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

	public void bookSelete() {
		// DB는 받드시 예외처리가 필요 (try, catch, finally
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for (BookDTO line : list) {
				System.out.print(line.getBno() + "\t");
				System.out.print(line.getBname() + "\t");
				System.out.print(line.getPrice() + "\t");
				System.out.print(line.getCompany() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public void bookSearch(String bname) {
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM tbl_book " + "WHERE bname LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bname + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);

			}
			for (BookDTO line : list) {
				System.out.print(line.toString());
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void madeBy() {
	}

}
