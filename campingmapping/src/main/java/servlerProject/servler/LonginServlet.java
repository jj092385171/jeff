package servlerProject.servler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlerProject.entity.Admin;
import servlerProject.service.AdminService;
import servlerProject.service.impl.AdminServiceImpl;


@WebServlet("/login")
public class LonginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

//		1.拿資料
		String UID = req.getParameter("UID");
		String password = req.getParameter("password");
//		2.業務邏輯
		AdminService adminService = new AdminServiceImpl();
		Admin admin = adminService.login(Integer.parseInt(UID), password);
//		3.處理結果
		PrintWriter printWriter = resp.getWriter();
		if (admin != null) {
//			成功
			printWriter.println("成功");
		} else {
//			失敗
			printWriter.println("失敗");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String UID = req.getParameter("UID");
		String password = req.getParameter("password");
		System.out.println("ulogin="+UID);
		System.out.println("plogin="+password);
		doGet(req, resp);
	}
}
