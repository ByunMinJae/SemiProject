package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dao.face.BoardDao;
import changmin.dto.Category;
import common.JDBCTemplate;
import daun.dto.Board;
import sharon.dto.User;
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
	public int selectCntAll(Connection conn, Category category) {
		
		String sql = "";
		sql += "SELECT count(*) cnt";
		sql += "	FROM board_info";
		sql += "	WHERE categoryno = ?";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, category.getCategoryno());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장

			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("selectCntAll : " + count);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return count;
	}
	
	@Override
	public List<Board> selectAll(Connection conn, Paging paging, Category category) {
		System.out.println("selectAll - start");
		
		//SQL 작성
	      String sql = "";
	      sql += "SELECT * FROM ("; 
	      sql += "   SELECT rownum rnum, B.* FROM (";
	      sql += "      SELECT";
	      sql += "         boardno, boardtitle, boarddate, userno, categoryno, hit, nick";
	      sql += "       FROM board_info";
	      sql += "       WHERE categoryno=?";
	      sql += "       ORDER BY boardno DESC";
	      sql += "    ) B";
	      sql += " ) BOARD";
	      sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Board> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, category.getCategoryno());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Board b = new Board();
				
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				b.setHit(rs.getInt("hit"));
				b.setNick(rs.getString("nick"));
				
				list.add(b);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			System.out.println("카테고리넘버 : " + category.getCategoryno());
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
		sql += "	boardno, boardtitle, boarddate, boardcon, userno, categoryno, hit, nick";
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
				board.setBoardcon(rs.getString("boardcon"));
				board.setUserno(rs.getInt("userno"));
				board.setCategoryno(rs.getInt("categoryno"));
				board.setHit(rs.getInt("hit"));
				board.setNick(rs.getString("nick"));
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return board;
	}

	@Override
	public int delete(Connection conn, Board board) {

		String sql = "";
		sql += "DELETE FROM board_info";
		sql += "	WHERE boardno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public Category selectCatename(Connection conn, int i) {
		System.out.println("selectCatename - Start");
		String sql ="";
		sql += "SELECT categoryname";
		sql += "	FROM board_category";
		sql += "	WHERE categoryno=?";
		
		Category category = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			rs = ps.executeQuery();

			category = new Category();
			
			while(rs.next()) {
				category.setCategoryname(rs.getString("categoryname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(ps);
		}
		
		
		return category;
	}


	@Override
	public User getNick(Connection conn, Board bUserno) {
		String sql = "";
		sql+="SELECT nick";
		sql+="	FROM user_info";
		sql+="	WHERE userno";
		sql+="	IN (SELECT userno FROM board_info WHERE userno=?)";

		User user = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bUserno.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User();
				
				user.setUserno(rs.getInt("nick"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return user;
	}

	@Override
	public Board boardUserno(Connection conn) {

		String sql="";
		sql+="SELECT userno";
		sql+="	FROM board_info";
		sql+="	WHERE boardno=?";
		
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return null;
	}
	


}
