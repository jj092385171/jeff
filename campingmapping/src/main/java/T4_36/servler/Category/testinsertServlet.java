package T4_36.servler.Category;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_36.dao.impl.CategoryDaoImpl;
import T4_36.entity.Category;
import utils.ImageUtil;

@MultipartConfig()
@WebServlet("/testinsertServlet.do")
public class testinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
//		String shoppingCartId = request.getParameter("shoppingCartId");
//			int Pd_id = Integer.parseInt(request.getParameter("Pd_id"));
			String userID = request.getParameter("userID");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String type = request.getParameter("type");
			Blob picture = request.getParameter("picture");
			String picture_name = request.getParameter("picture_name");
			int price = Integer.parseInt(request.getParameter("price"));
			int inventory = Integer.parseInt(request.getParameter("inventory"));
//			Date date = new Date(1345434534);
			Date datePd = new Date(Long.parseLong(request.getParameter("Pd_date")));
			Date Pd_date = datePd;
			Date datelastup = new Date(Long.parseLong(request.getParameter("Pd_last_update")));
			Date Pd_last_update = datelastup;
			CategoryDaoImpl cdaoImpl = new CategoryDaoImpl();
			Category bean = new Category( userID, name, title, content, 
					type, picture, picture_name, price, inventory,Pd_date,Pd_last_update);
//					,Pd_date, Pd_last_update

			try {
				cdaoImpl.inserttest(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/T4_36/test2.jsp");
//		RequestDispatcher rd = 
//     			request.getRequestDispatcher("/Cart/NewFile.jsp");
//		
//		rd.forward(request, response);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
