package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.service.face.GoodsService;
import minjae.service.impl.GoodsServiceImpl;

@WebServlet("/goods/buy")
public class GoodsBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodsService goodsService = new GoodsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/buy [GET]");
		
		HttpSession session = req.getSession();
		
		if( session.getAttribute("userno") == null ) {
			//로그인 안한 상태일 때 로그인 시키기
			resp.sendRedirect("/cmc/login");
		
		} else {
			
			int userno = (int)session.getAttribute("userno");
			System.out.println("구매요청한 회원번호 : " + userno);
			System.out.println(req.getParameter("buyprodname") + " : " + req.getParameter("totalamount"));
			int res = goodsService.insertBuyProd(req, userno);
			
			if(res > 0) {
				resp.sendRedirect("/pay/do");
			} else {
				req.getRequestDispatcher("/WEB-INF/views/minjae/notInsertBuyProd.jsp").forward(req, resp);
			}
			
		}
		
	}
	
}
