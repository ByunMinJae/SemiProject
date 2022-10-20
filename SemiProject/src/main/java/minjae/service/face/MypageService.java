package minjae.service.face;

import minjae.dto.MpMain;
import minjae.dto.MpMainRight;

public interface MypageService {
	
	/**
	 *  세션에 저장된 userno을 이용해
	 * 해당 유저의 정보를 DTO에 담아 반환한다
	 * 
	 * @param userno - 유저번호
	 * @return UserInfo DTO - 유저의 정보
	 */
	public MpMain getUserInfo(int userno);
	
	/**
	 *  해당 유저번호를 가진 유저의 주문처리 상태를
	 * 조회후 반환한다
	 * 
	 * @param userno - 유저번호
	 * @return MpMainRight DTO
	 */
	public MpMainRight getOrderInfo(int userno);
	
	/**
	 * 해당 날짜에 포함되는 주문의 주문처리 상태를 반환한다 
	 * 
	 * @param startDate - 시작 날짜
	 * @param endDate - 끝 날짜
	 * @return MpMainRight DTO
	 */
	public MpMainRight getOrderInfoByDate(int userno, String startDate, String endDate);

}










