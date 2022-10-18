package donghyun.dao.face;

import java.sql.Connection;

import donghyun.dto.UserInfo;

public interface LoginDao {

	UserInfo selectOneUser(String userid, String userpw, Connection conn);

//	public int selectCntUserByUseridUserpw(Connection conn, UserInfo user);
//
//	public UserInfo  selectUserByUserid(Connection conn, UserInfo user);

	

	

	 

}
