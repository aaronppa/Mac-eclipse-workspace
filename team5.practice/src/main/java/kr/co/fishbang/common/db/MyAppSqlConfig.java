package kr.co.fishbang.common.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static final SqlSession sqlMapper;	//private로 되어있기때문에  static method로 접근하자! 
	
	
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";  //전체환경설정 경로 
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory =
					new SqlSessionFactoryBuilder().build(reader);//전체환경설정파일로 session을 얻어오자!! 
			sqlMapper = sqlFactory.openSession(true);
			// = openSession(false):사용자가 커밋해야 함!!! openSession(True) :Auto-commit!!
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}//static end 

	//SqlSession session=MyAppSqlConfig.getSqlSessionInstance() 방식으로 호출!! 
	public static SqlSession getSqlSessionInstance() {
		return sqlMapper;
	}//method end 
	
	
	
	
}