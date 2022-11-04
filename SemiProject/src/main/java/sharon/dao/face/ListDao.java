package sharon.dao.face;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import sharon.dto.User;

public interface ListDao {
	
	
	public List<User> selectAll(Connection conn);
	public List<User> selectAll(Connection conn, String findType, String findKeyword);
	
	public User selectByUserno(Connection conn,int userno);
	
	public List<User> findUser(String type, String keyword) throws SQLException;


}
