package daun.service.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import daun.dto.Board;
import daun.dto.BoardFile;
import daun.dto.Report;
import daun.util.Paging;
import sharon.dto.User;

public interface BoardService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Board> getList();

	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Board> getList(Paging paging);
	
	/**
	 * 전달파라미터 boardno를 Board DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Board - 전달파라미터 boardno를 저장한 DTO객체
	 */
	public Board getBoardno(HttpServletRequest req);

	/**
	 * 전달된 boardno를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param boardno - 조회할 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글 정보
	 */
	public Board view(Board boardno);


	/**
	 * 전달된 Board객체의 id를 이용하여 nick 조회
	 * 
	 * @param viewBoard - 조회할 게시글 정보
	 * @return String - 게시글 작성자의 닉네임
	 */
	public String getWriteNick(Board viewBoard);
	
	/**
	 * 게시글 작성
	 * 입력한 게시글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

	/**
	 * 첨부파일 정보 조회하기
	 * 
	 * @param viewBoard - 첨부파일과 연결된 게시글의 번호
	 * @return BoardFile - 첨부파일 정보 DTO객체
	 */
	public BoardFile viewFile(Board viewBoard);
	
	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	/**
	 * 게시글 신고
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void report(HttpServletRequest req);

	
	public User getUserInfo(int userno);

	
	
	public Board viewBeforeReport(Board boardno);

	public Board infoboard(Board boardno);

	public int selectNextreportno(Connection conn);


	


	
	
}
