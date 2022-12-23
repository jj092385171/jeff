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
@MultipartConfig()
@WebServlet("/JobServletSelectLike")
public class JobServletSelectLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String st = request.getParameter("job");
	JobServiceDAOImpl jsi = new JobServiceDAOImpl();
	List<JobBean> jobBean = jsi.findJobByJobLike(st);

	request.setAttribute("jobBean", jobBean);
	RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/JobModel/showSelect.jsp");
	rd.forward(request, response);
	return;
	
	
	
	}

}
