package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Order;
import util.Paging;
import util.Paging2;

public interface OrderDao {

	public int insertOrder(Connection conn, Order order, int userno);

	public List<Order> orderList(Connection conn);

	public int selectCntAll(Connection connection, int userno);

	public List<Order> selectAll(Connection conn, Paging2 paging, int userno);


}
