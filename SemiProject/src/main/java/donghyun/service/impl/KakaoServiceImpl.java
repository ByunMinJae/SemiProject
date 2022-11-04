package donghyun.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import donghyun.dao.face.KakaoDao;
import donghyun.dao.impl.KakaoDaoImpl;
import donghyun.dto.KakaoId;
import donghyun.service.face.KakaoService;

public class KakaoServiceImpl implements KakaoService {

	KakaoDao kakaoDao = new KakaoDaoImpl();
	
	@Override
	public void insert(KakaoId kakaoId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if(kakaoDao.insert(conn, kakaoId)>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}

	@Override
	public KakaoId selectKakaoUser(String kakaoEmail, String kakaoNick) {
		Connection conn = JDBCTemplate.getConnection();
		
		KakaoId kakaoId = kakaoDao.seletKakaoUser(kakaoEmail, kakaoNick, conn);
		
		return kakaoId;
	}

}	