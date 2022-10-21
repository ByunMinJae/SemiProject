package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import daun.dto.Board;
import util.Paging;

public interface BoardDao {

	List<Board> selectAll(Connection conn, Paging paging);

	int selectCntAll(Connection connection);

}
