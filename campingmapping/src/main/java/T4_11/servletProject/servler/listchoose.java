package T4_11.servletProject.servler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listchoose")
public class listchoose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public listchoose() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String list = request.getParameter("item");
		switch (list) {
		case "揪團":
			RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Test.jsp");
			rd.forward(request, response);
			break;

		case "申請":
			
			break;
			
		case "留言":
		}
	}

}
