package minjae.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.BoardInfoCate;
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
	
	/**
	 *  세션에 저장된 userno를 이용해 해당 유저의
	 * 게시글 정보와 카테고리 정보를 Join하여 List로 가져온다
	 * 
	 * @param userno - 유저번호
	 * @return List<BoardInfoCate> - 게시글 정보, 카테고리정보
	 */
	public List<BoardInfoCate> getBoardInfoCate(int userno);
	
	/**
	 *  입력받은 pw가 현재 로그인한 회원의 
	 * 패스워드가 맞는지 확인 하고 결과 반환
	 * 
	 * @param userno - session의 회원 번호
	 * @param pw - 입력 받은 패스워드
	 * @return boolean 결과
	 */
	public boolean checkUserpw(int userno, String pw);
	
	/**
	 * 변경하려는 닉네임이 DB에 존재하는지 조회
	 * 
	 * @param nick - 닉네임
	 * @return 조회결과
	 */
	public int existNick(String nick);
	
	/**
	 * 변경하려는 전화번호가 DB에 존재하는지 조회
	 * 
	 * @param phone - 전화번호
	 * @return 조회결과
	 */
	public int existPhone(String phone);
	
	/**
	 *  세션에 저장된 userno을 가진 회원의 닉네임을 변경한다
	 * 
	 * @param userno - 회원 번호
	 * @param nick - 변경 닉네임
	 * @return update 수행 결과
	 */
	public int updateUserNick(int userno, String nick);
	
	
	
	
}










