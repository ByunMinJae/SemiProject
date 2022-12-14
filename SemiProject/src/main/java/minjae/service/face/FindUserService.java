package minjae.service.face;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.UserFind;
import minjae.dto.UserInfo;

public interface FindUserService {
	
	/**
	 *  전달받은 이메일로 가입한 유저가 있는지 확인 후
	 * 해당 유저의 정보를 반환
	 * 
	 * @param email - 입력받은 유저 이메일
	 * @return UserInfo - userid, userpw, email이 담긴 DTO
	 */
	public UserInfo checkEmail(String email);
	
	/**
	 *  인증번호 생성 후 전달받은 유저 정보와 함께
	 * 인증번호 정보 테이블에 저장한다
	 * 
	 * @param user - 유저 정보 DTO
	 */
	public void createAuth(UserInfo user);
	
	/**
	 *  전달받은 유저정보 DTO를 이용하여
	 * 해당 유저의 인증번호 정보 DTO를 가져온다
	 * 
	 * @param user - 유저 정보 DTO
	 * @return UserFind - 인증번호 정보 DTO
	 */
	public UserFind getUserFind(UserInfo user);
	
	/**
	 *  전달받은 DTO정보의 이메일로 인증번호를 발송한다
	 * 
	 * @param userFind - 인증번호 정보 DTO
	 */
	public void sendEmail(UserFind userFind);
	
	/**
	 *  전달받은 유저 정보를 이용하여
	 * 해당 유저의 정보를 조회후 반환한다
	 * 
	 * @param name - 성명
	 * @param phone - 전화번호
	 * @param birth - 생년월일
	 * @return UserInfo DTO
	 */
	public UserInfo getUserInfoByPhone(String name, String phone, String birth);
	
	/**
	 * 해당 유저의 번호로 생성된 인증번호를 발송한다
	 * 
	 * @param user - 유저번호 정보 DTO
	 * @param userFind - 인증번호 정보 DTO
	 */
	public void sendSms(UserInfo user, UserFind userFind);
	
	/**
	 *  전달 받은 아이디를 가진 유저가 있는지 확인 후 
	 * 해당 유저의 정보를 반환한다
	 * 
	 * @param id - 아이디
	 * @return 해당 유저의 UserInfo DTO
	 */
	public UserInfo checkId(String id);
	
	/**
	 *  전달 받은 아이디, 전화번호를 가진 유저가 있는지 확인 후 
	 * 해당 유저의 정보를 반환한다
	 * 
	 * @param id - 아이디
	 * @param phone - 전화번호
	 * @return 해당 유저의 UserInfo DTO
	 */
	public UserInfo checkIdPhone(String id, String phone);

	/**
	 *  전달 받은 id에 해당하는 유저의
	 * 비밀번호를 upw로 변경한다
	 * 
	 * @param id - 아이디
	 * @param upw - 비밀번호
	 * @return 성공 - true, 실패 - false
	 */
	public boolean updateUserPw(String id, String upw);
	
	/**
	 *  해당 요청 비밀번호가 이미 가입된 비밀번호 인지 확인 한다
	 * 
	 * @param req - 요청 비밀번호 정보
	 * @return 조회 결과
	 */
	public int existPw(HttpServletRequest req);
	
	
}
