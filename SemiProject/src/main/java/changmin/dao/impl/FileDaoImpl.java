package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dao.face.FileDao;
import changmin.dto.Board;
import common.JDBCTemplate;
import daun.dto.BoardFile;

public class FileDaoImpl implements FileDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<BoardFile> selectAll(Connection conn, Board boardno) {
		
		String sql = "";
		sql +="SELECT fileno, fileoriginname, filestoredname";
		sql +=" FROM board_file";
		sql +=" WHERE boardno = ?";
		sql +=" ORDER BY fileno DESC";
		
		List<BoardFile> list = new ArrayList<>();
			
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardno.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				BoardFile boardFile = new BoardFile();
				
				boardFile.setFileno( rs.getInt("fileno"));
				boardFile.setOriginname( rs.getString("fileoriginname"));
				boardFile.setStoredname( rs.getString("filestoredname"));
				
				list.add(boardFile);
				
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
	public BoardFile selectFile(Connection conn, Board viewBoard) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	fileno, boardno, fileoriginname, filestoredname, filesize, boarddate";
		sql += " FROM board_file";
		sql += " WHERE boardno = ?";
		
		//조회 결과 객체
		BoardFile boardFile = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewBoard.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				boardFile = new BoardFile();
				
				boardFile.setFileno( rs.getInt("fileno") );
				boardFile.setBoardno( rs.getInt("boardno") );
				boardFile.setOriginname( rs.getString("fileoriginname") );
				boardFile.setStoredname( rs.getString("filestoredname") );
				boardFile.setFilesize( rs.getInt("filesize") );
				boardFile.setBoarddate( rs.getDate("boarddate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return boardFile;
	}

}
