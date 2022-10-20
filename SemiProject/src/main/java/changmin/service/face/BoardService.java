package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import daun.dto.Board;
import util.Paging;

public interface BoardService {

	public Board getBoardno(HttpServletRequest req);

	public Board view(Board boardno);

	public String getWriteNick(Board viewBoard);

	public Paging getPaging(HttpServletRequest req);

	public List<Board> getList(Paging paging);
	
	
}
