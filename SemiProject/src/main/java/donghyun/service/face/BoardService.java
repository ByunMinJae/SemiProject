package donghyun.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import donghyun.dto.Board;

public interface BoardService {

	/**
	 * 공지사항 목록을 조회하는 메소드 
	 * @return
	 */
	List<Board> getNoticeList();
	
	/**
	 * 자유게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getFreeList();
	
	/**
	 * 맛집게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getFoodList();
	
	/**
	 * 모임게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getMeetingList();
	
	/**
	 * 질문게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getQnaList();
	
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	Board getboardno(HttpServletRequest req);

	
	Board view(Board boardno);

	void delete(Board boardno);

	

}
