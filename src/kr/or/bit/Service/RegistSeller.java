package kr.or.bit.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;
import kr.or.bit.model.DAO.MemberDAO;
import kr.or.bit.model.DTO.SellerDTO;

public class RegistSeller implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		SellerDTO sellerDto = new SellerDTO();
		MemberDAO memberDao = new MemberDAO();
		String sellerId = request.getParameter("id");
		System.out.println("판매자등록(ID):"+sellerId);
		
		int result=0;		
   		String msg ="";   		
   		sellerDto.setId(request.getParameter("id"));
   		sellerDto.setSel_Email(request.getParameter("sel_Email"));
   		sellerDto.setSel_Regist_Num(Integer.parseInt(request.getParameter("Sel_Regist_Num")));
   		sellerDto.setSel_Account(request.getParameter("hp"));
   		sellerDto.setSel_Num(Integer.parseInt(request.getParameter("Sel_Num")));
   		
   		
   		try {
			result = memberDao.registSeller(sellerDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	
   		if(result>0){
   			//판매자등록성공
   			msg = "success";
   		
   		} else {
	   		//판매자등록실패
   			msg= "fail";
   		}
   		request.setAttribute("msg", msg);	   		
   		
   		forward.setRedirect(false);
   		forward.setPath("/WEB-INF/views/main.jsp");
   		
   		return forward;

		
	}
		
	
}
