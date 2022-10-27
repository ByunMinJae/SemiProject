package donghyun.dao.face;

import java.sql.Connection;
import java.util.List;

import donghyun.dto.Board;
import donghyun.dto.BoardFile;
import donghyun.dto.Report;
import util.Paging;

public interface BoardDao {

	List<Board> selectBoardByCategory1(Connection conn, Paging paging);

	List<Board> selectBoardByCategory2(Connection conn, Paging paging);

	List<Board> selectBoardByCategory3(Connection conn, Paging paging);

	List<Board> selectBoardByCategory4(Connection conn, Paging paging);

	List<Board> selectBoardByCategory5(Connection conn, Paging paging);

	Board selectBoardByBoardno(Connection conn, Board boardno);

	int delete(Connection conn, Board boardno);


	int selectNoticeCnt(Connection connection);

	int selectFreeCnt(Connection connection);

	int selectFoodCnt(Connection connection);

	int selectMeetingCnt(Connection connection);

	int selectQnaCnt(Connection connection);

	int selectReportCnt(Connection connection);

	

	List<Report> selectReportBoard(Connection connection, Paging paging);

	BoardFile selectFile(Connection connection, Board viewBoard);

}
