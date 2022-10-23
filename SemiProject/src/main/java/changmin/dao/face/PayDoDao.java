package changmin.dao.face;

import java.sql.Connection;

import jeonghwa.dto.Product;
import sharon.dto.User;

public interface PayDoDao {

	public User getUserInfo(Connection conn, int userno);

	public Product getProdInfo(Connection conn, int prodno);

	public User updateUser(Connection conn, int userno);

}
