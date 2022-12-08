package T4_01.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ttttt")
public class ttttt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
System.out.println("get");	
String parameter = request.getParameter("t");
String parameter2 = request.getParameter("tt");
System.out.println(parameter);
System.out.println(parameter2);
request.setAttribute("re", 456);
request.getRequestDispatcher("/T4_01/test.html").forward(request, response);
return;
}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
