package common.db;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyAppSqlConfig {
	private static final SqlSession sqlMapper;
	static {
		try {
			String resource = "config/mybatis/sqlMapConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
//			sqlMapper = sqlFactory.openSession(); // default로 false 값인데 이는 사용자가 직접 커밋 해야 함.
			sqlMapper = sqlFactory.openSession(true); // parameter value가 true이면 자동 커밋
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}

	// SqlSession session = MyAppSqlConfig.getSqlSessionInstance();
	public static SqlSession getSqlSessionInstance() {
		return sqlMapper;
	}
}