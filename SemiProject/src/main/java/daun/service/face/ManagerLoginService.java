package daun.service.face;

import donghyun.dto.UserInfo;

public interface ManagerLoginService {

	/**
	 * 
	 * 
	 * @param userid
	 * @param userpw
	 * @return
	 */
	public UserInfo selectOneUser(String userid, String userpw);
	
	

}
