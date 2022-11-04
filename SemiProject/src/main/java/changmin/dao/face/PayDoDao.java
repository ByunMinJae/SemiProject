package changmin.dao.face;

import java.sql.Connection;

import changmin.dto.OrderBefore;
import sharon.dto.User;

public interface PayDoDao {

	public User getUserInfo(Connection conn, int userno);

	public User updateUser(Connection conn, int userno);

//	public OrderBefore getOrderInfo(Connection conn, int orderno);

	public OrderBefore getOrderInfo(Connection conn, int userno);
}
