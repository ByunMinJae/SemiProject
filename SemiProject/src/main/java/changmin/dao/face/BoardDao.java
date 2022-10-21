package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import daun.dto.Board;
import util.Paging;

public interface BoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn
	 * @return List<Board> - 테이블 전체 조회 목록
	 */
	public List<Board> selectAll(Connection conn);

	public List<Board> selectAll(Connection conn, Paging paging);
	
	public int selectCntAll(Connection conn);

	public int updateHit(Connection conn, Board boardno);

	public Board selectBoardByBoardno(Connection conn, Board boardno);

	

	

}
