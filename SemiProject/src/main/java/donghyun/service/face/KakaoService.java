package donghyun.service.face;

import donghyun.dto.KakaoId;

public interface KakaoService {

	void insert(KakaoId kakaoId);

	KakaoId selectKakaoUser(String kakaoEmail, String kakaoNick);

	

}
