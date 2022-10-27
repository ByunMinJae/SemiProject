package changmin.service.face;

import java.util.List;

import changmin.dto.Board;
import daun.dto.BoardFile;

public interface FileService {

	/**
	 * 업로드된 파일의 전체 정보를 조회한다.
	 * @param boardno 
	 * 
	 * @return 조회된 전체 파일 목록
	 */
	public List<BoardFile> list(Board boardno);
	
	/**
	 * 첨부파일 정보 조회하기
	 * 
	 * @param viewBoard - 첨부파일과 연결된 게시글의 번호
	 * @return BoardFile - 첨부파일 정보 DTO객체
	 */
	public BoardFile viewFile(Board viewBoard);
}
