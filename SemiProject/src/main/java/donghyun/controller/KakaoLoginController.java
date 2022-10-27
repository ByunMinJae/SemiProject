package donghyun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donghyun.dto.KakaoId;
import donghyun.service.face.KakaoService;
import donghyun.service.impl.KakaoServiceImpl;

/**
 * Servlet implementation class KakaoLoginController
 */
@WebServlet("/cmc/kakao")
public class KakaoLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	KakaoService kakaoService = new KakaoServiceImpl();
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("kakao [GET]");
    	
    	resp.sendRedirect("/");
    	}
    
    	@Override
    		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		System.out.println("kakao [POST]");
    		
    		req.setCharacterEncoding("UTF-8");
    		
    		String kakaoEmail = req.getParameter("kakaoemail");
    		String kakaoNick = req.getParameter("kakaonick");
    		
    		KakaoId kakaoId = new KakaoId();
    		
    		kakaoId.setKakaoEmail(kakaoEmail);
    		kakaoId.setKakaoNick(kakaoNick);
    		
    		kakaoId = kakaoService.selectKakaoUser(kakaoEmail, kakaoNick);
    		if(kakaoId ==null) {
    			kakaoService.insert(kakaoId);
    			
    			HttpSession session = req.getSession();
    			
    			session.setAttribute("kakaono", kakaoId.getKakaono());
    			
    			resp.sendRedirect("/");
    		}else {
    			HttpSession session = req.getSession();
    			session.setAttribute("kakaono", kakaoId.getKakaono());
    			System.out.println("session 부여 완료");
    			resp.sendRedirect("/");
    			
    		}
    		
    		
    		
    		
    			
    	    	
    	    	
    		
    			
    			
    			
    			
    		
    		

    	}
}
