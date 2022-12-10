package T4_01.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_01.service.impl.JoinServiceImpl;

@WebServlet("/join")
public class joinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String birthday = req.getParameter("birthday");
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
//		String remoteAddr = req.getRemoteAddr();
		if (ipAddress == null || "".equals(ipAddress)) {
		ipAddress = req.getRemoteAddr();
		}		
		JoinServiceImpl joinServiceImpl = new JoinServiceImpl();
		int joinNewMember = joinServiceImpl.joinNewMember(account, password, email, birthday, ipAddress);
//		System.out.println(account);
//		System.out.println(password);
//		System.out.println(email);
//		System.out.println(birthday);
//		System.out.println(ipAddress);
//		System.out.println(remoteAddr);
		if (joinNewMember==1) {
			System.out.println("成功");
		}else {
			System.out.println("失敗");
		}



	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
