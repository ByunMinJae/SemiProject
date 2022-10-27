package donghyun.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import donghyun.dao.face.BoardDao;
import donghyun.dao.impl.BoardDaoImpl;
import donghyun.dto.Board;
import donghyun.dto.BoardFile;
import donghyun.dto.Report;
import donghyun.service.face.BoardService;
import util.Paging;

public class BoardServiceImpl implements BoardService {

	BoardDao boardDao = new BoardDaoImpl();

	@Override
	public List<Board> getNoticeList(Paging paging) {
		return boardDao.selectBoardByCategory1(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public List<Board> getFreeList(Paging paging) {
		return boardDao.selectBoardByCategory2(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public List<Board> getFoodList(Paging paging) {
		return boardDao.selectBoardByCategory3(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public List<Board> getMeetingList(Paging paging) {
		return boardDao.selectBoardByCategory4(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public List<Board> getQnaList(Paging paging) {
		return boardDao.selectBoardByCategory5(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Report> getReportList(Paging paging) {
		
		return boardDao.selectReportBoard(JDBCTemplate.getConnection(), paging);
	}

	@Override
	public Board getboardno(HttpServletRequest req) {
		Board board = new Board();

		String param = req.getParameter("boardno");
		if( null!= param && !"".equals(param)) {
			board.setBoardno(Integer.parseInt(param));
		}
		return board;
	}

	@Override
	public Board view(Board boardno) {

		Connection conn = JDBCTemplate.getConnection();

		Board board = boardDao.selectBoardByBoardno(conn,boardno);
		return board;
	}

	@Override
	public void delete(Board boardno) {

		Connection conn = JDBCTemplate.getConnection();

		if(boardDao.delete(conn, boardno)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}
	


	@Override
	public Paging getNoticePaging(HttpServletRequest req) {
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectNoticeCnt(JDBCTemplate.getConnection());


		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}


		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;

	}

	@Override
	public Paging getFreePaing(HttpServletRequest req) {
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectFreeCnt(JDBCTemplate.getConnection());


		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}


		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;

	}

	@Override
	public Paging getFoodPaging(HttpServletRequest req) {
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectFoodCnt(JDBCTemplate.getConnection());


		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}


		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public Paging getMeetingPaging(HttpServletRequest req) {
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectMeetingCnt(JDBCTemplate.getConnection());


		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}


		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public Paging getQnaPaging(HttpServletRequest req) {
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectQnaCnt(JDBCTemplate.getConnection());


		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}


		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}

	@Override
	public Paging getReportPaging(HttpServletRequest req) {
		int totalCount = boardDao.selectReportCnt(JDBCTemplate.getConnection());
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
			System.out.println(curPage);
		}
		
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public BoardFile viewFile(Board viewBoard) {
		
		return boardDao.selectFile(JDBCTemplate.getConnection(), viewBoard);
	}

	@Override
	public Report getUserno(HttpServletRequest req) {
		Report report = new Report();
		
		String param = req.getParameter("userno");
		
		if(null!=param&& !"".equals(param) ) {
			report.setUserno(Integer.parseInt(param));
		}
		return report;
	}



	



}
