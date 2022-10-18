package sharon.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sharon.dto.User;

public interface JoinService {

	public User getParam(HttpServletRequest req);
	
	public User info(User user);

	public void join(User user);
	
/*
 * //10/14 ->회원목록조회 public List<User> list();
 * 
 * public User info(int userno); 
 */
}