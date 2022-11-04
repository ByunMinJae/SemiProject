package sharon.service.face;


import javax.servlet.http.HttpServletRequest;

import sharon.dto.User;

public interface JoinService {

	public User getParam(HttpServletRequest req);
	
	public User info(User user);

	public void join(User user);

	public int deleteUserInfo(int userno);

//	public void delete(User userno);

//	public User infoUserno(int userno);
	

}