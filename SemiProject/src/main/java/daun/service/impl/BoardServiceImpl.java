package daun.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import daun.dao.face.BoardDao;
import daun.dao.impl.BoardDaoImpl;
import daun.dto.Board;
import daun.service.face.BoardService;
import daun.util.Paging;

public class BoardServiceImpl implements BoardService {

	//DAO객체
	private BoardDao boardDao = new BoardDaoImpl();

	
	@Override
	public List<Board> getList() {
		System.out.println("BoardService getList() - 시작");
		
		System.out.println("BoardService getList() - 끝");
		
		//DB조회결과 반환
		return boardDao.selectAll(JDBCTemplate.getConnection());
	}
	
	@Override
	public List<Board> getList(Paging paging) {
		return boardDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//총 게시글 수 조회하기
		int totalCount = boardDao.selectCntAll(JDBCTemplate.getConnection());
		
		
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

		//전달파라미터를 저장할 객체 생성
		Board board = new Board();
		
		//전달파라미터 boardno 추출(파싱)
		String param = req.getParameter("boardno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			board.setBoardno( Integer.parseInt(param) );
		}
		
		return board;
	}
	
	@Override
	public Board view(Board boardno) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( boardDao.updateHit(conn, boardno) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		Board board = boardDao.selectBoardByBoardno(conn, boardno);
		
		//조회된 게시글 리턴
		return board;
	}
	
}



