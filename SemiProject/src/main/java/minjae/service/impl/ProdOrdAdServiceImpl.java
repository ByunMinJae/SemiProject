package minjae.service.impl;

import java.util.List;

import common.JDBCTemplate;
import minjae.dao.face.ProdOrdAdDao;
import minjae.dao.impl.ProdOrdAdDaoImpl;
import minjae.dto.ProdOrdAd;
import minjae.service.face.ProdOrdAdService;

public class ProdOrdAdServiceImpl implements ProdOrdAdService {
	
	ProdOrdAdDao prodOrdAdDao = new ProdOrdAdDaoImpl();
	
	@Override
	public List<ProdOrdAd> getProdOrdInfo() {
		System.out.println("/admin/prodOrdAd getProdOrdInfo() - 시작");
		
		List<ProdOrdAd> prodOrdInfo = prodOrdAdDao.selectProdOrdInfo(JDBCTemplate.getConnection());
		
		System.out.println("/admin/prodOrdAd getProdOrdInfo() - 끝");
		return prodOrdInfo;
	}

}
