package com.campingmapping.team4.spring.t4_36Shop.controller.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;
import com.campingmapping.team4.spring.t4_36Shop.model.service.CategoryService;
import com.campingmapping.team4.spring.t4_36Shop.model.service.impl.CategoryServiceImpl;

import util.ImageUtil;


@MultipartConfig()
@WebServlet("/Pd_insertServlet.do")
public class Pd_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			String userID = request.getParameter("userID");
			String Pdname = request.getParameter("Pdname");
			String Pdtitle = request.getParameter("Pdtitle");
			String Pdcontent = request.getParameter("Pdcontent");
			String Pdtype = request.getParameter("Pdtype");
			int Pdprice = Integer.parseInt(request.getParameter("Pdprice"));
			int Pdinventory = Integer.parseInt(request.getParameter("Pdinventory"));

			Date datePd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("Pddate"));
			Date Pddate = datePd;
			Date datelastup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("Pdlastupdate"));
			Date Pdlastupdate = datelastup;

			// 圖片
			Part part = request.getPart("picture");
			long sizeInBytes = part.getSize();
			InputStream is = part.getInputStream();
			Blob Pdpicture = ImageUtil.fileToBlob(is, sizeInBytes);

			CategoryService categoryService = new CategoryServiceImpl();
			Category bean = new Category(null,userID, Pdname, Pdtitle, Pdcontent, Pdtype, Pdpicture, Pdprice, Pdinventory,
					Pddate, Pdlastupdate);

			categoryService.create(bean);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/T4_36/html5up-editorial/Pd_ok.jsp");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

}