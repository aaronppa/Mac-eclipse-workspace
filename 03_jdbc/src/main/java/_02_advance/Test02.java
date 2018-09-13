/*
 * Transaction(트렌잭션) 
 * 	- commit, rollbkack, savepoint
 *  - 논리적으로 DML 문장들을 묶는 단위
 * 	- 전부 다 처리되거나 전부다 처리되지 않아야 한다. (all or nothing) 
 * 	- commit : 데이터베이스에 완전하게 적용 
 *  - rollback : 되돌린다. (이전 Commit으로 되돌리다.)
 *  - DDL 명령어는 자동 커밋이 발생한다. (툴에 따라서 자동 커밋인 툴이 있음...)
 *  - JDBC 프로그램은 기본 auto commit 상태이다.
 *  - 
 *  
 *  
 */

package _02_advance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBProperties;

public class Test02 {
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(DBProperties.driver);
			con = DriverManager.getConnection(
					DBProperties.url,
					DBProperties.user,
					DBProperties.pass
					);
			
			// 자동 커밋 해제 
			con.setAutoCommit(false);
			
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_account ");
			sql.append("  set money = money - 50000 ");
			sql.append("  where user_id = 'won' ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.executeUpdate();
			
			System.out.println("won 사용자의 계좌 업데이트 완료.");
			
			sql.delete(0, sql.length());
			
			sql.append("update tb_account ");
			sql.append("  set money = money + 50000 ");
			sql.append("  where user_id = 'kim' ");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.executeUpdate();
			
			System.out.println("kim 사용자의 계좌 업데이트 완료.");
			
			// 정상적으로 수행시 커밋
			con.commit();
			
		} catch (Exception e) {
			try {
				con.rollback();
			} catch(SQLException e1) {
			e.printStackTrace();
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {;;}
			try {
				con.close();
			} catch (Exception e) {;;}
		} // try-catch-finally 
		
	} // main
	
} // end class
