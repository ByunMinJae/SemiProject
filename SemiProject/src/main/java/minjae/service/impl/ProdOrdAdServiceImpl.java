package minjae.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae.dao.face.ProdOrdAdDao;
import minjae.dao.impl.ProdOrdAdDaoImpl;
import minjae.dto.ProdOrdAd;
import minjae.service.face.ProdOrdAdService;
import util.Paging;

public class ProdOrdAdServiceImpl implements ProdOrdAdService {
	
	ProdOrdAdDao prodOrdAdDao = new ProdOrdAdDaoImpl();
	
	@Override
	public List<ProdOrdAd> getProdOrdInfo(Paging paging) {
		System.out.println("/prodOrdAd/list getProdOrdInfo() - 시작");
		
		List<ProdOrdAd> prodOrdInfo = prodOrdAdDao.selectProdOrdInfo(JDBCTemplate.getConnection(), paging);
		
		System.out.println("/prodOrdAd/list getProdOrdInfo() - 끝");
		return prodOrdInfo;
	}
	
	@Override
	public List<ProdOrdAd> getProdOrdCate(Paging paging, String cate) {
		System.out.println("/prodOrdAd/list getProdOrdCate() - 시작");
		
		List<ProdOrdAd> prodOrdCate = prodOrdAdDao.selectProdOrdCate(JDBCTemplate.getConnection(), paging, cate);
		
		System.out.println("/prodOrdAd/list getProdOrdCate() - 끝");
		return prodOrdCate;
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		System.out.println("/prodOrdAd/list getPaging() - 시작");
		
		//총 게시글 수 조회하기
		int totalCount = prodOrdAdDao.selectCntAll(JDBCTemplate.getConnection());
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage, 10, 5);
		
		System.out.println("/prodOrdAd/list getPaging() - 끝");
		return paging;
	}
	
	@Override
	public boolean changeOrdProcess(HttpServletRequest req) {
		System.out.println("/prodOrdAd/list changeOrdProcess() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		int res = prodOrdAdDao.updateOrdProc(conn, req);
		
		if(res > 0) {
			JDBCTemplate.commit(conn);
			System.out.println("/prodOrdAd/list changeOrdProcess() - 끝");
			return true;
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/prodOrdAd/list changeOrdProcess() - 끝");
			return false;
		}
		
	}
	
}
