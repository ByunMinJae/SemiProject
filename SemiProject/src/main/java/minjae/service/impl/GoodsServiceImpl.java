package minjae.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae.dao.face.GoodsDao;
import minjae.dao.impl.GoodsDaoImpl;
import minjae.dto.Product;
import minjae.dto.ProductFile;
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
	public Paging getPagingForSearch(HttpServletRequest req, String search) {
		System.out.println("/goods/list getPagingForSearch() - 시작");
		
		//총 게시글 수 조회하기
		int totalCount = goodsDao.selectCntSearch(JDBCTemplate.getConnection(), search);
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage, 4, 5);
		
		System.out.println("/goods/list getPagingForSearch() - 끝");
		return paging;
	}
	
	@Override
	public List<Product> getGoodsList(Paging paging) {
		System.out.println("/goods/list getGoodsList()");
		return goodsDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Product> getGoodsList(Paging paging, String cateVal) {
		System.out.println("/goods/list getGoodsList(cateVal)");
		return goodsDao.selectAll(JDBCTemplate.getConnection(), paging, cateVal);
	}
	
	@Override
	public List<Product> getSearchList(Paging paging, String search) {
		System.out.println("/goods/list getGoodsList(search)");
		
		//로그아웃 하고 세션에 seach가 null일때 아무것도 안나오는 경우 기본값 보여주기로 처리
		if( search == null ) {
			String def = "%%";
			return goodsDao.selectSearchDefualt(JDBCTemplate.getConnection(), paging, def);
		} else {
			return goodsDao.selectSearchAll(JDBCTemplate.getConnection(), paging, search);
		}
	}
	
	@Override
	public Product getProdDetail(int prodno) {
		System.out.println("/goods/detail getProdDetail() - 시작");
		
		Product prod = goodsDao.selectProdDetail(JDBCTemplate.getConnection(), prodno);
		
		System.out.println("/goods/detail getProdDetail() - 끝");
		return prod;
	}

	@Override
	public int insertBuyProd(HttpServletRequest req, int userno) {
		System.out.println("/goods/detail insertBuyProd() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		String buyprodname = req.getParameter("buyprodname");
		int totalamount = Integer.parseInt(req.getParameter("totalamount"));
				
		int res = goodsDao.insertBuyProd(conn, userno, buyprodname, totalamount);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("/goods/detail insertBuyProd() - 끝");
			return 1;
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/goods/detail insertBuyProd() - 끝");
			return 0;
		}
		
	}
	
	@Override
	public ProductFile viewFile(Product pordDetail) {
		return goodsDao.selectFile(JDBCTemplate.getConnection(), pordDetail);
	}
	
	@Override
	public List<ProductFile> viewFile(List<Product> goodsList) {
		return goodsDao.selectFileList(JDBCTemplate.getConnection(), goodsList);
	}
	
}
