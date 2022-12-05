package _20_productMaintain.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.GlobalService;
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;
import _03_listBooks.service.impl.BookServiceImpl;
@WebServlet("/_20_productMaintain/BookUpdate.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
// 更新書籍資料，邏輯上與新增書籍資料類似
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(BookUpdateServlet.class);
	
	BookBean bb ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info("更新書籍之Controller, 開始");
		
		HttpSession session = request.getSession();
		if (!session.isNew())  {
			bb = (BookBean) session.getAttribute("bean");
		} else {
			bb = new BookBean();
		}
		String pageNo = "1";
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		try {
			String title = "";
			String author = "";
			String priceStr = "";
			double price = 0;
			String bookNo = "";
			String companyID = "";
			String category = "";
			String fileName = "";
			String mimeType = "";
			long sizeInBytes = 0;
			InputStream is = null;
			// request.getParts()方法傳回一個由javax.servlet.http.Part物件所組成的Collection
			// javax.servlet.http.Part: 代表上傳到Server的，可以是正常的表單資料(form data)，
			// 也可以上傳的檔案。
			// Part介面可以: 
			// 1. 傳回欄位的名稱(<input>的name屬性)、大小、ContentType
			// 2. 每個Part的Header
			// 3. 刪除Part
			// 4. 將Part寫入硬碟
			Collection<Part> parts = request.getParts();
			//GlobalService.exploreParts(parts, request);
			
			if (parts != null) {   // 如果這是一個上傳資料的表單				
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {
						if (fldName.equals("title")) {
							title = value;
							bb.setTitle(title);
							if (value == null || title.trim().length() == 0) {
								errorMsgs.put("errTitle", "必須輸入書名");
							} else {
								request.setAttribute("title", title);
							}
						} else if (fldName.equals("author")) {
							author = value;
							bb.setAuthor(author);
							if (author == null || author.trim().length() == 0) {
								errorMsgs.put("errAuthor", "必須輸入作者");
							} else {
								request.setAttribute("author", author);
							}
						} else if (fldName.equals("price")) {
							priceStr = value;
							priceStr = priceStr.trim();
							bb.setPriceStr(priceStr);
							if (priceStr == null
									|| priceStr.trim().length() == 0) {
								errorMsgs.put("errPrice", "必須輸入價格");
							} else {
								try {
									price = Double.parseDouble(priceStr);
								} catch (NumberFormatException e) {
									errorMsgs.put("errPrice", "價格必須是數值");
								}
							}
							request.setAttribute("price", priceStr);
						} else if (fldName.equals("bookNo")) {
							bookNo = value;
							bb.setBookNo(bookNo);
							if (bookNo == null || bookNo.trim().length() == 0) {
								errorMsgs.put("errBookNo", "必須輸入書號");
							} else {
								request.setAttribute("bookNo", bookNo);
							}
						} else if (fldName.equals("companyID")) {
							companyID = value;
							if (companyID == null
									|| companyID.trim().length() == 0) {
								errorMsgs.put("errCompanyID", "必須輸入出版社");
							}
							//request.setAttribute("cID", companyID);
						} else if (fldName.equals("pageNo")){
							pageNo = value;
						} else if (fldName.equals("category")) {
							category = value;
							;
							if (category == null || category.trim().length() == 0) {
								errorMsgs.put("errCategory", "必須輸入類型");
							}
							request.setAttribute("category", category);
						}


					} else {
						fileName = GlobalService.getFileName(p); // 由變數 p 中取出檔案名稱
						if (fileName != null && fileName.trim().length() > 0) {
							fileName = GlobalService.adjustFileName(fileName, GlobalService.IMAGE_FILENAME_LENGTH);
							mimeType = getServletContext().getMimeType(fileName);
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						} else {
							sizeInBytes = -1;
						}
					} 
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}
			if (!errorMsgs.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookUpdate.jsp");
			   rd.forward(request, response);
			   return;
			} 
			
			BookService bookService = new BookServiceImpl();
			
			int cId  = Integer.parseInt(companyID);
			
			Blob blob = null;
			if (sizeInBytes != -1){
				blob = GlobalService.fileToBlob(is, sizeInBytes);
			}
			BookBean newBean = new BookBean(bb.getBookId(), title, 
					author, price, 1.0, fileName, bookNo, blob, cId, category, mimeType);
			bookService.updateBook(newBean, sizeInBytes); 
			RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/DisplayPageProducts?pageNo=" + pageNo);
			rd.forward(request, response);
			log.info("更新書籍之Controller, 成功，newBean=" + newBean);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("errDBMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/_20_productMaintain/BookUpdate.jsp");
			rd.forward(request, response);
		}
	}

}
