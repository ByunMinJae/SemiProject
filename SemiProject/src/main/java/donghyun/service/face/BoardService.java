package donghyun.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import donghyun.dto.Board;
import donghyun.dto.BoardFile;
import donghyun.dto.Report;
import util.Paging;

public interface BoardService {

	/**
	 * 공지사항 목록을 조회하는 메소드 
	 * @param paging 
	 * @return
	 */
	List<Board> getNoticeList(Paging paging);
	
	/**
	 * 자유게시판 목록을 조회하는 메소드
	 * @param paging 
	 * @return
	 */
	List<Board> getFreeList(Paging paging);
	
	/**
	 * 맛집게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getFoodList(Paging paging);
	
	/**
	 * 모임게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getMeetingList(Paging paging);
	
	/**
	 * 질문게시판 목록을 조회하는 메소드
	 * @return
	 */
	List<Board> getQnaList(Paging paging);
	
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	List<Report> getReportList(Paging paging);
	
	Board getboardno(HttpServletRequest req);

	
	Board view(Board boardno);

	void delete(Board boardno);


	Paging getNoticePaging(HttpServletRequest req);

	Paging getFreePaing(HttpServletRequest req);

	Paging getFoodPaging(HttpServletRequest req);

	Paging getMeetingPaging(HttpServletRequest req);

	Paging getQnaPaging(HttpServletRequest req);

	Paging getReportPaging(HttpServletRequest req);

	BoardFile viewFile(Board viewBoard);

	Report getUserno(HttpServletRequest req);

	

	

	

}
