package jeonghwa.service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import jeonghwa.dao.face.ProductDao;
import jeonghwa.dao.impl.ProductDaoImpl;
import jeonghwa.dto.Product;
import jeonghwa.dto.ProductFile;
import jeonghwa.service.face.ProductService;
import util.Paging;



public class ProductServiceImpl implements ProductService{

	//DAO 객체
	private ProductDao productDao = new ProductDaoImpl();


	@Override
	public List<Product> getList() {
		//DB연결 객체 생성 - JDBCTemplate 이용
		Connection conn = JDBCTemplate.getConnection();		

		//Product테이블 전체 조회 - EmpDao 이용
		List<Product> list = productDao.selectAll(conn);

		return list;
	}



	@Override
	public List<Product> getList(Paging paging) {

		return productDao.selectAll(JDBCTemplate.getConnection(), paging);
	}



	@Override
	public Paging getPaging(HttpServletRequest req) {

		//총 게시글 수 
		int totalCount = productDao.selectCntAll(JDBCTemplate.getConnection());

		//전달 파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if ( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}

		//	-> 알아야 할 필수 변수인 totalCount, curPage 알아냄 

		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);

		return paging;
	}




	//-----------------------------------------------------------------




	@Override
	public Product getProdno(HttpServletRequest req) {

		//전달파라미터를 저장할 객체 생성
		Product product = new Product();

		//전달파라미터 prodno 추출(파싱)
		String param = req.getParameter("prodno");
		if( null != param && !"".equals(param) ) { //전달파라미터가 null 또는 ""빈문자열이 아닐 때 처리 
			product.setProdno( Integer.parseInt(param));
		}

		return product;	
	}



	@Override
	public Product view(Product prodno) {
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//조회수 증가
		/*
		 * if( productDao.updateHit(conn, prodno) > 0 ) { JDBCTemplate.commit(conn); }
		 * else { JDBCTemplate.rollback(conn); }
		 */

		//게시글 조회
		Product product = productDao.selectProductByProdno(conn, prodno);

		//조회된 게시글 리턴
		return product;		
	}




	//-----------------------------------------------------------------



	
	@Override
	public void write(HttpServletRequest req) {
		//multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		//multipar형식이 아닐 경우 처리 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();

		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);

		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();

		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);

		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);

		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//게시글 정보 DTO객체
		Product product = new Product();

		//게시글 첨부파일 정보 DTO객체
		ProductFile productFile = new ProductFile();

		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) {
			FileItem item = iter.next();

			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}

			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) {

				//키(key) 추출하기
				String key = item.getFieldName();

				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				//key에 맞게 value를 DTO에 삽입하기
				if( "prodname".equals(key) ) {
					product.setProdname(value);
				}
				if( "prodprice".equals(key) ) {
					product.setProdprice(Integer.parseInt(value));
				}
				if( "prodcon".equals(key) ) {
					product.setProdcon(value);
				}

			} // if( item.isFormField() ) end



			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {

				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간

				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();

				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거

				} catch (Exception e) {
					e.printStackTrace();
				}

				//업로드된 파일의 정보를 DTO객체에 저장하기
				productFile.setOriginname(item.getName());
				productFile.setStoredname(rename);
				productFile.setFilesize((int)item.getSize());

			} // if( !item.isFormField() ) end

		} // while( iter.hasNext() ) end


		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();

		//게시글 번호 생성
		int prodno = productDao.selectNextProdno(conn);


		//게시글 번호 삽입
		product.setProdno(prodno);
		System.out.println(product.getProdno());	
		//작성자 ID 처리
		/*
		 * product.setProdno( (String) req.getSession().getAttribute("prodno") );
		 * 
		 * 
		 * if( boardDao.insert(conn, board) > 0 ) { JDBCTemplate.commit(conn); } else {
		 * JDBCTemplate.rollback(conn); }
		 */

		if( productDao.insert(conn, product) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		//첨부파일 정보 삽입
		if( productFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
			
			//게시글 번호 삽입 (FK)
			productFile.setProdno(prodno);
			System.out.println(productFile.getProdno());
			if( productDao.insertFile(conn, productFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}

		}
	}



	
	@Override
	public ProductFile viewFile(Product viewProduct) {
		return productDao.selectFile(JDBCTemplate.getConnection(), viewProduct);		
	}




	@Override
	public void update(HttpServletRequest req) {
		//multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
				
		//multipar형식이 아닐 경우 처리 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
				
		DiskFileItemFactory factory = new DiskFileItemFactory();
				
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);

		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
				
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);

		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
				
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
		}

		//게시글 정보 DTO객체
		Product product = new Product();
				
		//게시글 첨부파일 정보 DTO객체
		ProductFile productFile = new ProductFile();
			
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) {
			FileItem item = iter.next();
					
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
					
			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) {
						
				//키(key) 추출하기
				String key = item.getFieldName();
						
				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
						
				//key에 맞게 value를 DTO에 삽입하기
				if( "prodno".equals(key) ) {
					product.setProdno(Integer.parseInt(value));
				}
				if( "prodname".equals(key) ) {
					product.setProdname(value);
				}
				if( "prodprice".equals(key) ) {
					product.setProdprice(Integer.parseInt(value));
				}
				if( "prodcon".equals(key) ) {
					product.setProdcon(value);
				}
						
			} // if( item.isFormField() ) end
					
					
					
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
						
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간
						
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
						
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거
							
				} catch (Exception e) {
					e.printStackTrace();
				}
						
				//업로드된 파일의 정보를 DTO객체에 저장하기
				productFile.setOriginname(item.getName());
				productFile.setStoredname(rename);
				productFile.setFilesize((int)item.getSize());
						
			} // if( !item.isFormField() ) end
					
		} // while( iter.hasNext() ) end

				
				//DB연결 객체
				Connection conn = JDBCTemplate.getConnection();
				
				if( productDao.update(conn, product) > 0 ) {
					JDBCTemplate.commit(conn);
				} else {
					JDBCTemplate.rollback(conn);
				}

				
				//첨부파일 정보 삽입
				if( productFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
					
					//게시글 번호 삽입 (FK)
					productFile.setProdno(product.getProdno());
					
					if( productDao.insertFile(conn, productFile) > 0 ) {
						JDBCTemplate.commit(conn);
					} else {
						JDBCTemplate.rollback(conn);
					}
					
				}
		
	}

	


	@Override
	public void delete(Product product) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//첨부 파일 전부 삭제
		if(productDao.deleteFile(conn, product) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 삭제
		if(productDao.delete(conn, product) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}






}















