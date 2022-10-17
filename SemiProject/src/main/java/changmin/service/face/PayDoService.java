package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Pay;
import changmin.dto.User;

public interface PayDoService {

	/**
	 * 유저 정보 조회
	 * 
	 * @return - 유저정보 반환
	 */
	public List<User> userList();
	
	
	/**
	 * 결제하기
	 * @param req 
	 * 
	 * @return - 결제정보 반환
	 */
	public Pay paydo(HttpServletRequest req);


}
