package minjae.service.face;

import minjae.dto.MpMain;

public interface MypageService {
	
	/**
	 *  세션에 저장된 userno을 이용해
	 * 해당 유저의 정보를 DTO에 담아 반환한다
	 * 
	 * @param userno - 유저번호
	 * @return UserInfo DTO - 유저의 정보
	 */
	public MpMain getUserInfo(int userno);

}
