package kr.or.bit.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;
import kr.or.bit.model.DAO.MemberDAO;
import kr.or.bit.model.DTO.MemberDTO;


public class SignIn implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO memberdao = null;
		ActionForward forward = null;
		MemberDTO memberdto = null;		
		String userId = request.getParameter("id");
		String Pwd = request.getParameter("pwd");
	
	
		try {
			memberdao = new MemberDAO();
			System.out.println(userId+":"+Pwd+"(체크)");
			String result = memberdao.idCheck(userId);
			String result2 = memberdao.pwdCheck(Pwd);
			System.out.println("result:"+result+"/"+"result2:"+result2);
			if(result.equals("fail")) { //아이디가 있을때
				if(result2.equals("sucess")) {
					System.out.println("로그인성공");
					result="success";
				}

			}else {
				System.out.println("로그인실패");
			
			}
			
			request.setAttribute("result", result);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setPath("index.jsp");
		return forward;
	}

}
