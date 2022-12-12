package T4_36.servler.Category;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_36.entity.Category;
import T4_36.service.impl.CategoryServiceImpl;

@MultipartConfig()
@WebServlet("/CategoryImgSelectByPdid")
public class CategoryImgSelectByPdid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OutputStream os = null;
		InputStream is = null;
		Blob blob = null;
		try {
			String pdid = request.getParameter("pdid");
			int Pdid = Integer.parseInt(pdid);
			CategoryServiceImpl jsdi = new CategoryServiceImpl();
			Category category = jsdi.findImgByPdiD(Pdid);
			blob = category.getPdpicture();
			is = blob.getBinaryStream();
			os = response.getOutputStream();
			int len = 0;
			byte[] bytes = new byte[8000];
			while ((len = is.read(bytes)) != -1) {
			os.write(bytes, 0, len);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失敗");
		}finally {
			if (is != null) is.close();
            if (os != null) os.close();
		}
	}
}