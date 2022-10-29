package daun.dao.face;

import java.sql.Connection;
import java.util.List;

import daun.dto.Board;
import daun.dto.BoardFile;
import daun.dto.Report;
import daun.util.Paging;
import sharon.dto.User;



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
	 * 게시글 작성자 ID를 이용하여 usernick 을 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 id를 가진 객체
	 * @return String - 작성자 닉네임
	 */
	public String selectNickByBoard(Connection conn, Board viewBoard);
	
	/**
	 * 
	 * 
	 * @param conn
	 * @param userno
	 * @return
	 */
	public User getUserInfo(Connection conn, int userno);

	/**
	 * 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, Board board, int userno);
	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 번호
	 */
	public int selectNextBoardno(Connection conn);

	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return int - INSERT 수행 결과
	 */
	public int insertFile(Connection conn, BoardFile boardFile);

	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 게시글 번호
	 * @return BoardFile - 첨부파일 정보
	 */
	public BoardFile selectFile(Connection conn, Board viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 수정할 내용을 담은 객체
	 * @return UPDATE 수행 결과
	 */
	public int update(Connection conn, Board board);

	/**
	 * 게시글에 첨부된 파일 정보 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int deleteFile(Connection conn, Board board);

	
	/**
	 * 게시글 신고
	 * 
	 * @param conn - DB연결 객체
	 * @param report - 신고 내용을 담은 객체
	 * @return int - INSERT REPORT 수행 결과
	 */
	public int insertreport(Connection conn, Report report);

	
	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 신고 번호
	 */
	public int selectNextreportno(Connection conn);

	/**
	 * 
	 * 
	 * 
	 * @param conn
	 * @param userno
	 * @return
	 */
	public User UserInfo(Connection conn, int userno);
	

}
