package T4_36.servler.Category;

import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 更新產品資料，邏輯上與新增資料類似
@MultipartConfig()
@WebServlet("/CategoryUpdateServlet.do")
public class CategoryUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(CategoryUpdateServlet.class);

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		log.info("更新產品之Controller, 開始");
		try {
			req.setCharacterEncoding("UTF-8");
			String userID = req.getParameter("userID");
			String Pdname = req.getParameter("Pdname");
			String Pdtitle = req.getParameter("Pdtitle");
			String Pdcontent = req.getParameter("Pdcontent");
			String Pdtype = req.getParameter("Pdtype");
			int Pdprice = Integer.parseInt(req.getParameter("Pdprice"));
			int Pdinventory = Integer.parseInt(req.getParameter("Pdinventory"));

			Date datelastup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(req.getParameter("Pdlastupdate"));
			Date Pdlastupdate = datelastup;
			Integer Pdid = Integer.parseInt(req.getParameter("Pdid"));

			CategoryService categoryService = new CategoryServiceImpl();
			Category bean = new Category(Pdid, userID, Pdname, Pdtitle, Pdcontent, Pdtype, Pdprice, Pdinventory,
					Pdlastupdate);

			categoryService.update(bean);

			String contextPath = req.getContextPath();
			resp.sendRedirect(contextPath + "/T4_36/html5up-editorial/Pd_ok.jsp");
			log.info("更新產品之Controller, 成功，newBean=" + bean);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}

}