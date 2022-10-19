package daun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import daun.dao.face.BoardDao;
import daun.dto.Board;
import daun.util.Paging;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Board> selectAll(Connection conn) {
		System.out.println("BoardDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcon, boarddate, userno, categoryno";
		sql += " FROM board_info";
		sql += " ORDER BY boardno DESC";
		
		//결과 저장할 List
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Board b = new Board(); //조회 결과 행 저장 DTO객체
				
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoardcon(rs.getString("boardcon"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				
				//리스트에 결과값 저장하기
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("BoardDao selectAll() - 끝");
		return boardList; //최종 결과 반환
	}
	
	@Override
	public List<Board> selectAll(Connection conn, Paging paging) {
		System.out.println("BoardDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			boardno, boardtitle, boardcon, boarddate, userno, categoryno";
		sql += "		FROM board_info";
		sql += "		ORDER BY boardno DESC";
		sql += "	) B";
		sql += " ) BOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//결과 저장할 List
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Board b = new Board(); //조회 결과 행 저장 DTO객체
				
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoardcon(rs.getString("boardcon"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				
				//리스트에 결과값 저장하기
				boardList.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("BoardDao selectAll() - 끝");
		return boardList; //최종 결과 반환
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
		sql += "	boardno, boardtitle, boardcon, boarddate, userno, categoryno";
		sql += " FROM board_info";
		sql += " WHERE boardno = ?";
		
		Board board = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
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
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return board;
	}
	
}




