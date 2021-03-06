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
import kr.or.bit.model.DTO.SellerDTO;
import kr.or.bit.utils.AES256Util;
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

	/**
	 * 회원가입
	 * @param member테이블에 회원 데이터 저장(비밀번호암호화 1차로 단방향(SHA512)암호화 후 양방향(AES)암호화 처리(테스트용))
	 * @return 정상적으로 처리되면 1값 리턴
	 * @throws Exception
	 */
	public int signUp(MemberDTO member) throws Exception {
		AES256Util aes = new AES256Util();
		String sql = "INSERT INTO  MEMBER (id, pwd, name, hp, address, card_num) " + "VALUES (?, ?, ?, ?, ?, ?)";

		int result = 0;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());	
			String pw = member.getPwd();
			pstmt.setString(2, aes.encrypt(member.getPwd()));
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getHp());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getCard());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원등록실패: " + e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		}
		
		System.out.println("SHA:"+member.getPwd());	
		System.out.println("aes enc:"+aes.encrypt(member.getPwd()));
		System.out.println("aes dec:"+aes.decrypt(aes.encrypt(member.getPwd())));
		return result;
	}
	//판매자 등록
	public int registSeller(SellerDTO seller) throws Exception {
		SellerDTO sellerdto = null;
		String sql = "INSERT INTO SELLER (id, email, RegistNum, account) " + "VALUES (?, ?, ?, ?)";

		int result = 0;

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seller.getId());
			pstmt.setString(2, seller.getSel_Email());
			pstmt.setInt(3, seller.getSel_Regist_Num());
			pstmt.setString(4, seller.getSel_Account());
		
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("판매자등록실패: " + e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		}

		return result;
	}


	// 아이디체크
	public String idCheck(String id) throws Exception {
		String check = null;		
		String sql = "select id from MEMBER where id=?";
		try {
			conn = ds.getConnection();			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = "fail"; // 아이디가 중복될때
			} else {
				check = "success"; // 아이디가 없을때
			}
			if (id.equals("")) {
				check = "empty"; // id가 빈값일때

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		}
		return check;
	}
	//비밀번호 확인
	public String pwdCheck(String pwd) throws Exception {
		String check = null;	
		String sql = "select pwd from MEMBER where id=?";
		String pw;
		
		try {
			conn = ds.getConnection();		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				pw=rs.getString("pwd");
				
				if(pw.equals(pwd)) {
					check = "success";//  success
				}else {
					check = "fail";	//pwd x
				}
			}else {
				check = "fail2";//회원이 x
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		}
		return check;
	}
	//회원정보불러오기(아이디)
	public MemberDTO memberSelect(String id)throws Exception {		
		MemberDTO memberDTO = null;
	
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT id, pwd, name, hp, address, card FROM MEMBER WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				
				memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setHp(rs.getString("hp"));
				memberDTO.setAddress(rs.getString("address"));
				memberDTO.setCard(rs.getString("card"));
			} 
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			conn.close();
		
		}
		return memberDTO;
	}
	//회원정보수정
	public int modifyProfile(MemberDTO member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		try {
			conn = ds.getConnection();
			String sql = "UPDATE MEMBER SET pwd = ? , name = ? , hp = ? , address = ? , card = ? WHERE id = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getHp());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getCard());
			
			result =pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}finally{
			DB_Close.close(pstmt);
			conn.close();
		}
	
		return result;
	}
	
	
	
	

	
	
}
