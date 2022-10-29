package sharon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dao.face.JoinDao;
import sharon.dao.impl.JoinDaoImpl;

@WebServlet("/user/nickcheck")
public class NickCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestFunc(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestFunc(req, resp);
	}

	private void requestFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		if (cmd.equals("NICKCHECK")) {
			JoinDao dao = new JoinDaoImpl();
			String nick = req.getParameter("nick");
			int value = dao.nickCheck(nick);
			
			System.out.println(nick);
			
			String html = "<b ";
			if(value != 1) {
				html += " class='green'> 사용 가능한 닉네임입니다. ";
			}else {
				html += " class='red'> 중복된 닉네임이 있습니다.";
			}
			html+="</b>";
			
			resp.setContentType("text/html; charset=utf-8");
			PrintWriter out = resp.getWriter();
			out.write(html);
			out.flush();
			out.close();
			
		}
	}
}
