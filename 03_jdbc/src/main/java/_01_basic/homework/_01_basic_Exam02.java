package _01_basic.homework;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_basic_Exam02 {

	public static void printDept() {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			System.out.println("부서명:");
			Scanner sc = new Scanner(System.in);
			String deptId = sc.nextLine();

			StringBuffer sql = new StringBuffer();
			sql.append("select department_name,\n" + 
					"	   manager_id\n"+
					"      from departments ");
			sql.append("where department_id = "+deptId);

			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()==true) {
				String deptName = rs.getString("department_name");
				int mgrId = rs.getInt("manager_id");
				System.out.println("입력하신 부서아이디("+deptId+") 에 해당하는");
				System.out.println("부서명:: "+deptName);
				System.out.println("부서장 아이디:: "+mgrId);
			} else {
				System.out.println("입력하신 부서아이디("+deptId+")에 해당하는 부서명은 없습니다.");
			}

		} catch (Exception e){
			;;
		}	
		finally {

			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	} // printDept

	public static void main(String[] args) {
		printDept();
	}
	
} // end class

/* SQL

select department_name,
	   manager_id
  from departments
  where department_id = "deptId"


 */