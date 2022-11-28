package servlerProject.servler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlerProject.entity.Admin;
import servlerProject.service.impl.AdminServiceImpl;

@WebServlet("/showallcontroller")
public class showallcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminServiceImpl adminService = new AdminServiceImpl();
		
		List<Admin> adminList = adminService.showAllAdmin();
		
	
		request.setAttribute("admins", adminList);
		
		request.getRequestDispatcher("/showall").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
