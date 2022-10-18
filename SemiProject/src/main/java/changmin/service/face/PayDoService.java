package changmin.service.face;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Pay;
import changmin.dto.Product;
import changmin.dto.User;

public interface PayDoService {
	
	/**
	 * 유저 정보 조회
	 * @param req 
	 * 
	 * @param userno
	 * @return - 유저번호 반환
	 */
	public User getUserInfo(int userno);
	
	/**
	 * 결제하기
	 * @param req 
	 * 
	 * @return - 결제정보 반환
	 */
	public Pay paydo(HttpServletRequest req);

	/**
	 * 결제할 상품 불러오기
	 * @param prodno
	 * @return - 상품정보 조회
	 */
	public Product getProdInfo(int prodno);



}
