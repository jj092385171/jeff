package T4_09._01_job.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet("/JobServletFindBeanByuID")
public class JobServletFindBeanByuID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMessage = new HashMap<>();
//		String str = request.getParameter("uID");
//		int uID = Integer.parseInt(str);
		JobServiceDAOImpl jsi = new JobServiceDAOImpl();
		try {
			String str = request.getParameter("uID");
			int uID = Integer.parseInt(str);
			List<JobBean> jobBean = jsi.findBeanByuID(uID);
			if (jobBean.size()==0) {
				errorMessage.put("uID", "無此會員ID,請重新輸入");
			}
			request.setAttribute("ErrorMsg", errorMessage);
			
		} catch (Exception e) {
			errorMessage.put("uID", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);
	
		
		
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/CRUD/select.jsp");
			rd.forward(request, response);
			return;
		}
		
//		request.setAttribute("jobBean", jobBean);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/CRUD/showSelect.jsp");
		rd.forward(request, response);
		return;
	
	}

}
