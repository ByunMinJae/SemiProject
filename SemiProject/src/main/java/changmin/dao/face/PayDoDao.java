package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.User;

public interface PayDoDao {

	public List<User> selectUser(Connection conn);

}
