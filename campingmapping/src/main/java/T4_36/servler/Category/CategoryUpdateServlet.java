package T4_36.servler.Category;

import T4_36.dao.CategoryDao;
import T4_36.dao.impl.CategoryDaoImpl;
import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;
import utils.ImageUtil;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@WebServlet("/_20_productMaintain/BookUpdate.do")
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
// 更新書籍資料，邏輯上與新增書籍資料類似
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(CategoryUpdateServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		Category Cg;
		
		Category category = (Category) req.getAttribute("category");

		CategoryService categoryService = new CategoryServiceImpl();
		CategoryService.update(category, 0);
		log.info("更新產品之Controller, 開始");

		HttpSession session = req.getSession();
		if (!session.isNew()) {
			Cg = (Category) session.getAttribute("bean");
		} else {
			Cg = new Category();
		}
		String pageNo = "1";
		Map<String, String> errorMsgs = new HashMap<String, String>();
		Map<String, String> successMsgs = new HashMap<String, String>();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setAttribute("ErrMsg", errorMsgs);
		session.setAttribute("successMsg", successMsgs);
		try {
			String name = "";
			String title = "";
			String type = "";
			String priceStr = "";
			int price = 0;
			int inventory = 0;
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
			Collection<Part> parts = req.getParts();
			// GlobalService.exploreParts(parts, request);

			if (parts != null) { // 如果這是一個上傳資料的表單
				for (Part p : parts) {
					String fldName = p.getName();
					String value = req.getParameter(fldName);
					if (p.getContentType() == null) {
						if (fldName.equals("name")) {
							name = value;
							Cg.setName(name);
							if (value == null || name.trim().length() == 0) {
								errorMsgs.put("errTitle", "必須輸入產品名稱");
							} else {
								req.setAttribute("name", name);
							}
						} else if (fldName.equals("title")) {
							title = value;
							Cg.setTitle(title);
							if (title == null || title.trim().length() == 0) {
								errorMsgs.put("errAuthor", "必須輸入品牌");
							} else {
								req.setAttribute("title", title);
							}
						} else if (fldName.equals("price")) {
							priceStr = value;
							priceStr = priceStr.trim();
							Cg.setPriceStr(priceStr);
							if (priceStr == null || priceStr.trim().length() == 0) {
								errorMsgs.put("errPrice", "必須輸入價格");
							} else {
								try {
									price = Integer.parseInt(priceStr);
								} catch (NumberFormatException e) {
									errorMsgs.put("errPrice", "價格必須是數值");
								}
							}
							req.setAttribute("price", priceStr);
						} else if (fldName.equals("type")) {
							type = value;
							Cg.setType(type);
							if (type == null || type.trim().length() == 0) {
								errorMsgs.put("errtitle", "必須輸入產品類型");
							} else {
								req.setAttribute("type", type);
							}
						} 

					} 
				}
			} else {
				errorMsgs.put("errTitle", "此表單不是上傳檔案的表單");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher rd = req.getRequestDispatcher("/_20_productMaintain/BookUpdate.jsp");
				rd.forward(req, resp);
				return;
			}

			CategoryDao categoryDao = new CategoryDaoImpl();

			Blob blob = null;
			if (sizeInBytes != -1) {
				blob = ImageUtil.fileToBlob(is, sizeInBytes);
			}
			Category newBean = new Category(Cg.getPd_id(), title, author, price, 1.0, fileName, bookNo, blob, cId,
					category, mimeType);
			CategoryService.update(newBean, sizeInBytes);
			RequestDispatcher rd = req
					.getRequestDispatcher("/_20_productMaintain/DisplayPageProducts?pageNo=" + pageNo);
			rd.forward(req, resp);
			log.info("更新書籍之Controller, 成功，newBean=" + newBean);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			errorMsgs.put("errDBMessage", e.getMessage());
			RequestDispatcher rd = req.getRequestDispatcher("/_20_productMaintain/BookUpdate.jsp");
			rd.forward(req, resp);
		}
	}

}