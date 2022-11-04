package donghyun.dto;

public class KakaoId {
	
	private int kakaono;
	private String kakaoEmail;
	private String kakaoNick;
	
	
	public KakaoId() {}
	
	@Override
	public String toString() {
		return "KakaoId [kakaono=" + kakaono + ", kakaoEmail=" + kakaoEmail + ", kakaoNick=" + kakaoNick + "]";
	}

	public int getKakaono() {
		return kakaono;
	}

	public void setKakaono(int kakaono) {
		this.kakaono = kakaono;
	}

	public String getKakaoEmail() {
		return kakaoEmail;
	}

	public void setKakaoEmail(String kakaoEmail) {
		this.kakaoEmail = kakaoEmail;
	}

	public String getKakaoNick() {
		return kakaoNick;
	}

	public void setKakaoNick(String kakaoNick) {
		this.kakaoNick = kakaoNick;
	}
	
	
}
