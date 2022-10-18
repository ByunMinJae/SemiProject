package changmin.service.face;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Pay;
import changmin.dto.User;

public interface PayDoService {
	
	/**
	 * 유저 정보 조회
	 * @param req 
	 * 
	 * @param userno
	 * @return - 유저번호 반환
	 */
	public User getUserInfo(int userno);
	
	/**
	 * 결제하기
	 * @param req 
	 * 
	 * @return - 결제정보 반환
	 */
	public Pay paydo(HttpServletRequest req);



}
