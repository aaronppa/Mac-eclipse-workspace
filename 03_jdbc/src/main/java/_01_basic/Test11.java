package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import util.DBProperties;

public class Test11 {
	public static void main(String[] args) {
		// 객체를 Finally 블럭에서 닫기 위해서 try 밖에서 connection과 statement를 선언.
		Connection con = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
	
		try {
			Class.forName(DBProperties.driver);
		
		con = DriverManager.getConnection(
				DBProperties.url,
				DBProperties.user,
				DBProperties.pass 
				);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 게시글 번호:");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("제목수정: ");
		String title = sc.nextLine();
		System.out.println("내용수정: ");
		String content = sc.nextLine();
		
		StringBuffer sql = new StringBuffer();
//		sql.append("update tb_board  ");
//		sql.append("  set title = '"+title+"', ");
//		sql.append("      content = '"+content+"' ");
//		sql.append(" where no = "+no);
		sql.append("update tb_board  ");
		sql.append("  set title = ?, ");
		sql.append("      content = ? ");
		sql.append(" where no = ?");
	
		System.out.println("생성된 SQL: "+sql.toString());
		
//		stmt = con.createStatement();
		pstmt = con.prepareStatement(sql.toString());
		
		int index = 1;
	
		pstmt.setObject(index++, title);
		pstmt.setObject(index++, content);
		pstmt.setObject(index++, no);
		
		
//		int cnt = stmt.executeUpdate(sql.toString());
		int cnt = pstmt.executeUpdate();
		
		System.out.println(cnt+"개 행이 수정되었습니다.");
		sc.close();
		
		} catch (Exception e) {
			System.out.println("Exception occured...");
			e.printStackTrace();
		} finally {
			// exception이 발생하던 끝나던 memory 정리가 필요함.
			// close될 대상: Connection, Statement
			try {
//				stmt.close();
				pstmt.close();
			} catch (Exception e) {
				;;
			}
			try {
				con.close();
			} catch (Exception e) {
				;;
			} 
		} // try-catch-finally 
	} // main
	
} // end class
