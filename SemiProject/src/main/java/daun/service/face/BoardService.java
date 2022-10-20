package daun.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import daun.dto.Board;
import daun.util.Paging;

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
	 * 
	 * @param board
	 * @return
	 */
	public int insertBoard(Board board);
	
	
}
