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
import util.Paging;

@WebServlet("/prodOrdAd/list")
public class ProdOrderAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProdOrdAdService prodOrdAdService = new ProdOrdAdServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/prodOrdAd/list [GET]");
		
		//세션 객체
		HttpSession session = req.getSession();
//		session.setAttribute("userno", 1234);
		
		//로그인 유뮤 확인
		if( session.getAttribute("userno") != null ) {
			
			//세션에 cate값 가져오기
			String cate = (String)session.getAttribute("cate");
			System.out.println("[TEST] cate : " + cate);
			
			//현재 페이징 객체 계산하기
			Paging paging = prodOrdAdService.getPaging(req);
			System.out.println("[TEST] paging : " + paging);
			
			//페이징 객체를 MDOEL값 전달
			req.setAttribute("paging", paging);
			
			//세션에 카테고리 정보가 없으면
			if( cate == null || "".equals(cate) ) {
				List<ProdOrdAd> prodOrdAdInfo = prodOrdAdService.getProdOrdInfo(paging);
				System.out.println("[TEST] prodOrdAdInfo : " + prodOrdAdInfo);
				req.setAttribute("prodOrdAd", prodOrdAdInfo);
				req.getRequestDispatcher("/WEB-INF/views/minjae/admin/prodOrdAd.jsp").forward(req, resp);
			} else {
				List<ProdOrdAd> prodOrdAdCate = prodOrdAdService.getProdOrdCate(paging, cate);
				System.out.println("[TEST] prodOrdAdCate : " + prodOrdAdCate);
				req.setAttribute("prodOrdAd", prodOrdAdCate);
				req.getRequestDispatcher("/WEB-INF/views/minjae/admin/prodOrdAd.jsp").forward(req, resp);
			}
			
			
		} else {
			//세션에 로그인 정보가 없을 때 alert반환
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			pw.append("<script type=\"text/javascript\">alert('로그인 후 이용 가능합니다.'); location.href = '/';</script>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/prodOrdAd/list [POST]");
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		
		String select = req.getParameter("select");
		
		if(!"none".equals(select)) {
			//선택한 select값으로 현재 주문상태 변경하기
			boolean result = prodOrdAdService.changeOrdProcess(req); 
		
			if(result == true) {
				System.out.println("orderprocess UPDATE 성공");
				pw.append("<script type=\"text/javascript\">alert('상태 수정되었습니다.');</script>");
			} else {
				System.out.println("orderprocess UPDATE 실패");
				pw.append("<script type=\"text/javascript\">alert('상태 수정에 실패하였습니다. 다시 시도해 주세요');</script>");
			}
		} else {
			pw.append("<script type=\"text/javascript\">alert('상태를 선택해 주세요.');</script>");
		}
	}
	
}






