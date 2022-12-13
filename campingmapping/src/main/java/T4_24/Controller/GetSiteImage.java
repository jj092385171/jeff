package T4_24.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T4_24.Dao.SiteDao;
import T4_24.Models.SiteBean;

@MultipartConfig()
@WebServlet("/T4_24/GetSiteImage")
public class GetSiteImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OutputStream os = null;
		InputStream is = null;
		Blob campPictures = null;
		
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			SiteDao siteDao = new SiteDao();
			SiteBean findPictures = siteDao.findPictures(Integer.valueOf(id));
			
			campPictures = findPictures.getSitePictures();
			is = campPictures.getBinaryStream();
			
			// 由圖片檔的檔名來得到檔案的MIME型態
//			mimeType = getServletContext().getMimeType(fileName);
			// 設定輸出資料的MIME型態
//			response.setContentType(mimeType);
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("失敗");

		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();

		}
	}

}
