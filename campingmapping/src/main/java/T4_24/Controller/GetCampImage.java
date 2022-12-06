package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_24.Dao.CampDao;
import T4_24.Models.CampBean;


@WebServlet("/T4_24/GetCampImage")
public class GetCampImage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		String mimeType = null;
		Blob blob = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			CampDao campDao = new CampDao();
			CampBean campBean = campDao.findByID(Integer.valueOf(id));
			Blob campPictures = campBean.getCampPictures();
			System.out.println(campPictures);
			is = campPictures.getBinaryStream();
			System.out.println(is);
			
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();	
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally{
			if (is != null) is.close();
			if (os != null) os.close();
			
		}
	}

}
