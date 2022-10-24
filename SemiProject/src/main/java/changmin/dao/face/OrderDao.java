package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Order;

public interface OrderDao {

	public int insertOrder(Connection conn, Order order);

	public List<Order> orderList(Connection conn);


}
