package kr.or.bit.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;
import kr.or.bit.model.DAO.MemberDAO;
import kr.or.bit.model.DAO.ProductDAO;
import kr.or.bit.model.DTO.ProductDTO;
//생각좀해봐야할듯
public class AddCart implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		int P_NUM = Integer.parseInt(request.getParameter("P_NUM"));		
		String id = request.getParameter("id");
		int O_AMOUNT = Integer.parseInt(request.getParameter("O_AMOUNT"));
		
		ProductDAO productDao = null;
		
		try {
			productDao = new ProductDAO();
	
			String result = productDao.addCart(id);
			
	
			
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/PurchasePage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}	
	
}
