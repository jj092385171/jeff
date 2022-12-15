package T4_09._01_job.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_09._01_job.model.JobBean;
import T4_09._01_job.service.JobServiceDAOImpl;

 
@WebServlet("/JobServletShowAll")
public class JobServletShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		JobServiceDAOImpl jobServiceImpl = new JobServiceDAOImpl();		
		List<JobBean> showAllJob = jobServiceImpl.showAllJob();
		request.setAttribute("showAllJob", showAllJob);		
		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/showAll.jsp");
		rd.forward(request, response);
		return;
	}

}
