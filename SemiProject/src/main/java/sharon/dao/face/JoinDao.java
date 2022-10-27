package sharon.dao.face;

import java.sql.Connection;
import sharon.dto.User;

public interface JoinDao {
	
	
	//비번찾기
	public int selectCntMemberByUseridUserpw(Connection connection, User user);

	//아이디찾기
	public User selectMemberByUserid(Connection connection, User user);

	//회원정보 넣기
	public int insert(Connection conn, User user);
	
	
	//아이디중복
	public int checkId(User user);

	//회원삭제
	public int delete(Connection conn, int userno);

	public User selectByUserno(Connection conn, int userno);


	
}
