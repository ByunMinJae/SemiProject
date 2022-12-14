package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Order;
import util.Paging;
import util.Paging2;

public interface OrderService {

	public void orderinsert(HttpServletRequest req, int userno);

	public List<Order> orderview(Paging2 paging, int userno);

	public Paging2 getPaging(HttpServletRequest req, int userno);

	public Paging2 getPaging(HttpServletRequest req, int userno, String word);

	public List<Order> orderview(Paging2 paging, int userno, String word);

	public void prodUpdate(String prodno);





}
