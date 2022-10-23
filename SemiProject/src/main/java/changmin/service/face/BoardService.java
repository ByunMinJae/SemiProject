package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Category;
import daun.dto.Board;
import util.Paging;

public interface BoardService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Board> getList();

	
	/**
	 * 페이징 객체
	 * 
	 * @param req
	 * @return Paging - 페이징 계산 완료 객체
	 */
	public Paging getPaging(HttpServletRequest req, Category category);


	public List<Board> getList(Paging paging, Category category);


	public Board getBoardno(HttpServletRequest req);


	public Board view(Board boardno);

	
	
}
