/*
 *  DAO : Data Access Object
 *  
 *  데이터에 대한 처리 클래스
 *  
 *  4가지 작업을 처리한다.
 *  
 *  기능(메서드) 이름 규칙 정하기
 *  등록  insert~ 
 *  수정  update~ 
 *  삭제  delete~ 
 *  조회  select~ 
 */
package _02_advance.board_example.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.vo.Board;
import util.ConnectionFactory;
import util.ConnectionPool;
import util.SQLExecutor;

public class BoardDAO {
	public List<Board> selectBoard() {
		List<Board> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_board ");
			sql.append(" order by no desc ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setWriter(rs.getString("writer"));
				b.setTitle(rs.getString("title"));
				b.setRegDate(rs.getTimestamp("reg_date"));
				b.setViewCnt(rs.getInt("view_cnt"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	public Board selectBoardByNo(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_board ");
			sql.append(" where no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setWriter(rs.getString("writer"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setRegDate(rs.getTimestamp("reg_date"));
				b.setViewCnt(rs.getInt("view_cnt"));
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	public void insertBoard(Board board) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb_board( ");
			sql.append("	no, title, writer, content ");
			sql.append(") values ( ");
			sql.append("	s_board_no.nextval, ?, ?, ? ");
			sql.append(")  ");
			SQLExecutor.executeUpdate(
					sql.toString(),
					board.getTitle(), board.getWriter(), board.getContent()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int updateBoard(Board board) {
		int cnt = 0;
		try {
			cnt = SQLExecutor.executeUpdate(
					"update tb_board set title = ?, content = ?  where no = ? ", 
					board.getTitle(), board.getContent(), board.getNo()
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public int deleteBoard(int no) {
		int cnt = 0;
		try {
			cnt = SQLExecutor.executeUpdate("delete tb_board  where no = ? ", no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	public void updateBoardViewCnt(int no) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board ");
			sql.append("   set view_cnt = view_cnt + 1 ");
			sql.append(" where no = ? ");
			SQLExecutor.executeUpdate(sql.toString(), no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}