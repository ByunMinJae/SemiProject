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
import daun.dto.BoardFile;
import daun.dto.Report;
import daun.util.Paging;
import sharon.dto.User;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체
	
	@Override
	public List<Board> selectAll(Connection conn) {
		System.out.println("BoardDao selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, boardtitle, boardcon, boarddate, userno";
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
		sql += "			boardno, boardtitle, boardcon, boarddate, userno";
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
		sql += "	boardno, boardtitle, boardcon, boarddate, userno, ";
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
	public String selectNickByBoard(Connection conn, Board viewBoard) {
		
		String sql = "";
		sql += "SELECT nick FROM user_info";
		sql += " WHERE userno = ?";
		
		//결과 저장할 변수
		String nick = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewBoard.getUserno());

			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nick = rs.getString("nick");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nick;
	}

	@Override
	public int insert(Connection conn, Board board, int userno) {

		String sql = "";
		sql += "INSERT INTO board_info ( boardno, boardtitle, boardcon, boarddate, userno, categoryno, hit )";
		sql += " VALUES ( ?, ?, ?, sysdate, ?, ?, 0 )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getBoardno());
			ps.setString(2, board.getBoardtitle());
			ps.setString(3, board.getBoardcon());
			ps.setInt(4, userno);
			ps.setInt(5, board.getCategoryno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int selectNextBoardno(Connection conn) {
		
		String sql = "";
		sql += "SELECT board_info_seq.nextval FROM dual";
		
		int nextBoardno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextBoardno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextBoardno;
	}
	
	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {
		
		String sql = "";
		sql += "INSERT INTO board_file( fileno, boardno, fileoriginname, filestoredname, filesize, boarddate )";
		sql += " VALUES( board_file_seq.nextval, ?, ?, ?, ?, sysdate )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardFile.getBoardno());
			ps.setString(2, boardFile.getOriginname());
			ps.setString(3, boardFile.getStoredname());
			ps.setInt(4, boardFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
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
				boardFile.setOriginname( rs.getString("originname") );
				boardFile.setStoredname( rs.getString("storedname") );
				boardFile.setFilesize( rs.getInt("filesize") );
				boardFile.setBoarddate( rs.getDate("boarddate") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return boardFile;
	}

	@Override
	public int update(Connection conn, Board board) {

		String sql = "";
		sql += "UPDATE board_info ";
		sql += " SET";
		sql += "	boardtitle = ?";
		sql += "	, boardcon = ?";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, board.getBoardtitle());
			ps.setString(2, board.getBoardcon());
			ps.setInt(3, board.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;

	}
	
	@Override
	public int deleteFile(Connection conn, Board board) {
		
		String sql = "";
		sql += "DELETE board_file ";
		sql += " WHERE boardno = ?";
		
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
	public User getUserInfo(Connection conn, int userno) {
		
		String sql = "";
		
		sql+="SELECT";
		sql+="	userno, userid, nick ";
		sql+="	FROM user_info";
		sql+="	WHERE userno=?";

		User user = new User();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			 
			rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				
				user.setUserno( rs.getInt("userno"));
				user.setUserid( rs.getString("userid"));
				user.setNick( rs.getString("nick"));
				
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
	public int report(Connection conn, Report report) {
		
		String sql = "";
		sql += "INSERT INTO board_report( reportno, reportcon, reportdate, userno, boardno )";
		sql += " VALUES( ?, ?, sysdate, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, report.getReportno());
			ps.setString(2, report.getReportcon());
			ps.setDate(3, report.getReportdate());
			ps.setInt(4, report.getUserno());
			ps.setInt(5, report.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	@Override
	public int selectNextreportno(Connection conn) {
		
		String sql = "";
		sql += "SELECT board_report_seq.nextval FROM dual";
		
		int nextReportno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextReportno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextReportno;
	}
	
	
	@Override
	public User UserInfo(Connection conn, int userno) {
		
		String sql = "";
		
		sql+="SELECT";
		sql+="	userno, nick";
		sql+="	FROM user_info";
		sql+="	WHERE userno=?";

		User nick = null;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			 
			rs = ps.executeQuery();
			
			
			while( rs.next() ) {
			
				nick = new User();
				
				nick.setUserno( rs.getInt("userno"));
				nick.setUserid( rs.getString("nick"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nick;
	}

}




