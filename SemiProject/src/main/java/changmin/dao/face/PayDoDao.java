package changmin.dao.face;

import java.sql.Connection;

import changmin.dto.Product;
import changmin.dto.User;

public interface PayDoDao {

	public User getUserInfo(Connection conn, int userno);

	public Product getProdInfo(Connection conn, int prodno);

	public User updateUser(Connection conn, int userno);

}
