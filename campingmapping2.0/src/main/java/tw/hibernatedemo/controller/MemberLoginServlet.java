package tw.hibernatedemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.hibernatedemo.model.Member;
import tw.hibernatedemo.service.MemberLoginService;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		Map<String, String> errorMsgMap = new HashMap<String,String>();
		
		request.setAttribute("errorMsgMap", errorMsgMap);
	
		//這是跟使用者連線 跟hibernate連線無關
		HttpSession httpSession = request.getSession();
	
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		System.out.println("MemberLoginServlet的username為"+username);
		
		MemberLoginService service = new MemberLoginService();
//		System.out.println("進來了");
		Member tempMember = service.checkLogin(username, pwd);
		
//		System.out.println("check過");
		if (tempMember != null) {
			httpSession.setAttribute("loginMember", tempMember);
		}else {
			errorMsgMap.put("LoginError", "帳密錯誤，請重新輸入");
		}
	
		if (errorMsgMap.isEmpty()) {
			//轉到成功頁面		
			RequestDispatcher rs = request.getRequestDispatcher("LoginOK.jsp");
			rs.forward(request, response);
			System.out.println("登入");
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
			//回到Login頁面			

		}
		
	}

}
