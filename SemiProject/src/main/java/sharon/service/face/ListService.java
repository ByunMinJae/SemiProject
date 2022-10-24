package sharon.service.face;

import java.util.List;

import sharon.dto.User;

public interface ListService {

	public List<User> list();
	public List<User> list(String findType, String findKeyword);
	//전체목록조회


	//회원번호 조회
	public User info(int userno);
}
