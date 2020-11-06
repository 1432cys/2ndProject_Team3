package kr.or.bit.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;
import kr.or.bit.model.DAO.MemberDAO;

public class IdCheck implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		String userId = request.getParameter("id");
		
		MemberDAO memberdao = null;
		try {
			memberdao = new MemberDAO();
	
			String result = memberdao.IdCheck(userId);
	
			if(result.equals("false")) { //아이디가 있을때
				result = "false";

			}
			if(result.equals("true")) { //아이디가 없을때
				result = "true";

			}if(result.equals("empty")) { //아이디가 빈값일때
				result = "empty";

			}
			request.setAttribute("result", result);
			forward = new ActionForward();
			forward.setPath("/WEB-INF/views/signUPage.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
