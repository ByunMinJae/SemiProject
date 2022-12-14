package sharon.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import sharon.dao.face.JoinDao;
import sharon.dao.impl.JoinDaoImpl;
import sharon.dto.User;
import sharon.service.face.JoinService;

public class JoinServiceImpl implements JoinService {


private JoinDao joinDao = new JoinDaoImpl();

	
	public int deleteUserInfo(int userno) {
	System.out.println("serviceimpl: deleteUserInfo() - 시작");
	
	Connection conn = JDBCTemplate.getConnection();
	
	int res = joinDao.delete(conn, userno);
	
	if( res > 0 ) {
		JDBCTemplate.commit(conn);
		return 1; //성공
	} else {
		JDBCTemplate.rollback(conn);
		System.out.println("끝");
		return 0; //실패
	}
}


	public User info(User user) {
		return joinDao.selectMemberByUserid(JDBCTemplate.getConnection(), user);
	}
	
	
	

	public User getParam(HttpServletRequest req) {
		
		User user = new User();
		
		user.setUserid(req.getParameter("userid"));
		user.setUserpw(req.getParameter("userpw"));
		user.setUsername(req.getParameter("username"));
		user.setGender( req.getParameter("gender") );
		user.setAddress( req.getParameter("address") );
		user.setPhone( req.getParameter("phone") );
		user.setBirth( req.getParameter("birth") );
		user.setEmail( req.getParameter("email") );
		user.setNick( req.getParameter("nick") );
		
		return user;
	}

	public void join(User user) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( joinDao.insert(conn, user) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		
	}
	
//	//----userno 찾기 -----10/27

	public User infoUserno(int userno) {
		System.out.println("JoinServiceImpl - detail(): " + userno);
	
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		return joinDao.selectByUserno(conn, userno);
	}

	}

