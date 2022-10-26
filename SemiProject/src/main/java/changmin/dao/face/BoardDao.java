package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Category;
import daun.dto.Board;
import sharon.dto.User;
import util.Paging;

public interface BoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn
	 * @return List<Board> - 테이블 전체 조회 목록
	 */
	public List<Board> selectAll(Connection conn);

	/**
	 * 페이징, 카테고리화된 테이블 전체 조회
	 * @param conn
	 * @param paging - 페이징 적용
	 * @param category - 카테고리 적용
	 * @return List<Board> - 페이징,카테고리된 리스트 조회 
	 */
	public List<Board> selectAll(Connection conn, Paging paging, Category category);
	
	/**
	 * 게시글 갯수 조회
	 * @param conn
	 * @param category - 카테고리 적용
	 * @return - 카테고리 적용된 게시글 갯수 조회 
	 */
	public int selectCntAll(Connection conn, Category category);

	/**
	 * 조회수 증가
	 * @param conn
	 * @param boardno - 게시글번호
	 * @return - 게시글번호 클릭시 조회수 +1
	 */
	public int updateHit(Connection conn, Board boardno);

	/**
	 * boradno에 따른 게시글 조회
	 * @param conn
	 * @param boardno - 게시글번호
	 * @return - Boardno에 따른 게시글 조회
	 */
	public Board selectBoardByBoardno(Connection conn, Board boardno);

	/**
	 * 게시글 삭제
	 * @param conn
	 * @param board
	 * @return
	 */
	public int delete(Connection conn, Board board);

	public Category selectCatename(Connection conn, int i);

	public User getNick(Connection conn, Board bUserno);

	public List<Board> selectAll(Connection connection, Paging paging, Category category, String word);

	public int selectCntAll(Connection connection, Category category, String word);




	

}
