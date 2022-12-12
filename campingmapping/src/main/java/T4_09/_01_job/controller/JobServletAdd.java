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
		Map<String, String> errorMessage = new HashMap<>();
		JobServiceDAOImpl jobServiceImpl = new JobServiceDAOImpl();
		JobBean jobBean = new JobBean();

		// 驗證會員id輸入格式
		try {
			Integer uID = Integer.parseInt(request.getParameter("id"));
			jobBean.setuID(uID);
		} catch (Exception e) {
			errorMessage.put("id", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		// 驗證刊登編號是否重複
		Integer rackID = Integer.parseInt(request.getParameter("rackID"));
		JobBean findBeanByRackID = jobServiceImpl.findBeanByRackID(rackID);
		if (findBeanByRackID.getRackID() != 0) {
			errorMessage.put("rackID", "編號重複,新增失敗");
		}
		request.setAttribute("ErrorMsg", errorMessage);
		jobBean.setRackID(rackID);

		String job = request.getParameter("job");
		jobBean.setJob(job);
		String salary = request.getParameter("salary");
		jobBean.setSalary(salary);

		// 驗證人數輸入格式
		try {
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			jobBean.setuID(quantity);

		} catch (Exception e) {
			errorMessage.put("quantity", "輸入格式錯誤");
		}
		request.setAttribute("ErrorMsg", errorMessage);

		String place = request.getParameter("place");
		jobBean.setPlace(place);
		String time = request.getParameter("time");
		jobBean.setTime(time);
		String date = request.getParameter("date");
		jobBean.setDate(date);
		String remark = request.getParameter("remark");
		jobBean.setRemark(remark);

		// 轉日期格式
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackUp(sd.parse(request.getParameter("rackUp")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 轉日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jobBean.setRackDown(sdf.parse(request.getParameter("rackDown")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// 處理照片格式
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
