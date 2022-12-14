package minjae.dao.face;

import java.sql.Connection;
import java.util.List;

import minjae.dto.BoardInfoCate;
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
	
	/**
	 * userno에 해당하는 유저의 게시글 정보와 카테고리 정보를  List로 반환한다
	 * 
	 * @param userno - 유저번호
	 * @return List<BoardInfoCate> - 게시글, 카테고리 정보 List
	 */
	public List<BoardInfoCate> selectBoardIC(Connection conn, int userno);
	
	/**
	 *  userno에 해당하는 회원의 패스워드가 pw인
	 * 회원이 있는지 count()로 조회한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 유저번호
	 * @param pw - 패스워드
	 * @return count() 결과 값
	 */
	public int selectUserpw(Connection conn, int userno, String pw);
	
	/**
	 *  해당 닉네임이 이미 가입된 닉네임인지
	 * DB에 조회한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param nick - 닉네임
	 * @return 조회 결과 count()
	 */
	public int countNick(Connection conn, String nick);
	
	/**
	 *  해당 전화번호가 이미 가입된 전화번호인지
	 * DB에 조회한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param phone - 전화번호
	 * @return 조회 결과 count()
	 */
	public int countPhone(Connection conn, String phone);
	
	/**
	 *  해당 회원번호를 가진 회원의 
	 * 이름을 전달받은 값으로 변경한 후
	 * 수행 결과를 리턴한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 회원번호
	 * @param name - 변경 이름
	 * @return 수행결과 (1 - 성공, 0 - 실패)
	 */
	public int updateUserName(Connection conn, int userno, String name);
	
	/**
	 *  해당 회원번호를 가진 회원의 
	 * 닉네임을 전달받은 값으로 변경한 후
	 * 수행 결과를 리턴한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 회원번호
	 * @param nick - 변경 닉네임
	 * @return 수행결과 (1 - 성공, 0 - 실패)
	 */
	public int updateUserNick(Connection conn, int userno, String nick);
	
	/**
	 *  해당 회원번호를 가진 회원의 
	 * 전화번호를 전달받은 값으로 변경한 후
	 * 수행 결과를 리턴한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 회원번호
	 * @param phone - 변경 닉네임
	 * @return 수행결과 (1 - 성공, 0 - 실패)
	 */
	public int updateUserPhone(Connection conn, int userno, String phone);
	
	/**
	 *  해당 회원번호를 가진 회원의 
	 * 주소를 전달받은 값으로 변경한 후
	 * 수행 결과를 리턴한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno - 회원번호
	 * @param address - 변경 주소
	 * @return 수행결과 (1 - 성공, 0 - 실패)
	 */
	public int updateUserAddr(Connection conn, int userno, String address);
	
	/**
	 *  회원정보를 이용해
	 * 해당 유저의 회원정보를 삭제한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param userno1 - 회원 번호
	 * @return DELETE 수행 결과 (1 - 성공, 0 - 실패)
	 */
	public int deleteUser(Connection conn, int userno1);

	
	
	
}
