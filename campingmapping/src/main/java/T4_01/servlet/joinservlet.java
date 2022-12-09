package T4_01.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class joinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String birthday = req.getParameter("birthday");
		System.out.println(account);
		System.out.println(password);
		System.out.println(email);
		System.out.println(birthday);
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
