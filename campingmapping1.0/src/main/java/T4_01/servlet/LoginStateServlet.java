package T4_01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T4_01.beans.License;

@WebServlet("/LoginStateServlet")
public class LoginStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void loginstate(ServletRequest req, ServletResponse resp)
			throws IOException, ServletException {
		PrintWriter writer = resp.getWriter();
		HttpSession session = ((HttpServletRequest) req).getSession();
		License loginToken = (License) session.getAttribute("license");
		if (loginToken == null) {
			// 已經登入
			writer.println(1);
		} else {
			writer.println(0);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		loginstate(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		loginstate(request, response);
	}

}
