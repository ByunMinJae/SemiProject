package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.Board;
import changmin.dto.Category;
import changmin.service.face.BoardService;
import changmin.service.face.FileService;
import changmin.service.impl.BoardServiceImpl;
import changmin.service.impl.FileServiceImpl;
import daun.dto.BoardFile;
import sharon.dto.User;
import sharon.service.face.ListService;
import sharon.service.impl.ListServiceImpl;


@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	private ListService listService = new ListServiceImpl();
	private FileService fileService = new FileServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/view  [GET]");
		
		//----------------------게시글 상세 조회-------------------------------
		
		
		//boardno 얻어오기
		Board boardno = boardService.getBoardno(req);
		System.out.println("BoardViewController doGet() - boardno 객체 : " + boardno );

		//boardno에 따른 파일 목록 조회하기
		List<BoardFile> fileList = fileService.list(boardno);
		System.out.println("FileList : " + fileList);
		req.setAttribute("fileList", fileList);
		
		//게시글 상세보기 조회 결과 얻어오기
		Board viewBoard = boardService.view(boardno);
		System.out.println("BoardViewControoler doGet() - viewBoard : " + viewBoard );

		//카테고리 번호 불러오기
		int cateno = viewBoard.getCategoryno();
		System.out.println("Categoryno : " + cateno);
		
		//카테고리 이름 불러오기
		Category category = boardService.catename(cateno);
		System.out.println("Categoryname : " + category.getCategoryname());
		
		req.setAttribute("viewBoard", viewBoard);
		req.setAttribute("category", category);
		
		//첨부파일 정보 조회
		BoardFile boardFile = fileService.viewFile(viewBoard);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("boardFile", boardFile);
		
		//----------------------게시글 상세 조회-------------------------------
		
		//------------------------회원정보 조회--------------------------------

		//유저 리스트 조회
		List<User> list = listService.list();
		
		System.out.println("[TEST} UserListController-전체조회목록");
		
		req.setAttribute("userList", list);
		
		//------------------------회원정보 조회--------------------------------
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/viewboard.jsp").forward(req, resp);
	}
}
