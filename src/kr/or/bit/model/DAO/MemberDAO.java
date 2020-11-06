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
	//회원가입
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
			conn.close();
		}
		
		return result;
	}
	
	//아이디체크
	public String IdCheck(String id)throws Exception {
		String check= null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				conn = ds.getConnection();
				String sql = "select id from MEMBER where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
		
				rs = pstmt.executeQuery();				
				if(rs.next()) { 
					check = "false"; //아이디가 중복될때
				}
				else {
					check = "true"; //아이디가 없을때 
				}if(id.equals("")){
					check ="empty"; //id가 빈값일때 
					
				}
				
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			DB_Close.close(rs);
			DB_Close.close(pstmt);			
			conn.close();
		}
		return check;
	}
	
	
	
	

	
	
}
