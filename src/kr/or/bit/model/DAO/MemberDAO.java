package kr.or.bit.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.bit.model.DTO.MemberDTO;
import kr.or.bit.utils.DB_Close;

public class MemberDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	DataSource ds = null;
	Connection conn = null;
	
	public MemberDAO() {
		try {
			Context context = new InitialContext(); 
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");// java:comp/env/ + name
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int signUp(MemberDTO member)throws Exception{
		String sql="INSERT INTO  MEMBER (id, pwd, name, hp, address, card) " + 
				"VALUES (?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		
		try{
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getHp());
			pstmt.setString(5, member.getAddress());		
			pstmt.setString(6, member.getCard());
			
			result = pstmt.executeUpdate();
			

		}catch(Exception e){
			System.out.println("회원등록실패: " + e.getMessage());			
		}finally{
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			DB_Close.close(stmt);
			conn.close();
		}
		
		return result;
	}
	
	
	
	

	
	
}
