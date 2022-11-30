package T4_01.ch01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rs")
public class registerServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	System.out.println("u="+username);
	System.out.println("p="+password);
	
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter writer = resp.getWriter();
	writer.println("註冊成功");
	
	
	}

}
