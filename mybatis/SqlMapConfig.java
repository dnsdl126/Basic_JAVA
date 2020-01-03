package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	
	//Builder를 통해 Factory를 하나 만들어주는 역할 
	private static SqlSessionFactory sqlSessionFactory;
	
	static { // 정적 블럭 
		     // 클래스 로딩시 1회만 실행되는 코드 
		
		String resource = "mybatis/Configuration.xml";// 변수 값을 넣기만 함 
		
		try {
			
			Reader reader = Resources.getResourceAsReader(resource);
			               // resource가 있는 경로로 가서 파일을 한줄씩 읽고 reader에 담는다 
						   // reader 안에는 Configration.xml이 담겨 있음  
					
					if(sqlSessionFactory == null) {
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
						// 빌드패턴 
						// 복잡한 패턴의 객체를 생성해야 하다 보니 대신 생성해달라고 맡김 
						//reader(Configration.xml)에담긴 값을로 sqlSessionFactory를 만들어라 
					}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getSqlSession() {
		return sqlSessionFactory;
		 // 공장하나를 보낸다 
	}
}

