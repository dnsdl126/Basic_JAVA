package problem.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	SqlSession sqlSession;

	BoardDTO bDto = new BoardDTO();
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	List<BoardDTO> list2;
	int result;

	public void BoardInsert(String title, String content, String writer) {

		sqlSession = sqlSessionFactory.openSession(true);
		bDto = new BoardDTO(title, content, writer);

		try {

			result = sqlSession.insert("BoardInsert", bDto);

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

		sqlSession = sqlSessionFactory.openSession(true);

		try {

			result = sqlSession.update("BoardUpdate", bDto);

			if (result > 0) {
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

		sqlSession = sqlSessionFactory.openSession(true);
		try {

			result = sqlSession.delete("BoardDelete", bno);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void BoardSelect() {

		sqlSession = sqlSessionFactory.openSession(true);
		try {

			list2 = sqlSession.selectList("BoardSelect");

			for (BoardDTO line : list2) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void BoardSearch(String keyword) {

		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);

		try {

			list2 = sqlSession.selectList("BoardSearch", map);

			if (result > 0) {
				for (BoardDTO line : list2) {

					System.out.println(list2.size() + "건 검색되었습니다.");
					System.out.println(line.toString());
				}
			} else {

				System.out.println("검색 결과가 없습니다.");
			}

		} catch (Exception e) {

		} finally {

		}

	}

	public void BoardView(int bno) {

		int result = viewCnt(bno);
		sqlSession = sqlSessionFactory.openSession();

		if (!(result > 0)) {
			System.out.println("조회수 오류");
			return;
		}

		try {
			bDto = sqlSession.selectOne("BoardView", bno);
			

				System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");
				System.out.println("◈◈ 게시글 번호 : " + bno);
				System.out.println("◈◈ 작성일자 : " + bDto.getRegdate());
				System.out.println("◈◈ 조회수 : " + bDto.getViewcnt());
				System.out.println("◈◈ 제목 : " + bDto.getTitle());
				System.out.println("◈◈ 작성자 : " + bDto.getWriter());
				System.out.println("◈◈ 내용 : " + bDto.getContent());
				System.out.println("◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈◈");

			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void BoardSort() {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list2 = sqlSession.selectList("BoardSort");

			for (BoardDTO line : list2) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();

		}
	}

	public int viewCnt(int bno) {

		sqlSession = sqlSessionFactory.openSession(true);
		try {

			result = sqlSession.update("viewCnt", bno);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
         sqlSession.close();
		}
		
		return result;

	}
	
	public String getWriter (int bno) {
		System.out.println(">>>>>>>> 탓음" );
		String user = null; 
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			 user = sqlSession.selectOne("board.getWriter", bno);
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+user);
			
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			sqlSession.close();
		} 
		return user;
	}
	
	

}
