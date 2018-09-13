package _02_advance;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import util.ConnectionFactory;

public class Test03 {
	public static void main(String[] args) {
		// 객체를 Finally 블럭에서 닫기 위해서 try 밖에서 connection과 statement를 선언.
		Connection con = null;
		Statement stmt = null;
	
		try {
		// Connection은 모듈화된 ConnectionFactory 활용
		con = ConnectionFactory.getConnection();

		Scanner sc = new Scanner(System.in);
		System.out.println("변경할 게시글 번호:");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("제목수정: ");
		String title = sc.nextLine();
		System.out.println("내용수정: ");
		String contents = sc.nextLine();
		
		StringBuffer sql = new StringBuffer();
		sql.append("update tb_board  ");
		sql.append("  set title = '"+title+"', ");
		sql.append("      contents = '"+contents+"' ");
		sql.append(" where no = "+no);
	
		System.out.println("생성된 SQL: "+sql.toString());
		
		stmt = con.createStatement();
		int cnt = stmt.executeUpdate(sql.toString());
		
		System.out.println(cnt+"개 행이 수정되었습니다.");
		sc.close();
		
		} catch (Exception e) {
			System.out.println("Exception occured...");
			e.printStackTrace();
		} finally {
			// exception이 발생하던 끝나던 memory 정리가 필요함.
			// close될 대상: Connection, Statement
			ConnectionFactory.close(con, stmt);
			
		} // try-catch-finally 
	} // main
	
} // end class
