package problem.bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.DBManager;

public class BankDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;
	int result;

	public void BankInsert(BankDTO bDto) {

		try {

			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno,bname,pw) " + "VALUES(seq_bank.NEXTVAL, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());

			result = pstmt.executeUpdate();

			if (result > 0) {

				System.out.println("통장 개설 완료 ");
			} else {
				System.out.println("오류입니다. 다시 개설해 주세요 ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void Bankin(int bno, int money) {

		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank " + "SET money = money + ? " + "WHERE bno = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, money);
			pstmt.setInt(2, bno);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println(money + "입금완료");
				search(bno);

			} else {
				System.out.println("입금실패");
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

		}

	}

	public void Bankout(int bno, int money) {

		wallet(bno);
		if (money > result ||  result == 0) {
			System.out.println("잘못된금액 입니다. 통장 잔고를 확인해주세요");
			return;
		} 
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE tbl_bank "  
			           + "SET money = money - ? " 
					   + "WHERE bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, bno);

			int open = pstmt.executeUpdate();

			if (open > 0) {
				search(bno);
			} else {
				System.out.println("출금오류");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	public void BankSelect(int bno, String pw) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank " + "WHERE bno LIKE ? and " + "pw LIKE ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bno);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");

				bDto = new BankDTO(bno, bname, money, regdate);

			}
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■계좌번호 :" + bDto.getBno());
			System.out.println("■■■■■이   름  :" + bDto.getBname());
			System.out.println("■■■■■잔   고  :" + bDto.getMoney());
			System.out.println("■■■■■개 설 일 :" + bDto.getRegdate());

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

	public void search(int bno) {

		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + "FROM tbl_bank " + "WHERE bno LIKE ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {

				bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");

				bDto = new BankDTO(bno, bname, money, regdate);
				list.add(bDto);

			}

			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■계좌번호 :" + bDto.getBno());
			System.out.println("■■■■■잔   고  :" + bDto.getMoney());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	public int Open(int bno, String pw) {

		int conp = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + "FROM tbl_bank " + "WHERE bno LIKE ? and " + "pw LIKE ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bno);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				conp = 1;
			} else {
				conp = 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return conp;

	}

	public int wallet(int bno) {

		result = 0;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * " + "FROM tbl_bank " + "WHERE bno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int money = rs.getInt("money");

				result = money;

			} else {
				result = 2;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return result;

	}
}
