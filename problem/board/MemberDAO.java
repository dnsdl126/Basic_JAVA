package problem.board;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	//로그인 기능
	public void login(String id, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("pw", pw);
		 
		 
		try {
			int flag = sqlSession.selectOne("member.login",map); // member mapper 안에 있는 login 기능을 찾아와라      
			                                                     // 1줄짜리 -> DTO,  여러줄 -> List
			if(flag>0)  { //로그인 성공
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■반갑습니다. " + id + "님");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				BoardMain.session = "yes";
				BoardMain.userid = id;
				
			} else { //로그인 실패 
			    System.out.println("■■ id or pw가 틀렸습니다 확인해주세요");
			    return;
			}
			                                                    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			
		}
		
	}
	
	// 로그아웃 기능
	public void logout() {}

	//회원가입
	//회원수정
	//회원삭제
	//회원검색
	//회원조회
}

