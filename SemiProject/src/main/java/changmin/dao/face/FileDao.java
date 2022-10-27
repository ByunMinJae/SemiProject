package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Board;
import daun.dto.BoardFile;

public interface FileDao {

	List<BoardFile> selectAll(Connection conn, Board boardno);

}
