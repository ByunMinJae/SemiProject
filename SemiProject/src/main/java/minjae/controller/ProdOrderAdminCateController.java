package minjae.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/prodOrdAdCate/list")
public class ProdOrderAdminCateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/prodOrdAdCate/list [GET]");
		
		//세션 객체
		HttpSession session = req.getSession();
		
		//로그인 유무 확인
		if( session.getAttribute("userno") != null ) {
			//세션에서 카테고리명 가져오기
			String cate = (String)session.getAttribute("cate");
			
			//요청받은 카테고리명이 세션에 있는 카테고리명과 다를경우
			//	-> cate != req.getParameter("cate")
			//요청받은 카테고리명이 없는 경우
			//	-> null != req.getParameter("cate")
			if(cate != req.getParameter("cate") && null != req.getParameter("cate")) {
				//세션에 cate를 요청 값으로 등록한다
				session.setAttribute("cate", req.getParameter("cate"));
			}
			
			//리스트 출력 컨트롤러로 이동
			req.getRequestDispatcher("/prodOrdAd/list").forward(req, resp);
			
		} else {
			//세션에 로그인 정보가 없을 때 alert반환
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter pw = resp.getWriter();
			pw.append("<script type=\"text/javascript\">alert('로그인 후 이용 가능합니다.'); location.href = '/';</script>");
		}
		
	}
	
}
