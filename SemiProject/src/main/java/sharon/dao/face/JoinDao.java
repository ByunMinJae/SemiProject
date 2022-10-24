package sharon.dao.face;

import java.sql.Connection;
import java.util.List;

import sharon.dto.User;

public interface JoinDao {
	
	public int selectCntMemberByUseridUserpw(Connection connection, User user);

	public User selectMemberByUserid(Connection connection, User user);

	public int insert(Connection conn, User user);
	
	public int checkId(User user);
	
}
