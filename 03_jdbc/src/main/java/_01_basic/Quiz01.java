package _01_basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import board.vo.Board;
import util.DBProperties;

public class Quiz01 {
	/**
	 * Board 클래스는 tb_board 테이블을 기준으로 작성합니다.
	 * 단, tb_board 테이블의 컬럼명의 _ 는 자바클래스 필드에서는 대문자로 변경해서 처리
	 * 필드별 setter, getter 메서드를 만듭니다.
	 * 
	 * selectBoard 메서드는 호출하게 되면 tb_board의 데이터를 읽어서 
	 * List에 담아서 반환합니다.
	 * 
	 * @return
	 */
	private List<Board> selectBoard() throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		List<Board> list = new ArrayList<>();
		try {
			Class.forName(DBProperties.driver);
			con = DriverManager.getConnection(
					DBProperties.url, DBProperties.user, DBProperties.pass
			);
			StringBuffer sql = new StringBuffer();
			sql.append("select title, contents, no, writer, view_cnt, reg_date ");
			sql.append("  from tb_board ");
			sql.append(" order by no desc ");
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());
			
			// ResultSet의 결과를 List에 저장하기....
			while (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setViewCnt(rs.getInt("view_cnt"));
				b.setWriter(rs.getString("writer"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("contents"));
				b.setRegDate(rs.getDate("reg_date"));
				list.add(b);
			}	
		} finally {
			try {
				stmt.close();
			} catch(Exception e) {}
			try {
				con.close();
			} catch(Exception e) {}
		}
		return list;
	}
	public static void main(String[] args) {
		
		/*
		 *  list의 데이터를 아래와 같이 출력하도록 코드 작성
		 *  
		 *  총 4건
		 *  -----------------------------------
		 *  번호      제목      작성자    작성일
		 *  -----------------------------------
		 *   5     a     b     2018-09-01 
		 *   3     a     b     2018-09-01 
		 *   2     a     b     2018-09-01 
		 *   1     a     b     2018-09-01 
		 *  -----------------------------------
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Quiz01 quiz = new Quiz01();
		try {
			List<Board> list = quiz.selectBoard();
			System.out.printf("총 %d건\n", list.size());
			System.out.println("-------------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------------");
			for (Board b : list) {
				System.out.printf(
					"%d\t%s\t%s\t%s\n",
					b.getNo(), b.getTitle(), b.getWriter(), sdf.format(b.getRegDate())
				);
			}
			System.out.println("-------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}











