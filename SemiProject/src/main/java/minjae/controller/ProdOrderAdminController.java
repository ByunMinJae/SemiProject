package minjae.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.dto.ProdOrdAd;
import minjae.service.face.ProdOrdAdService;
import minjae.service.impl.ProdOrdAdServiceImpl;

@WebServlet("/admin/prodOrdAd")
public class ProdOrderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdOrdAdService prodOrdAdService = new ProdOrdAdServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/prodOrdAd [GET]");
		
		//세션 객체
		HttpSession session = req.getSession();
		session.setAttribute("userno", 1234);
		
		if( session.getAttribute("userno") != null ) {
			
			List<ProdOrdAd> prodOrdAdInfo = prodOrdAdService.getProdOrdInfo();
			System.out.println(prodOrdAdInfo);
			req.setAttribute("prodOrdAdInfo", prodOrdAdInfo);
			req.getRequestDispatcher("/WEB-INF/views/minjae/admin/prodOrdAd.jsp").forward(req, resp);
			
		} else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			pw.append("<script type=\"text/javascript\">alert('로그인 후 이용 가능합니다.'); location.href = '/';</script>");
		}
		
		
		
	}
	
}
