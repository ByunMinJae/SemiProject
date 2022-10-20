package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/checkid")
public class CheckIdController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("/find/checkid [GET]");

      //요청 정보 한글인코딩 설정
      req.setCharacterEncoding("UTF-8");

      //전달받은 정보객체 에서 아이디값 꺼내기
      String id = req.getParameter("userFind");
      req.setAttribute("id", id);
      req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/successFindId.jsp").forward(req, resp);
   }

}