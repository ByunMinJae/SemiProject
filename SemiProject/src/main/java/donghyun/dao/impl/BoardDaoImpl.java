package donghyun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import donghyun.dao.face.BoardDao;
import donghyun.dto.Board;
import donghyun.dto.BoardFile;
import donghyun.dto.Report;
import util.Paging;

public class BoardDaoImpl implements BoardDao {

	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Board> selectBoardByCategory1(Connection conn , Paging paging) {

		String sql ="";
		sql += "SELECT * FROM(";
		sql += "	    SELECT rownum rnum, B.* FROM(";
		sql += "	            SELECT";
		sql += "	                boardno, boardtitle, boarddate, userno";
		sql += "	                FROM board_info";
		sql += "	                WHERE categoryno = 1";
		sql += "	                ORDER BY boardno DESC";
		sql += "	                )B";
		sql += "	                )BOARD";
		sql += "                WHERE rnum BETWEEN ? AND ?";

		List<Board> noticeBoard = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs= ps.executeQuery();

			while(rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				//board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));

				noticeBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return noticeBoard;
	}
	@Override
	public List<Board> selectBoardByCategory2(Connection conn, Paging paging) {
		String sql ="";
		sql += "SELECT * FROM(";
		sql += "	    SELECT rownum rnum, B.* FROM(";
		sql += "	            SELECT";
		sql += "	                boardno, boardtitle, boarddate, userno";
		sql += "	                FROM board_info";
		sql += "	                WHERE categoryno = 2";
		sql += "	                ORDER BY boardno DESC";
		sql += "	                )B";
		sql += "	                )BOARD";
		sql += "                WHERE rnum BETWEEN ? AND ?";

		List<Board> freeBoard = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());

			rs= ps.executeQuery();

			while(rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				//board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));

				freeBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		return freeBoard;
	}
	@Override
	public List<Board> selectBoardByCategory3(Connection conn, Paging paging) {
		String sql ="";
		sql += "SELECT * FROM(";
		sql += "	    SELECT rownum rnum, B.* FROM(";
		sql += "	            SELECT";
		sql += "	                boardno, boardtitle, boarddate, userno ";
		sql += "	                FROM board_info";
		sql += "	                WHERE categoryno = 3";
		sql += "	                ORDER BY boardno DESC";
		sql += "	                )B";
		sql += "	                )BOARD";
		sql += "                WHERE rnum BETWEEN ? AND ?";

		List<Board> foodBoard = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs= ps.executeQuery();

			while(rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				//board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));

				foodBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		return foodBoard;
	}
	@Override
	public List<Board> selectBoardByCategory4(Connection conn, Paging paging) {
		String sql ="";
		sql += "SELECT * FROM(";
		sql += "	    SELECT rownum rnum, B.* FROM(";
		sql += "	            SELECT";
		sql += "	                boardno, boardtitle, boarddate, userno";
		sql += "	                FROM board_info";
		sql += "	                WHERE categoryno = 4";
		sql += "	                ORDER BY boardno DESC";
		sql += "	                )B";
		sql += "	                )BOARD";
		sql += "                WHERE rnum BETWEEN ? AND ?";

		List<Board> meetingBoard = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs= ps.executeQuery();

			while(rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				//board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));

				meetingBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		return meetingBoard;

	}
	@Override
	public List<Board> selectBoardByCategory5(Connection conn, Paging paging) {
		String sql ="";
		sql += "SELECT * FROM(";
		sql += "	    SELECT rownum rnum, B.* FROM(";
		sql += "	            SELECT";
		sql += "	                boardno, boardtitle, boarddate, userno";
		sql += "	                FROM board_info";
		sql += "	                WHERE categoryno = 5";
		sql += "	                ORDER BY boardno DESC";
		sql += "	                )B";
		sql += "	                )BOARD";
		sql += "                WHERE rnum BETWEEN ? AND ?";
		List<Board> qnaBoard = new ArrayList<>();

		try {
			ps= conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs= ps.executeQuery();

			while(rs.next()) {
				Board board = new Board();

				board.setBoardno(rs.getInt("boardno"));
				board.setBoardtitle(rs.getString("boardtitle"));
				//board.setBoardcon(rs.getString("boardcon"));
				board.setBoarddate(rs.getDate("boarddate"));
				board.setUserno(rs.getInt("userno"));
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));

				qnaBoard.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}


		return qnaBoard;
	}
	@Override
	public List<Report> selectReportBoard(Connection conn, Paging paging) {
		String sql ="";
//		sql += "SELECT * FROM(";
//		sql += "	    SELECT rownum rnum, B.* FROM(";
//		sql += "	            SELECT";
//		sql += "	                reportno, reportcon, reportdate, userno, boardno ";
//		sql += "	                FROM board_report";
//		sql += "	                ORDER BY reportno DESC";
//		sql += "	                )B";
//		sql += "	                )BOARD";
//		sql += "                WHERE rnum BETWEEN ? AND ?";
		
		sql = "SELECT reportno, reportcon, reportdate, userno, boardno FROM board_report";
		
		List<Report> reportBoard = new ArrayList<>();
		
		try {
			
			ps=conn.prepareStatement(sql);
			
			//ps.setInt(1, paging.getStartNo());
			//ps.setInt(2, paging.getEndNo());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Report report = new Report();
				
				report.setReportno(rs.getInt("reportno"));
				report.setReportcon(rs.getString("reportcon"));
				report.setReportdate(rs.getDate("reportdate"));
				report.setUserno(rs.getInt("userno"));
				report.setBoardno(rs.getInt("boardno"));
				
				reportBoard.add(report);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reportBoard;
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
				//board.setCategoryno(rs.getInt("categoryno"));
				//board.setHit(rs.getInt("hit"));
				//board.setNick(rs.getString("nick"));
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
	public int delete(Connection conn, Board boardno) {

		String sql = "";
		sql += " DELETE board_info WHERE boardno = ?";

		int res=0;

		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());

			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}
//	@Override
//	public List<Report> selectAllReport(Connection conn) {
//
//
//		String sql ="";
//		sql += " SELECT * FROM board_report";
//		List<Report> reportList = new ArrayList<>();
//		try {
//			ps=conn.prepareStatement(sql);
//
//			rs=ps.executeQuery();
//
//
//			while(rs.next()) {
//				Report report = new Report();
//
//				report.setReportno(rs.getInt("reportno"));
//				report.setReportcon(rs.getString("reportcon"));
//				report.setReportdate(rs.getDate("reportdate"));
//				report.setUserno(rs.getInt("userno"));
//				report.setBoardno(rs.getInt("boardno"));
//
//				reportList.add(report);
//
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//
//		return reportList;
//	}
	@Override
	public int selectNoticeCnt(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info WHERE categoryno=1";

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
	public int selectFreeCnt(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info WHERE categoryno=2";

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
	public int selectFoodCnt(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info WHERE categoryno=3";

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
	public int selectMeetingCnt(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info WHERE categoryno=4";

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
	public int selectQnaCnt(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM board_info WHERE categoryno=5";

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
	public int selectReportCnt(Connection conn) {
		String sql = "";
		sql += " SELECT count(*) cnt FROM board_report";
		
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
		
		return count;
	}
	@Override
	public BoardFile selectFile(Connection conn, Board viewBoard) {
		String sql = "";
		sql += "SELECT fileno, boardno, fileoriginname, filestoredname, filesize, boarddate";
		sql += " FROM board_file";
		sql += " WHERE boardno = ?";
		
		BoardFile boardFile = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, viewBoard.getBoardno());
				rs=ps.executeQuery();
				
			while(rs.next()) {
				
				boardFile = new BoardFile();
				
				boardFile.setFileno(rs.getInt("fileno"));
				boardFile.setBoardno(rs.getInt("boardno"));
				boardFile.setFileoriginname(rs.getString("fileoriginname"));
				boardFile.setFilestoredname(rs.getString("filestoredname"));
				boardFile.setFilesize(rs.getInt("filesize"));
				boardFile.setBoarddate(rs.getDate("boarddate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boardFile;
	}
	

}
