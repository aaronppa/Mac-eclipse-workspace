package _02_advance;

import util.SQLExecutor;

public class Test05 {
	public static void main(String[] args) {
		try {
		
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board  ");
			sql.append("  set title = ?, ");
			sql.append("      contents = ? ");
			sql.append(" where no = ? ");
		
			int cnt = SQLExecutor.executeUpdate(
					sql.toString(), 
					"공용처리활용","작업 성공되길..", 6
					);
			System.out.println(cnt+"개의 행이 수정되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
} // end class
