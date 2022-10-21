package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import daun.dto.Board;
import util.Paging;

public interface BoardService {

	/**
	 * 게시글 목록 조회 
	 * @param paging
	 * @return - paging된 게시글 목록 반환 
	 */
	public List<Board> getList(Paging paging);
	
	public Board getBoardno(HttpServletRequest req);

	public Board view(Board boardno);

	public String getWriteNick(Board viewBoard);

	public Paging getPaging(HttpServletRequest req);

	
	
}
