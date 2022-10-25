package daun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dto.Category;
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
	public User getUserInfo(Connection conn, int userno) {
		
		String sql = "";
		
		sql+="SELECT";
		sql+="	userno, userid ";
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
	public String selectNickByBoard(Connection conn, Board viewBoard) {
		
		String sql = "";
		sql += "SELECT nick FROM userinfo";
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
	public int insert(Connection conn, Board board) {

		String sql = "";
		sql += "INSERT INTO board ( boardno, boardtitle, boardcon, boarddate, userno, categoryno, hit, nick )";
		sql += " VALUES ( ?, ?, ?, sysdate, ?, ?, 0, ? )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, board.getBoardno());
			ps.setString(2, board.getBoardtitle());
			ps.setString(3, board.getBoardcon());
			ps.setInt(4, board.getUserno());
			ps.setInt(5, board.getCategoryno());
			ps.setString(6, board.getNick());
			
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
		sql += "SELECT board_seq.nextval FROM dual";
		
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
		sql += "INSERT INTO boardfile( fileno, boardno, originname, storedname, filesize )";
		sql += " VALUES( boardfile_seq.nextval, ?, ?, ?, ? )";
		
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
		sql += "	fileno, boardno, originname, storedname, filesize, boarddate";
		sql += " FROM boardfile";
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
		sql += "UPDATE board ";
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
		sql += "DELETE boardfile ";
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
	public int report(Connection conn, Report report) {
		
		String sql = "";
		sql += "INSERT INTO boardreport( reportno, reportcon, reportdate, userno, boardno )";
		sql += " VALUES( boardreport_seq.nextval, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, report.getReportcon());
			ps.setDate(2, report.getReportdate());
			ps.setInt(3, report.getUserno());
			ps.setInt(4, report.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	
//	@Override
//	public int getCategoty(Connection conn, Category categoryno) {
//		
//		String sql = "";
//		sql += "SELECT";
//		sql += "	categoryno, categoryname ";
//		sql += " FROM boardcategory";
//		sql += " WHERE categoryno = ? ";
//		
//		//조회 결과 객체
//		Category category = new Category();
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, categoryno.getCategoryno());
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next() ) {
//				category = new Category();
//				
//				category.setCategoryno( rs.getInt("categoryno") );
//				category.setCategoryname( rs.getString("categoryname") );
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return category;
//	}
//	
}




