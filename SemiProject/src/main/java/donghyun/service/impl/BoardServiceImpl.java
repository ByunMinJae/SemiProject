package donghyun.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import donghyun.dao.face.BoardDao;
import donghyun.dao.impl.BoardDaoImpl;
import donghyun.dto.Board;
import donghyun.service.face.BoardService;

public class BoardServiceImpl implements BoardService {
	
	BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public List<Board> getNoticeList() {
		return boardDao.selectBoardByCategory1(JDBCTemplate.getConnection());
	}

	@Override
	public List<Board> getFreeList() {
		return boardDao.selectBoardByCategory2(JDBCTemplate.getConnection());
	}

	@Override
	public List<Board> getFoodList() {
		return boardDao.selectBoardByCategory3(JDBCTemplate.getConnection());
	}

	@Override
	public List<Board> getMeetingList() {
		return boardDao.selectBoardByCategory4(JDBCTemplate.getConnection());
	}

	@Override
	public List<Board> getQnaList() {
		return boardDao.selectBoardByCategory5(JDBCTemplate.getConnection());
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

}
