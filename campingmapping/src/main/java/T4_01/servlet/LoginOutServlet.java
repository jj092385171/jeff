package T4_01.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("limits");
			session.removeAttribute("member");
			session.removeAttribute("license");
			session.invalidate();			
			
			resp.sendRedirect("/campingmapping/index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
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
