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
import T4_24.Dao.CampPlusCityPlusTagsDao;
import T4_24.Models.CampBean;
import T4_24.Models.CampPlusCityPlusTagsBean;

@WebServlet("/T4_24/GetCampImage")
public class GetCampImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OutputStream os = null;
		InputStream is = null;
		String fileName = null;
		String mimeType = null;
		Blob campPictures = null;
		try {
			// 讀取瀏覽器傳送來的主鍵
			String id = request.getParameter("id");
			System.out.println("id:"+id);
			// 讀取瀏覽器傳送來的type，以分辨要處理哪個表格
			CampPlusCityPlusTagsDao campPlusCityDao = new CampPlusCityPlusTagsDao();
			
			CampPlusCityPlusTagsBean cpcBean = campPlusCityDao.findCampByID(Integer.valueOf(id));
			campPictures = cpcBean.getCampPictures();
			is = campPictures.getBinaryStream();
			System.out.println("is:"+is);
			
			// 由圖片檔的檔名來得到檔案的MIME型態
			mimeType = getServletContext().getMimeType(fileName);
			// 設定輸出資料的MIME型態
			response.setContentType(mimeType);
			// 取得能寫出非文字資料的OutputStream物件
			os = response.getOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				System.out.println("os:"+os);
//				os.flush();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();

		}
	}

}
