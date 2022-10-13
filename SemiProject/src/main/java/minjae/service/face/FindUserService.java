package minjae.service.face;

import minjae.dto.UserInfo;

public interface FindUserService {
	
	/**
	 *  전달받은 이메일로 가입한 유저가 있는지 확인 후
	 * 해당 유저의 정보를 반환
	 * 
	 * @param email - 유저 이메일
	 * @return 유저 정보 객체
	 */
	public UserInfo checkEmail(String email);

}
