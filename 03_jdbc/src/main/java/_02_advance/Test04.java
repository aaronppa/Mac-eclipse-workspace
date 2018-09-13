package _02_advance;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.ConnectionFactory;
import util.ConnectionPool;

public class Test04 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board  ");
			sql.append("  set title = ?, ");
			sql.append("      contents = ? ");
			sql.append(" where no = ? ");
		
			System.out.println("생성된 SQL: "+sql.toString());
			
			stmt = con.prepareStatement(sql.toString());
			int index = 1;
//			stmt.setString(index++, "a");
//			stmt.setString(index++, "b");
//			stmt.setInt(index++, 2);
			
			// stmt.set할 객체 타입을 모를때는 Object 타입으로 통용가능 
			stmt.setObject(index++, "a");
			stmt.setObject(index++, "b");
			stmt.setObject(index++, 6);
			
			int cnt = stmt.executeUpdate();
			
			System.out.println(cnt+"개 행이 수정되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//ConnectionPool과 ConnectionFactory를 활용
			ConnectionFactory.close(stmt);
			ConnectionPool.releaseConnection(con);
		} // try-catch-finally 
	}
	
} // end class
