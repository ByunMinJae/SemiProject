package daun.dao.face;

import java.sql.Connection;
import java.util.List;

import daun.dto.Board;
import daun.util.Paging;



public interface BoardDao {

	/**
	 * 게시글 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Board> - 테이블 전체 조회 목록
	 */
	public List<Board> selectAll(Connection conn);

	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param con - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 테이블 페이징 목록 조회 결과
	 */
	public List<Board> selectAll(Connection conn, Paging paging);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return int - UPDATE쿼리 수행 결과
	 */
	public int updateHit(Connection conn, Board boardno);
	
	/**
	 * 지정된 boardno의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글의 상세정보 DTO객체
	 */
	public Board selectBoardByBoardno(Connection conn, Board boardno);

	/**
	 * 
	 * 
	 * @param conn
	 * @param board
	 * @return board - 
	 */
	public int insertBoard(Connection conn, Board board);


}
