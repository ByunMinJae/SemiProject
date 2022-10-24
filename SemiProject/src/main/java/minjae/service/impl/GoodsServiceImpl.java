package minjae.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae.dao.face.GoodsDao;
import minjae.dao.impl.GoodsDaoImpl;
import minjae.dto.Product;
import minjae.service.face.GoodsService;
import util.Paging;

public class GoodsServiceImpl implements GoodsService {
	
	private GoodsDao goodsDao = new GoodsDaoImpl();
	
	@Override
	public List<Product> getGoodsList() {
		System.out.println("/goods/list getGoodsList() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<Product> list = goodsDao.selectProdList(conn);
		
		System.out.println("/goods/list getGoodsList() - 끝");
		return list;
	}

	@Override
	public Paging getPaging(HttpServletRequest req) {
		System.out.println("/goods/list getPaging() - 시작");
		
		//총 게시글 수 조회하기
		int totalCount = goodsDao.selectCntAll(JDBCTemplate.getConnection());
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage, 4, 5);
		
		System.out.println("/goods/list getPaging() - 끝");
		return paging;
	}
	
	@Override
	public List<Product> getGoodsList(Paging paging) {
		return goodsDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Product> getGoodsList(Paging paging, String cateVal) {
		return goodsDao.selectAll(JDBCTemplate.getConnection(), paging, cateVal);
	}
	
	@Override
	public Product getProdDetail(int prodno) {
		System.out.println("/goods/detail getProdDetail() - 시작");
		
		Product prod = goodsDao.selectProdDetail(JDBCTemplate.getConnection(), prodno);
		
		System.out.println("/goods/detail getProdDetail() - 끝");
		return prod;
	}
	
}
