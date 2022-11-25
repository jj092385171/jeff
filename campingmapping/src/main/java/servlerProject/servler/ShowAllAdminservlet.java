package servlerProject.servler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlerProject.entity.Admin;
import servlerProject.service.impl.AdminServiceImpl;

@WebServlet("/showall")
public class ShowAllAdminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		AdminServiceImpl adminServiceImpl = new AdminServiceImpl();
		List<Admin> adminList = adminServiceImpl.showAllAdmin();
		PrintWriter writer = resp.getWriter();
		if (adminList!=null) {
			adminList.forEach(admins-> writer.println(admins.toString()+"<br>"));		
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
