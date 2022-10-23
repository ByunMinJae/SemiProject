package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.BoardDao;
import changmin.dao.impl.BoardDaoImpl;
import changmin.dto.Category;
import changmin.service.face.BoardService;
import common.JDBCTemplate;
import daun.dto.Board;
import util.Paging;

public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao = new BoardDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();

	@Override
	public List<Board> getList() {
		System.out.println("getList - Start");
		
		return boardDao.selectAll(conn);
	}

	@Override
	public List<Board> getList(Paging paging, Category category) {
		return boardDao.selectAll(conn, paging, category);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req,Category category) {
		
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectCntAll(conn, category);
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	@Override
	public Board getBoardno(HttpServletRequest req) {
//		Connection conn = JDBCTemplate.getConnection();
		
		//전달파라미터를 저장할 객체 생성
		Board board = new Board();
		
		//전달파라미터 boardno 추출(파싱)
		String param = req.getParameter("boardno");
		
		if( param != null && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리
			board.setBoardno( Integer.parseInt(param) );
		}
		
		
		return board;
	}

	@Override
	public Board view(Board boardno) {
		
		//조회수 증가
		if( boardDao.updateHit(conn, boardno)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		Board board = boardDao.selectBoardByBoardno(conn, boardno);
		
		//조회된 게시글 리턴
		return board;
	}

	@Override
	public void deleteboard(Board board) {
		if(boardDao.delete(conn, board)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

}
