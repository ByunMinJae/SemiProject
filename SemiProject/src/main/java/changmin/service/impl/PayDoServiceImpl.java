package changmin.service.impl;

import java.sql.Connection;

import changmin.dto.Pay;
import changmin.service.face.PayDoService;
import common.JDBCTemplate;

public class PayDoServiceImpl implements PayDoService{

	@Override
	public Pay paydo() {
		Connection conn = JDBCTemplate.getConnection();
		
		return null;
	}

}
