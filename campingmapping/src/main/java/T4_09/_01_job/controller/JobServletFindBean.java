package T4_09._01_job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_09._01_job.model.JobBean;
import T4_09._01_job.service.JobServiceDAOImpl;
@MultipartConfig()
@WebServlet("/JobServletFindBean")
public class JobServletFindBean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String rackID = request.getParameter("up");
		int rint = Integer.parseInt(rackID);
		JobServiceDAOImpl jsi = new JobServiceDAOImpl();
		JobBean JobBean = jsi.findBeanByRackID(rint);
//		System.out.println(JobBean);
		request.setAttribute("JobBean", JobBean);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/CRUD/update.jsp");
		rd.forward(request, response);
		return;
	}

}
