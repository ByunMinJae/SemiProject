package daun.dao.face;

import java.sql.Connection;

import donghyun.dto.UserInfo;

public interface ManagerLoginDao {

	

	/**
	 * 
	 * 
	 * @param userid
	 * @param userpw
	 * @param conn
	 * @return
	 */
	public UserInfo selectUser(String userid, String userpw, Connection conn);
	
	
}
