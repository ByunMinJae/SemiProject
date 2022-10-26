package changmin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dto.Board;
import changmin.dto.Category;
import sharon.dto.User;
import util.Paging;

public interface BoardService {

	/**
	 * 게시글 전체 조회
	 * 
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Board> getList();

	
	/**
	 * 페이징 객체
	 * 
	 * @param req
	 * @return Paging - 페이징 계산 완료 객체
	 */
	public Paging getPaging(HttpServletRequest req, Category category);

	/**
	 * 페이징된 게시글 전체 조회
	 * 
	 * @param paging - 페이징 객체
	 * @param category - 카테고리번호 불러오기
	 * @return List<Board> - 카테고리번호를 통해 조회된 게시글을 페이징 적용하여 리스트로 반환
	 * 
	 */
	public List<Board> getList(Paging paging, Category category);


	/**
	 * 게시글번호 불러오기
	 * 
	 * @param req
	 * @return Board - 게시글번호 반환
	 */
	public Board getBoardno(HttpServletRequest req);


	/**
	 * 게시글 상세보기
	 * 
	 * @param boardno - 게시글번호 불러오기
	 * @return Board - 게시글번호에 따른 게시글 상세내용 반환
	 */
	public Board view(Board boardno);


	/**
	 * 게시글 삭제
	 * 
	 * @param board
	 */
	public void deleteboard(Board board);


	/**
	 * 카테고리이름 조회
	 * 
	 * @param i - 카테고리 번호
	 * @return - 카테고리 번호에 따른 카테고리 이름 조회
	 */
	public Category catename(int i);


	/**
	 * 닉네임 조회
	 * 
	 * @param bUserno - 게시글 유저넘버
	 * @return User - 게시글 유저넘버에 따른 닉네임 반환
	 */
//	public User getNick(Board bUserno);


	/**
	 * 게시글 유저넘버 조회
	 * 	
	 * @param req
	 * @return Board - 게시글 유저넘버 반환
	 */
	public Board getUserno(HttpServletRequest req);


	public List<Board> getList(Paging paging, Category category, String word);


	public Paging getPaging(HttpServletRequest req, Category category, String word);






	
	
}
