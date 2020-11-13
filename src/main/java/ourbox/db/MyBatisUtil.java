package ourbox.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	
	private static SqlSessionFactory sqlSessionFactory; 
	//static블럭을 통해 클래스가 로딩이 될 때 mybatis환경을 구성한다
	//=> 목적 : sqlSessionFactory 객체를 생성
	
	
	static {
		String resource = "kr/or/ddit/db/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//sqlSessionFactory객체를 통해 sqlSession객체를 얻어내는 메소드
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
