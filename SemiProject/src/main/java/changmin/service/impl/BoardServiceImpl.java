package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.BoardDao;
import changmin.dao.impl.BoardDaoImpl;
import changmin.service.face.BoardService;
import common.JDBCTemplate;
import daun.dto.Board;
import util.Paging;

public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao = new BoardDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Board getBoardno(HttpServletRequest req) {
		
		Board board = new Board();
		
		String param = req.getParameter("boardno");
		
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			board.setBoardno( Integer.parseInt(param) );
		}
		
		return board;
	}

	@Override
	public Board view(Board boardno) {
		return null;
	}

	@Override
	public String getWriteNick(Board viewBoard) {
		return null;
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
	public List<Board> getList(Paging paging) {
		return null;
	}

}
