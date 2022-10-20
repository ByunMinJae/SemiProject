package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import changmin.dao.face.BoardDao;
import common.JDBCTemplate;

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

}
