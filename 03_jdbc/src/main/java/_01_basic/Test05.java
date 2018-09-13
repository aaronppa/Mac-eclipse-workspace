package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.DBProperties;

public class Test05 {
	public static void main(String[] args) throws Exception{

		Class.forName(DBProperties.driver);
		Connection con = DriverManager.getConnection(DBProperties.url,DBProperties.user,DBProperties.pass);

		StringBuffer sql = new StringBuffer();
		sql.append("select no, title, content, writer wr, view_cnt, reg_date ");
		sql.append("  from tb_board ");
		sql.append("  order by no desc ");

		//Select 절 실행일 경우 ResultSet executeQuery
		Statement stmt = con.createStatement();
		
		// rs 객체를 얻은 후의 위치는 beforeFirst
		ResultSet rs = stmt.executeQuery(sql.toString());

		/*
		 * rs의 결과가 하나일 경우 
		 * if(rs.next()==true) {
		 *  // 데이터가 있는 경우 
		 * } else {
		 *  // 데이터가 없는 경우 
		 * }
		 */
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		while(rs.next()) {
			// rs 객체를 얻은 후의 위치는 beforeFirst	
			
			//column의 위치를 지정시, column의 sql index 또는 column_name이 가능하나 column_name을 권장 
			//column 위치를 index로 사용할경우, select문의 순서에 따름 
			// int no = rs.getInt(1); // 비추천   
			int no = rs.getInt("no");  
			int viewCnt = rs.getInt("view_cnt");
			String writer = rs.getString("wr"); // column_name에 alias가 있을 때는 alias를 사용해라.
			// 제목, 내용 가져오기 
			String title = rs.getString("title");
			String content = rs.getString("content");
			Date regDate = rs.getDate("reg_date");
			
			// 출력결과에 등록일 부분 추가하기
			// 2018-11-11 format으로 출력함 (SimpleDateFormat 활용)
			System.out.printf(
					"%d\t%s\t%s\t%s\t%s%d\n",
					no, title, writer, content, sdf.format(regDate), viewCnt
			);
			
		} // while

	} // main

} // end class
