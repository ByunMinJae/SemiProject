package minjae.dao.face;

import java.sql.Connection;

import minjae.dto.UserInfo;

public interface FindUserDao {
	
	/**
	 *  전달 파라미터를 이용하여
	 * 해당 이메일 정보를 가진 유저의 정보를 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param email - 유저 이메일
	 * @return 유저 정보 객체
	 */
	public UserInfo selectEmail(Connection conn, String email);

}
