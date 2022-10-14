package sharon.dao.face;

import java.sql.Connection;
import java.util.List;

import sharon.dto.User;

public interface JoinDao {

	public int selectNextUserno(Connection conn);
	
	public int insert(Connection conn, User user);
	
	/*
	 * //---10/14추가 ->회원목록조회 public List<User> selectAll(Connection conn);
	 * 
	 * public User selectByUserno(Connection conn, int userno);
	 */
}
