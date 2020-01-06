package problem.market;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class SaleDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	
	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
		// 1. 판매 테이블 판매이력을 insert
		// 2. 상품테이블 판매수량만큼 해당 제품에 제고를 UPDATE 
		// 1, 2 두가지 조건을 만족해야 되기 때문에 return으로 진행 
	}
	//일일 판매량 출력하는 함수 
	
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession();
		int cnt = 0;
		int price = 0;
		try {
			list = sqlSession.selectList("sale.dashBoard");
			
			int i = 0; 
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 제품번호 \t 제품명 \t 제조사 \t 가격 \t 재고 \t 입고일자 ▒▒");
			System.out.println("▒▒==================================================================================");
			for (SaleDTO line : list) {
				System.out.print("▒▒ "+(i+1)+"\t" );
				System.out.println(list.get(i).getSname() + "\t");
				System.out.println(list.get(i).getCnt() + "\t");
				System.out.println(list.get(i).getTprice() + "\t");
				System.out.println();
				 cnt = line.getCnt();
				 price = line.getTprice();
			
			}
			System.out.println("▒▒==================================================================================");
			System.out.println("▒▒ 제품은 총 "+list.size()+"개 입니다.");
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	

}
