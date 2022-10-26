package changmin.dao.face;

import java.sql.Connection;
import java.util.List;

import changmin.dto.Order;
import util.Paging;
import util.Paging2;

public interface OrderDao {

	public int insertOrder(Connection conn, Order order, int userno);

	public List<Order> orderList(Connection conn);

	/**전체조회
	 * 
	 * @param connection
	 * @param userno
	 * @return
	 */
	public int selectCntAll(Connection connection, int userno);

	public List<Order> selectAll(Connection conn, Paging2 paging, int userno);

	/**
	 * 검색기능
	 * @param connection
	 * @param userno
	 * @param word
	 * @return
	 */
	public int selectCntAll(Connection connection, int userno, String word);

	public List<Order> selectAll(Connection conn, Paging2 paging, int userno, String word);


}
