package kr.or.bit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.model.DTO.MemberDTO;
import kr.or.bit.model.DTO.ProductDTO;
import kr.or.bit.model.DTO.SellerDTO;
import kr.or.bit.utils.DB_Close;

public class ProductDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	DataSource ds = null;
	Connection conn = null;

	public ProductDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");// java:comp/env/ + name
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//장바구니담기
	public int addCart(ProductDTO product) throws Exception {
		ProductDTO productDto = null;
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT P_NUM"
					+ " FROM PRODUCT WHERE P_NUM=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				
	
			} 
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		
		}
		return result;
	}
}
