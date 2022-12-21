package T4_11.servletProject.servler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_11.bean.InitiatingBean;
import T4_11.servletProject.dao.InitiatingDaoImpl;

@WebServlet("/select")
public class select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public select() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 
		InitiatingDaoImpl iDao = new InitiatingDaoImpl();
		List<InitiatingBean> view = iDao.selectAllInitiating();
		List<InitiatingBean> camparea = iDao.selectAllCamparea();
		List<InitiatingBean> postmember = iDao.selectAllMember();
		

		request.setAttribute("view",view);
		
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");
		String num = request.getParameter("initiatingnum");
		String member = request.getParameter("postmember");
		String area = request.getParameter("camparea");
		
		String sql = iDao.sqlCommand(startdate, enddate, num, member, area);
		List<InitiatingBean> view1 = iDao.selectInitiating(sql);
		

		
		request.setAttribute("camparea", camparea);
		request.setAttribute("postmember", postmember);
		request.setAttribute("view2",view1);
		RequestDispatcher rd = request.getRequestDispatcher("/T4_11/Team.jsp");
		rd.forward(request, response);
	}

}
