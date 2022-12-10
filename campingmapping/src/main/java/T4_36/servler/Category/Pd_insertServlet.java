package T4_36.servler.Category;

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

import T4_36.dao.impl.CategoryDaoImpl;
import T4_36.entity.Category;
import T4_36.service.CategoryService;
import T4_36.service.impl.CategoryServiceImpl;
import utils.ImageUtil;

@MultipartConfig()
@WebServlet("/Pd_insertServlet.do")
public class Pd_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
//		String shoppingCartId = request.getParameter("shoppingCartId");
//			int Pd_id = Integer.parseInt(request.getParameter("Pd_id"));
			String userID = request.getParameter("userID");
			String Pd_name = request.getParameter("Pd_name");
			String Pd_title = request.getParameter("Pd_title");
			String Pd_content = request.getParameter("Pd_content");
			String Pd_type = request.getParameter("Pd_type");
			int Pd_price = Integer.parseInt(request.getParameter("Pd_price"));
			int Pd_inventory = Integer.parseInt(request.getParameter("Pd_inventory"));
//			Date date = new Date(1345434534);
			Date datePd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("Pd_date"));
			Date Pd_date = datePd;
			Date datelastup = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("Pd_last_update"));
			Date Pd_last_update = datelastup;

			//圖片
			Part part = request.getPart("picture");
			long sizeInBytes = part.getSize();
			InputStream is = part.getInputStream();
			Blob Pd_picture = ImageUtil.fileToBlob(is, sizeInBytes);


			CategoryService categoryService = new CategoryServiceImpl();
			Category bean = new Category( userID, Pd_name, Pd_title, Pd_content, 
					Pd_type, Pd_picture,  Pd_price, Pd_inventory,Pd_date,Pd_last_update);

			categoryService.create(bean);

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/T4_36/html5up-editorial/Pd_ok.jsp");
//		RequestDispatcher rd = 
//     			request.getRequestDispatcher("/Cart/NewFile.jsp");
//		
//		rd.forward(request, response);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}