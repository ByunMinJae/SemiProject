package sharon.service.impl;

import java.sql.Connection; 
import java.util.List;

import common.JDBCTemplate;
import sharon.dao.face.ListDao;
import sharon.dao.impl.ListDaoImpl;
import sharon.dto.User;
import sharon.service.face.ListService;

public class ListServiceImpl implements ListService {

	//DAO 객체
		private ListDao listDao = new ListDaoImpl();
		
		public List<User> list() {
			int logIdx = 1; //로그 출력 번호
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". 시작");
			
			//DB연결 객체 생성 - JDBCTemplate 이용
			Connection conn = JDBCTemplate.getConnection();
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DB연결 객체 생성");
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DAO 호출 전");
			
			//Emp테이블 전체 조회 - EmpDao 이용
			List<User> list = listDao.selectAll(conn);
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". " + list);
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DAO 호출 후");
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". 리턴");
			//조회 결과 리턴
			return list;
		}
		
		
		//회원 검색
		public List<User> list(String findType, String findKeyword) {
			int logIdx = 1; //로그 출력 번호
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". 시작");
			
			//DB연결 객체 생성 - JDBCTemplate 이용
			Connection conn = JDBCTemplate.getConnection();
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DB연결 객체 생성");
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DAO 호출 전");
			
			//Emp테이블 전체 조회 - EmpDao 이용
			List<User> list = listDao.selectAll(conn, findType, findKeyword);
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". " + list);
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". DAO 호출 후");
			
			System.out.println("ListService - list() - " + "#" + logIdx++ + ". 리턴");
			//조회 결과 리턴
			return list;
		}


		public User info(int userno) {
			System.out.println("ListService - detail() empno : " + userno);
		
			//DB연결 객체
			Connection conn = JDBCTemplate.getConnection();
			
			return listDao.selectByUserno(conn, userno);
		}
		
	
}
