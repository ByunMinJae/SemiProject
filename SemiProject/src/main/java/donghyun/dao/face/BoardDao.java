package donghyun.dao.face;

import java.sql.Connection;
import java.util.List;

import donghyun.dto.Board;

public interface BoardDao {

	List<Board> selectBoardByCategory1(Connection conn);

	List<Board> selectBoardByCategory2(Connection connection);

	List<Board> selectBoardByCategory3(Connection connection);

	List<Board> selectBoardByCategory4(Connection connection);

	List<Board> selectBoardByCategory5(Connection connection);

	Board selectBoardByBoardno(Connection conn, Board boardno);

	int delete(Connection conn, Board boardno);

}
