package problem.DDEnter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ArrayList<MemberDTO> list = new ArrayList<>();

	// 1. 아티스트등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
					+ "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);// 있어야 ?를 채울수 있다.
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("==" + mDto.getAname() + "을 등록하였습니다.");
			} else {
				System.out.println("등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	// 2. 아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {// 1. 드라이버 로드
				// 2. Connection
			conn = DBManager.getConnection();
			// 3. SQL작성(PreparedStatement)

			String sql = "UPDATE tbl_enter " // 미완성 단계
					+ "SET aname = ?, " + "major = ?, " + "groupyn = ?, " + "groupnm = ?, " + "sal = ? "
					+ "WHERE ano = ?";

			pstmt = conn.prepareStatement(sql);// 있어야 위에 ?를 채울수 있다.
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			// 4. SQL실행
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒" + mDto.getAno() + "수정에 완료 하였습니다.");
			} else {
				System.out.println("▒▒수정에 실패하였습니다.");
			}
			//

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. close(연결끊기)
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	// 3. 아티스트 삭제
	public void memDelete(String ano) {
		try {
			// 1.드라이버 로드, 2.DB연결
			conn = DBManager.getConnection();
			// 3. SQL문 작성 (PrepareStatement 방식)
			String sql = "DELETE FROM tbl_enter " + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql); // 미완성 sql문
			// 3.1 미완성 sql문 완성(바인딩변수 사용)
			pstmt.setString(1, ano); //
			// 4. SQL문 실행
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒" + ano + "아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▒▒삭제에 실패하였습니다.");
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

	// 4. 아티스트 조회
	public void memSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_Enter";
			pstmt = conn.prepareStatement(sql);

			// 4. SQL실행
			// ResultSet = SELECT 결과를 담음
			ResultSet rs = pstmt.executeQuery();// SECET 문만 사용 RsultSet 는 DB용

			// ResultSet은 DB관련 객체
			// JAVA 전용 ArrayList(여러가지를 한번에 담는)에 ResultSet에 데이터를
			// 옮겨 담는작업이 필요하다

			while (rs.next()) {
				// rs.next 결과값을 true로 바꿔준다 -> 반복을 돌아준다
				// 테이블이 몇개 있을지 모르니 while로 바꿔준다
				// 테이블이 없으면 false로 인식 해서 while을 빠져나간다
				// 반복 한번당 한줄 인식

				String ano = rs.getString("ano");
				String aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate); // 값을 다가지고 와서 DTO로 담음
				list.add(mDto);

			}
			for (MemberDTO line : list) {
				System.out.println(line.toString()); // 아래 와 값이 똑같이 나온다
				// System.out.print(line.getAname()+"\t");
				// System.out.print(line.getAno()+"\t");
				// System.out.print(line.getMajor()+"\t");
				// System.out.print(line.getGroupyn()+"\t");
				// System.out.print(line.getGroupnm()+"\t");
				// System.out.print(line.getSal()+"\t");
				// System.out.print(line.getRegdate()+"\t");
				// System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	// 5. 아티스트 검색
	public void memSerch(String aname) {
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM tbl_enter "
						+ "WHERE aname LIKE ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+aname+"%");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String ano = rs.getString("ano");
				aname = rs.getString("aname");
				String major = rs.getString("major");
				String groupyn = rs.getString("groupyn");
				String groupnm = rs.getString("groupnm");
				
				int sal = rs.getInt("sal");
				Date regdate = rs.getDate("regdate");
				
				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal, regdate);
				list.add(mDto);
				
				
				
			}
			for(MemberDTO line : list) {
				System.out.print(line.toString());
				System.out.println();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
