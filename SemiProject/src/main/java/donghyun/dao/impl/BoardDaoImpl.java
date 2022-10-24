package donghyun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import donghyun.dao.face.BoardDao;
import donghyun.dto.Board;

public class BoardDaoImpl implements BoardDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Board> selectBoardByCategory1(Connection conn) {
		
		String sql ="";
		sql += "SELECT * FROM board_info WHERE categoryno=1";
		
		List<Board> noticeBoard = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				
				noticeBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noticeBoard;
	}
	@Override
	public List<Board> selectBoardByCategory2(Connection conn) {
		String sql ="";
		sql += "SELECT * FROM board_info WHERE categoryno=2";
		
		List<Board> freeBoard = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				
				freeBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return freeBoard;
	}
	@Override
	public List<Board> selectBoardByCategory3(Connection conn) {
		String sql ="";
		sql += "SELECT * FROM board_info WHERE categoryno=3";
		
		List<Board> foodBoard = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				
				foodBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return foodBoard;
	}
	@Override
	public List<Board> selectBoardByCategory4(Connection conn) {
		String sql ="";
		sql += "SELECT * FROM board_info WHERE categoryno=4";
		
		List<Board> meetingBoard = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				
				meetingBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return meetingBoard;
	
	}
	@Override
	public List<Board> selectBoardByCategory5(Connection conn) {
		String sql ="";
		sql += "SELECT * FROM board_info WHERE categoryno=5";
		
		List<Board> qnaBoard = new ArrayList<>();
		
		try {
			ps= conn.prepareStatement(sql);
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				
				qnaBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return qnaBoard;
	}
	@Override
	public Board selectBoardByBoardno(Connection conn, Board boardno) {
		
		String sql = "";
		sql += "SELECT * FROM board_info WHERE boardno = ?";
		
		Board board = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno() );
			
			rs= ps.executeQuery();
			
			while(rs.next()) {
				board = new Board();
				
				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

}
