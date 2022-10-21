package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dao.face.BoardDao;
import common.JDBCTemplate;
import daun.dto.Board;
import util.Paging;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Board> selectAll(Connection conn) {
		System.out.println("selectAll - start");
		
		String sql="";
		sql+="SELECT";
		sql+="	boardno, boardtitle, boardcon, boarddate, userno, categoryno, hit";
		sql+="	FROM";
		sql+=" 	board_info";
		sql+="	ORDER BY boardno DESC";
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoardcon(rs.getString("boardcon"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				b.setHit(rs.getInt("hit"));
				
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return boardList;
	}
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return count;
	}
	
	@Override
	public List<Board> selectAll(Connection conn, Paging paging) {
		System.out.println("selectAll - start");
		
		//SQL 작성
	      String sql = "";
	      sql += "SELECT * FROM ("; 
	      sql += "   SELECT rownum rnum, B.* FROM (";
	      sql += "      SELECT";
	      sql += "         boardno, boardtitle, boarddate, userno, categoryno, hit";
	      sql += "       FROM board_info";
	      sql += "       ORDER BY boardno DESC";
	      sql += "    ) B";
	      sql += " ) BOARD";
	      sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Board> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board b = new Board();
				
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				b.setHit(rs.getInt("hit"));
				
				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}

	@Override
	public int updateHit(Connection conn, Board boardno) {
		
		String sql = "";
		sql += "UPDATE board_info";
		sql += "	SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}


	@Override
	public Board selectBoardByBoardno(Connection conn, Board boardno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boarddate, userno, categoryno, hit";
		sql += " FROM board_info";
		sql += " WHERE boardno = ?";
		
		Board board = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				board= new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				board.setHit(rs.getInt("hit"));
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return board;
	}
	


}
