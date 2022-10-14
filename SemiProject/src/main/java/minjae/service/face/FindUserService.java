package minjae.service.face;

import minjae.dto.UserFind;
import minjae.dto.UserInfo;

public interface FindUserService {
	
	/**
	 *  전달받은 이메일로 가입한 유저가 있는지 확인 후
	 * 해당 유저의 userId, userEmail 정보를 반환
	 * 
	 * @param email - 입력받은 유저 이메일
	 * @return UserInfo - userid, userpw, email이 담긴 DTO
	 */
	public UserInfo checkEmail(String email);
	
	/**
	 *  인증번호 생성 후 전달받은 유저 정보와 함께
	 * 인증번호 정보 테이블에 저장한다
	 * 
	 * @param user - 유저 정보 객체
	 */
	public void createAuth(UserInfo user);
	
	/**
	 *  전달받은 유저정보 DTO를 이용하여
	 * 해당 유저의 인증번호 정보 DTO를 가져온다
	 * 
	 * @param user - 유저 정보 객체
	 * @return UserFind - 인증번호 정보 객체
	 */
	public UserFind getUserFind(UserInfo user);
	
	/**
	 *  전달받은 DTO정보의 이메일로 인증번호를 발송한다
	 * 
	 * @param userFind - 인증번호 정보 DTO
	 */
	public void sendEmail(UserFind userFind);

}
