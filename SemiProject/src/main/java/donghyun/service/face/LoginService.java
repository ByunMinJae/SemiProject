package donghyun.service.face;

import javax.servlet.http.HttpServletRequest;

import donghyun.dto.UserInfo;

public interface LoginService {

	UserInfo selectOneUser(String userid, String userpw);
	

//	UserInfo selectUser(HttpServletRequest req);
//
//	
//	
//	boolean login(UserInfo user);
//
//
//
//	UserInfo info(UserInfo user);
//


	

	
}
