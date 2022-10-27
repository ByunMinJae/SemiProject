package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import changmin.dao.face.FileDao;
import changmin.dao.impl.FileDaoImpl;
import changmin.dto.Board;
import changmin.service.face.FileService;
import common.JDBCTemplate;
import daun.dto.BoardFile;

public class FileServiceImpl implements FileService {

	private Connection conn = JDBCTemplate.getConnection();
	private FileDao fileDao = new FileDaoImpl();

	@Override
	public List<BoardFile> list(Board boardno) {

		return fileDao.selectAll(conn, boardno);
	}

}
