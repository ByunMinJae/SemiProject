package sharon.dao.face;

import java.sql.Connection;
import java.util.List;

import sharon.dto.User;

public interface ListDao {
	
	
	public List<User> selectAll(Connection conn);
	
	public User selectByUserno(Connection conn,int userno);

}
