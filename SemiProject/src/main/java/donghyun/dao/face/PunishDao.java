package donghyun.dao.face;

import java.sql.Connection;

import donghyun.dto.UserInfo;

public interface PunishDao {

	int getPunish(Connection conn, int userno);

	
}
