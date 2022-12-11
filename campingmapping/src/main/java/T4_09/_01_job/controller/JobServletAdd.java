package T4_09._01_job.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

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
@WebServlet("/T4_09/JobServletAdd")
public class JobServletAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		JobServiceDAOImpl jobServiceImpl = new JobServiceDAOImpl();
		JobBean jobBean = new JobBean();

		Integer uID = Integer.parseInt(request.getParameter("id"));
		jobBean.setuID(uID);

		Map<String, String> errorMessage = new HashMap<>();
		Integer rackID = Integer.parseInt(request.getParameter("rackID"));
		JobBean findBeanByRackID = jobServiceImpl.findBeanByRackID(rackID);
		System.out.println(findBeanByRackID);
		if (findBeanByRackID != null) {
			System.out.println("111111");
			errorMessage.put("rackID", "編號重複,新增失敗");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		jobBean.setRackID(rackID);
		String job = request.getParameter("job");
		jobBean.setJob(job);
		String salary = request.getParameter("salary");
		jobBean.setSalary(salary);
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		jobBean.setQuantity(quantity);
		String place = request.getParameter("place");
		jobBean.setPlace(place);
		String time = request.getParameter("time");
		jobBean.setTime(time);
		String date = request.getParameter("date");
		jobBean.setDate(date);
		String remark = request.getParameter("remark");
		jobBean.setRemark(remark);

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackUp(sd.parse(request.getParameter("rackUp")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackDown(sdf.parse(request.getParameter("rackDown")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		InputStream in = request.getPart("img").getInputStream();
		long size = request.getPart("img").getSize();
		try {
			Blob image = jobServiceImpl.fileToBlob(in, size);
			jobBean.setImg(image);
		} catch (Exception e) {
		}

		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/CRUD/insert.jsp");
			rd.forward(request, response);
			return;
		}

		jobServiceImpl.addJob(jobBean);

		RequestDispatcher rd = request.getRequestDispatcher("/T4_09/job/CRUD/addSuccess.jsp");
		rd.forward(request, response);
		return;
	}

}
