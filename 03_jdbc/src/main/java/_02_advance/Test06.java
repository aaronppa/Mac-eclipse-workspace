/*
	ResultSetMetaData
	
	select *
		from??;
		
 	rs.getInt(..)/
 	rs.getString(..);
 
 */
package _02_advance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test06 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			String tbName = "departments";
			
			
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from " + tbName); // select 절에서는 ?가 들어갈 수 없다. 
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			// 사용자가 tbName에 입력한 테이블의 컬럼을 ResultSetMetaData를 통해서 가져온다. 
			ResultSetMetaData rsmd = rs.getMetaData(); // select *가 무엇인지 모르기 때문에 정보를 가지고 오기 위해 사용. 
			
			// 조회된 컬럼의 수 
			int count = rsmd.getColumnCount();
			System.out.println("조회된 컬럼의 수: "+ count);
			
			for(int i =1; i<=count; i++) {
				String columnName = rsmd.getColumnName(i);
				System.out.print(columnName + "\t");
			} // for
			
			System.out.println();
			
			// 데이터 출력하기
			while(rs.next()) {
				for(int i =1; i<=count; i++) {
					String columnName = rsmd.getColumnName(i);
					System.out.print(rs.getObject(columnName) + "\t");
				}
				System.out.println();
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(stmt);
			ConnectionPool.releaseConnection(con);
		} // try-catch-finally
		
	}// main
	
} // end class
