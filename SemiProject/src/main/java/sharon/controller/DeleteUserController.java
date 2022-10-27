package sharon.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sharon.service.face.JoinService;
import sharon.service.impl.JoinServiceImpl;


@WebServlet("/user/delete")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JoinService joinService = new JoinServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/delete");
		
	//---------10/26 수정---(세션에 있는 userno가 삭제됨(joinservice)
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno"); 
		
		int res= joinService.deleteUserInfo(userno);
		
		System.out.println("DeleteUserController - deleteUserInfo : " + userno);
		
		//--------------10/27 test
//		String param = req.getParameter("userno");
//		System.out.println("DeleteUserController - param : " + param);
//
//		int userno = 0; 
//		if( param!=null && !"".equals(param) ) {
//			userno = Integer.parseInt(param);
//		}
//		
//		//userno 조회
//		User user = joinService.infoUserno(userno);
//		System.out.println("DeleteUserController - user조회 : " + user);
//			
//		req.setAttribute("user", user);
//		
//		//삭제
//		int res= joinService.deleteUserInfo(userno);
//				
//		System.out.println("DeleteUserController - deleteUserInfo : " + userno);
		
			req.getRequestDispatcher("/WEB-INF/views/sharon/user/select.jsp").forward(req, resp);
	}
}
