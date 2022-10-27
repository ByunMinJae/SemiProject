package donghyun.dao.face;

import java.sql.Connection;

import donghyun.dto.KakaoId;

public interface KakaoDao {

	int insert(Connection conn, KakaoId kakaoId);

	KakaoId seletKakaoUser(String kakaoEmail, String kakaoNick, Connection conn);

}
