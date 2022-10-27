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
}
