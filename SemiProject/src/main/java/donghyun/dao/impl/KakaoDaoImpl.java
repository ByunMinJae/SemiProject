package donghyun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import donghyun.dao.face.KakaoDao;
import donghyun.dto.KakaoId;

public class KakaoDaoImpl implements KakaoDao {
	
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public int insert(Connection conn, KakaoId kakaoId) {
		
		String sql="";
		sql += " INSERT INTO kakaoid VALUES(kakaoid_seq.nextval, ? , ?)";
		
		int res=0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, kakaoId.getKakaoEmail());
			ps.setString(2, kakaoId.getKakaoNick());
			
			
			
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public KakaoId seletKakaoUser(String kakaoEmail, String kakaoNick, Connection conn) {
		KakaoId kakaoId = null;
		
		String sql="";
		sql += " SELECT * FROM kakaoid WHERE kakaoemail=? AND kakaonick=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, kakaoEmail);
			ps.setString(2, kakaoNick);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				kakaoId = new KakaoId();
				
				kakaoId.setKakaono(rs.getInt("kakaono"));
				kakaoId.setKakaoEmail(rs.getString("kakaoemail"));
				kakaoId.setKakaoNick(rs.getString("kakaonick"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return kakaoId;
	}

}
