package com.campingmapping.team4.spring.t4_09Job.controller;

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

import com.campingmapping.team4.spring.t4_09Job.model.entity.JobBean;
import com.campingmapping.team4.spring.t4_09Job.model.service.JobServiceImpl;

@MultipartConfig()
@WebServlet("/JobServletSelectLike")
public class JobServletSelectLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Map<String, String> errorMessage = new HashMap<>();
		JobServiceImpl jsi = new JobServiceImpl();
		try {
			String st = request.getParameter("job");
			List<JobBean> jobBean = jsi.findJobByJobLike(st);
			if (jobBean.size()==0) {
				errorMessage.put("job", "查無資料");
			}
			request.setAttribute("ErrorMsg", errorMessage);
			request.setAttribute("jobBean", jobBean);
		} catch (Exception e) {
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/select.jsp");
			rd.forward(request, response);
			return;
		}
		String st = request.getParameter("job");
		List<JobBean> jobBean = jsi.findJobByJobLike(st);
		request.setAttribute("jobBean", jobBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/showSelect.jsp");
		rd.forward(request, response);
		return;

	}

}
