package T4_09._01_job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import T4_09._01_job.service.JobServiceDAOImpl;

@MultipartConfig()
@WebServlet("/JobServletDelete")
public class JobServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rackID = request.getParameter("de");
		int parseID = Integer.parseInt(rackID);
		JobServiceDAOImpl jsdi = new JobServiceDAOImpl();
		jsdi.deleteJob(parseID);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/deleteSucces.jsp");
		rd.forward(request, response);
		return;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

}
