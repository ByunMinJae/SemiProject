package changmin.dao.face;

import java.sql.Connection;

import changmin.dto.Order;

public interface OrderDao {

	public Order orderinsert(Connection conn);

}
