package problem.market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	boolean flag; // default : false

	public void sellmarcket() {
	}

	public boolean pdtAlready(String pname) {
		// 제품 등록 & 추가 기능 작동시 기존에 등록된 제품인지 최초 입고제품인지 판별하는 기능

		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("pdt.already", pname);
			if (result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}

	public int Allcnt(String pname) { // 총수량 확인하는 메서드

		sqlSession = sqlSessionFactory.openSession();

		try {
			result = sqlSession.selectOne("Allcnt", pname);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public void pdtCntPlus(int cnt, String pname) { // 수량 입고 메서드

		sqlSession = sqlSessionFactory.openSession(true);

		HashMap<String, Object> map = new HashMap<>();
		map.put("cnt", cnt);
		map.put("pname", pname);

		try {
			result = sqlSession.update("cntPlus", map);
			if (result > 0) {
				System.out.println(pname + "의 총수량은" + Allcnt(pname) + "개 입니다");

			} else {

				System.out.println(" 오류입니다 다시 입력해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSession.close();
	}

	public void insertPdt(String company, String pname, int price, int cnt) { // 상품등록

		sqlSession = sqlSessionFactory.openSession(true);

		HashMap<String, Object> map = new HashMap<>();
		map.put("company", company);
		map.put("pname", pname);
		map.put("price", price);
		map.put("cnt", cnt);

		try {
			result = sqlSession.update("insertPdt", map);

			if (result > 0) {
				System.out.println(pname + "을 등록 완료 하였습니다");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ ");
				System.out.println("■■ 회사 :" + company);
				System.out.println("■■ 제품명 :" + pname);
				System.out.println("■■ 가격:" + price);
				System.out.println("■■ 수량:" + cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void pdtSearch(String keyword) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("pdtSearch", keyword); // 아무것도 없는 기본 생성자 필요
			if (list.size() > 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println(" 제품번호 \t 제품명 \t 제조사 \t 가격 \t 재고 \t 입고일 \n");

				for (ProductDTO line : list) {
					System.out.println(line.toString());
				}
			} else {

				System.out.println("검색결과가 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void pdtSelect() { // 전체 상품 조회
		sqlSession = sqlSessionFactory.openSession();

		try {

			list = sqlSession.selectList("pdtSelect");

			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println(" 제품번호 \t 제품명 \t 제조사 \t 가격 \t 재고 \t 입고일 \n");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			for (ProductDTO line : list) {
				System.out.println(line.toString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void pdtDelete(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {

			result = sqlSession.delete("pdtDelete", pname);
			if (result > 0) {
				System.out.println(pname + "삭제 완료");
			} else {

				System.out.println("삭제 오류입니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void pdtUpdate(int pno, String pname, String company, int price, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pno", pno);
		map.put("company", company);
		map.put("pname", pname);
		map.put("price", price);
		map.put("cnt", cnt);
		try {
		result = sqlSession.update("pdtUpdate", map);
		 if(result>0) {
			 System.out.println(pno + "제품 을 수정 완료 하였습니다");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ ");
				System.out.println("■■ 회사 :" + company);
				System.out.println("■■ 제품명 :" + pname);
				System.out.println("■■ 가격:" + price);
				System.out.println("■■ 수량:" + cnt);
			 
		 }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
}
