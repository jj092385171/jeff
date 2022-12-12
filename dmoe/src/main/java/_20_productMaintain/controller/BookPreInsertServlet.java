package _20_productMaintain.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_listBooks.service.BookService;
import _03_listBooks.service.CompanyService;
import _03_listBooks.service.impl.BookServiceImpl;
import _03_listBooks.service.impl.CompanyServiceImpl;

@WebServlet("/_20_productMaintain/BookPreInsert.do")
public class BookPreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(BookPreInsertServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 準備新增書籍資料所需要的出版社與書籍類型的資料
		
		CompanyService companyService = new CompanyServiceImpl();
		String companyTag = companyService.getSelectTag("companyID", -1);
		log.info("新增書籍之前置作業之Controller: 開始, companyTag=" + companyTag);
		request.setAttribute("SelectCompanyTag", companyTag);

		// 本類別負責讀取資料庫內Book表格內某一頁的紀錄，並能新增紀錄、修改紀錄、刪除記錄等
		BookService bookService = new BookServiceImpl();
		String categoryTag = bookService.getCategoryTag("");
		log.info("新增書籍之前置作業之Controller, categoryTag=" + categoryTag);
		request.setAttribute("SelectCategoryTag", categoryTag);

		request.setAttribute("baBean", bookService);
		RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookInsert.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
