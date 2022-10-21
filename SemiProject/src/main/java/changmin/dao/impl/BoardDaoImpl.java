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
	public int selectCntAll(Connection conn) {
		System.out.println("selectCntAll - Start");
		String sql="";
		
		sql += "SELECT count(*) cnt FROM board_info";
		
		//총 게시글 수
		int count=0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("selectCntAll - End");
		return count;
	}
	@Override
	public List<Board> selectAll(Connection conn, Paging paging) {
		System.out.println("selectAll - Start");
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			boardno, boardtitle, boardcon, boarddate, userno, categoryno";
		sql += " 		FROM board_info";
		sql += " 		ORDER BY boardno DESC";
		sql += "	) B";
		sql += " ) Board";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Board> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Board b = new Board();
				
				b.setBoardno(rs.getInt("boardno"));
				b.setBoardtitle(rs.getString("boardtitle"));
				b.setBoardcon(rs.getString("boardcon"));
				b.setBoarddate(rs.getDate("boarddate"));
				b.setUserno(rs.getInt("userno"));
				b.setCategoryno(rs.getInt("categoryno"));
				//b.setHit 추가예정
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		
		
		System.out.println("selectAll - End");
		return boardList;
	}

}
