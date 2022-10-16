package minjae.dao.face;

import java.sql.Connection;

import minjae.dto.UserFind;
import minjae.dto.UserInfo;

public interface FindUserDao {
	
	/**
	 *  전달 파라미터를 이용하여
	 * 해당 이메일 정보를 가진 유저의 정보를 조회후
	 * DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param email - 유저 이메일
	 * @return UserInfo - 유저 정보 DTO
	 */
	public UserInfo selectEmail(Connection conn, String email);
	
	/**
	 *  인증번호 생성 후
	 * 전달받은 유저 정보를 이용하여
	 * 인증번호화 유저 정보를 USER_FIND 테이블에 INSERT 하고
	 * 결과 값을 int로 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 유저 정보 DTO
	 * @return INSERT 수행 결과 ( 1 - 성공, 0 - 실패 )
	 */
	public int insertAuth(Connection conn, UserInfo user);
	
	/**
	 *  DB에서 해당 이메일을 가진
	 * 인증번호 중 가장 최근에 것을 가져온다
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 유저 정보 객체
	 * @return UserFind - 가장 최근에 생성된 인증번호 객체
	 */
	public UserFind selectAuth(Connection conn, UserInfo user);
	
	/**
	 *  전달 파라미터를 이용해
	 * DB에 조회후 DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param name - 유저 성명
	 * @param phone - 유저 전화번호
	 * @param birth - 유저 생년월일
	 * @return UserInfo DTO
	 */
	public UserInfo selectPhone(Connection conn, String name, String phone, String birth);
	


}
