package T4_01.servlerProject.servler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_01.servlerProject.entity.Admin;


@WebServlet("/teatQ")
public class teatQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		@SuppressWarnings("unchecked")
		List<Admin> adminList = (List<Admin>) request.getAttribute("admins");
		
		PrintWriter writer = response.getWriter();
		if (adminList!=null) {
			adminList.forEach(admins-> writer.println(admins.toString()+"<br>"));		
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
