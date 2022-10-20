package minjae.dao.face;

import java.sql.Connection;

import minjae.dto.MpMain;
import minjae.dto.MpMainRight;

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
	
	/**
	 *  userno을 이용해 해당 유저가 가진 
	 * 주문처리 상태를 종류 별로 조회하여 DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 유저번호
	 * @return MpMainRight DTO - 주문처리 상태가 종류별로 담겨있음
	 */
	public MpMainRight selectOrderInfo(Connection conn, int userno);

	/**
	 *  전달 받은 날짜에 포함되는 주문의 처리상태를
	 * 종류별로 count() 하여 값을 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param startDate - 시작 날짜
	 * @param endDate - 끝 날짜
	 * @return MpMainRight DTO - 처리상태를 종류별로 count()한 결과값이 저장된 DTO
	 */
	public MpMainRight selectOIByDate(Connection conn, int userno, String startDate, String endDate);

}
