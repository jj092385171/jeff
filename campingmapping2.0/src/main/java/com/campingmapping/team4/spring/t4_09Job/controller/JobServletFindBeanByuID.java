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
@WebServlet("/JobServletFindBeanByuID")
public class JobServletFindBeanByuID extends HttpServlet {
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
			String str = request.getParameter("uID");
			int uID = Integer.parseInt(str);
			List<JobBean> jobBean = jsi.findBeanByuID(uID);
			try {						
						if (jobBean.size() == 0) {
							errorMessage.put("uID", "查無資料");
						}					
				request.setAttribute("ErrorMsg", errorMessage);
			} catch (Exception e) {
			}
		} catch (Exception e) {
			errorMessage.put("uID", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/select.jsp");
			rd.forward(request, response);
			return;
		}
		String str = request.getParameter("uID");
		int uID = Integer.parseInt(str);
		List<JobBean> jobBean = jsi.findBeanByuID(uID);
		request.setAttribute("jobBean", jobBean);
		RequestDispatcher rd = request.getRequestDispatcher("/t4_09job/job/JobModel/showSelect.jsp");
		rd.forward(request, response);
		return;

	}

}
