package util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SQLExecutor {
	public static int executeUpdate(String sql, Object...args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			stmt = con.prepareStatement(sql);
			int index = 1;
			for(Object arg : args) {
			stmt.setObject(index++, arg);
			}
			
			return stmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//ConnectionPool과 ConnectionFactory를 활용
			ConnectionFactory.close(stmt);
			ConnectionPool.releaseConnection(con);
		} // try-catch-finally 
		return 0;
	}
	
} // end class
