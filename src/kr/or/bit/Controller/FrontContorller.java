package kr.or.bit.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.Action.Action;
import kr.or.bit.Action.ActionForward;
import kr.or.bit.Service.SignUp;



/**
 * Servlet implementation class FrontContorller
 */
@WebServlet("/*.do")
public class FrontContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontContorller() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());

		ActionForward forward = new ActionForward();
		Action action = null;
		
		//회원가입페이지
		if (cmdURI.equals("/signUpPage.do")) {
			forward.setRedirect(false);
			forward.setPath("/views/SignUpPage.jsp");
		}

		//회원가입요청
		else if (cmdURI.equals("/signUp.do")) {
			action = new SignUp();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
