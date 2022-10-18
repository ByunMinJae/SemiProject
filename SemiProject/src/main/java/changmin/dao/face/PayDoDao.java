package changmin.dao.face;

import java.sql.Connection;

import changmin.dto.User;

public interface PayDoDao {

	public User getUserInfo(Connection conn, int userno);

}
