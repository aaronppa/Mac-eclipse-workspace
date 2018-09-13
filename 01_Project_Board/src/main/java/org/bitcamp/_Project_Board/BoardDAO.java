package org.bitcamp._Project_Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
			
			while(rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setRegDate(rs.getDate("reg_date"));
				b.setViewCnt(rs.getInt("view_cnt"));
				list.add(b);
			} // while
			
			
		} catch (Exception e) {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}

		return list;
	} // selectBoard
	
	public Board selectBoardbyNo(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("  from tb_board");
			sql.append(" where no = ?");
			
			pstmt = con.prepareStatement(sql.toString());							
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Board b = new Board();
				b.setNo(rs.getInt("no"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setContent(rs.getString("content"));
				b.setRegDate(rs.getDate("reg_date"));
				b.setViewCnt(rs.getInt("view_cnt"));
				return b;
			} else { 
				
			}
			
		} catch (Exception e) {
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	} // selectBoardbyNo
	
	public void insertBoard(Board board) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb_board(");
			sql.append("	no, writer, title, content) ");
			sql.append("	values(");
			sql.append("	s_board_no.nextval, ?, ? ,?");
			sql.append(") ");
			
			SQLExecutor.executeUpdate(
					sql.toString(), 
					board.getWriter(), board.getTitle(), board.getContent()
					);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	} // insertBoard

	public void updateBoard(Board board) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board ");
			sql.append(" set title = ? ,");
			sql.append("     content = ? ");
			sql.append(" where no = ? ");
						
			SQLExecutor.executeUpdate(
					sql.toString(), 
					board.getTitle(), board.getContent(), board.getNo()
					);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	} // updateBoard

	public int deleteBoard(int no) {
		int cnt = 0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("delete tb_board ");
			sql.append(" where no = ? ");
						
			SQLExecutor.executeUpdate(
					sql.toString(), 
					no
					);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cnt;
	} // deleteBoard

	public int viewCount(int no) {
		int cnt = 0;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update tb_board ");
			sql.append("  set view_cnt = view_cnt+1 ");
			sql.append(" where no = ? ");
						
			SQLExecutor.executeUpdate(
					sql.toString(), 
					no
					);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	} // viewCount
	
} // end class
