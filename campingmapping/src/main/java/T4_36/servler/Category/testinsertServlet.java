package T4_36.servler.Category;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_36.dao.CategoryDao;
import T4_36.dao.impl.CategoryDaoImpl;
import T4_36.entity.Category;

@MultipartConfig()
@WebServlet("/testinsertServlet.do")
public class testinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
//		String shoppingCartId = request.getParameter("shoppingCartId");
			int Pd_id = Integer.parseInt(request.getParameter("Pd_id"));
			String userID = request.getParameter("userID");
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String type = request.getParameter("type");
			String picture = request.getParameter("picture");
			int price = Integer.parseInt(request.getParameter("price"));
			int inventory = Integer.parseInt(request.getParameter("inventory"));
//			Date date = new Date(1345434534);
//			Date Pd_date = request.getParameter("Pd_date");
//			Date Pd_last_update = request.getParameter("Pd_last_update");
			CategoryDaoImpl cdaoImpl = new CategoryDaoImpl();
			Category bean = new Category(Pd_id, userID, name, title, content, 
					type, picture, price, inventory);
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
