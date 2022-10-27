package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Board;
import daun.dto.BoardFile;

public interface FileDao {

	List<BoardFile> selectAll(Connection conn, Board boardno);
	
	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 게시글 번호
	 * @return BoardFile - 첨부파일 정보
	 */
	public BoardFile selectFile(Connection conn, Board viewBoard);

}
