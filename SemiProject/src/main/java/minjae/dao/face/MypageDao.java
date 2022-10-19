package minjae.dao.face;

import java.sql.Connection;

import minjae.dto.MpMain;

public interface MypageDao {
	
	/**
	 *  전달 받은 userno를 DB에 조회하여
	 * 해당 유저의 정보를 DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 유저 번호
	 * @return UserInfo DTO - 유저 정보가 담긴 객체
	 */
	public MpMain selectUserInfo(Connection conn, int userno);

}
