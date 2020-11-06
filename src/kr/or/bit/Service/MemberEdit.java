package kr.or.bit.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;

public class MemberEdit implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
	ActionForward forward = new ActionForward();
	forward.setPath("/WEB-INF/views/어딘가.jsp");

	return forward;
	}
	
}
