package _03_listBooks.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map; 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.DBService;
import _00_init.util.GlobalService;
import _03_listBooks.dao.BookDao;
import _03_listBooks.model.BookBean;

// 本類別使用純JDBC的技術來存取資料庫。
// 所有SQLException都以catch區塊捕捉，然後一律再次丟出RuntimeException。
// 對SQLException而言，即使catch下來，程式依然無法正常執行，所以捕捉SQLException，再次丟出
// RuntimeException。
public class BookDaoImpl_Jdbc implements Serializable, BookDao {

	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(BookDaoImpl_Jdbc.class);
	
	public static final int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
	private int totalPages = -1;
	DataSource ds = null;
	
	public BookDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#建構子發生例外: " 
										+ ex.getMessage());
		}
	}
	
	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		log.info("totalPages=" + totalPages);
		return totalPages;
	}
	
	// 查詢某一頁的商品(書籍)資料，執行本方法前，一定要先設定實例變數pageNo的初值
	@Override
	public Map<Integer, BookBean> getPageBooks(int pageNo) {
		
		log.info("新增書籍之顯示書籍功能之Dao，讀取一頁商品資料之 pageNo=" + pageNo);
		
		Map<Integer, BookBean> map = new LinkedHashMap<>();
		
		String sql0 = "SELECT  * FROM (SELECT  ROW_NUMBER() OVER (ORDER BY BOOKID)"
				+ " AS RowNum, b.BookId, b.author, b.bookNo, b.category, b.title, b.listPrice, "
				+ " b.discount, b.stock, b.companyID, b.fileName, b.mimeType, b.coverImage, bc.name "
				+ " FROM Book b JOIN BookCompany bc ON  b.companyId = bc.id )"
				+ " AS NewTable WHERE RowNum >= ? AND RowNum <= ?";
		
//		String sql1 = "SELECT b.BookId, b.author, b.bookNo, b.category, b.TITLE, "
//				+ "b.ListPrice, b.discount, b.companyID, b.fileName, b.coverImage, "
//				+ "bc.name FROM Book b JOIN BookCompany bc ON  b.companyId = bc.id "
//						+ " LIMIT ?, ?";
		String sql = sql0;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		// 由頁碼推算出該頁是由哪一筆紀錄開始(0 based)		
//		int startRecordNo = (pageNo - 1) * recordsPerPage;
//		int endRecordNo = recordsPerPage;
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, startRecordNo);
			ps.setInt(2, endRecordNo);
			try (
				ResultSet rs = ps.executeQuery();
			) {
				// 只要還有紀錄未取出，rs.next()會傳回true
				// 迴圈內將逐筆取出ResultSet內的紀錄
				while (rs.next()) {
					// 準備一個新的BookBean，將ResultSet內的一筆紀錄移植到BookBean內
					BookBean bean = new BookBean();    	
					bean.setBookId(rs.getInt("BookId"));		
					bean.setAuthor(rs.getString("author"));
					bean.setBookNo(rs.getString("bookNo"));
					bean.setCategory(rs.getString("category"));
					bean.setTitle(rs.getString("title"));
					bean.setListPrice(rs.getDouble("listprice"));
					bean.setDiscount(rs.getDouble("discount"));
					bean.setCompanyId(rs.getInt("companyID"));
					bean.setFileName(rs.getString("Filename"));
					bean.setMimeType(rs.getString("mimeType"));
					bean.setCoverImage(rs.getBlob("CoverImage"));
					bean.setCompanyName(rs.getString("name"));
					bean.setStock(rs.getInt("stock"));
					// 最後將BookBean物件放入大的容器內
					map.put(rs.getInt("BookId"), bean);
					log.info("pageNo=" + pageNo + ", 加了一個bean=" + bean);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("BookDaoImpl_Jdbc()#getPageBooks()發生例外: " 
										+ ex.getMessage());
		}
		log.info("新增書籍之顯示書籍功能之Dao，存放商品資料之map=" + map);
		return map;
	}

	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String sql = "SELECT count(*) FROM Book";
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			if (rs.next()) {
				count = rs.getLong(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#getRecordCounts()發生例外: " 
										+ ex.getMessage());
		}
		log.info("RecordCounts=" + count );
		return count;
	}
	
	@Override
	public List<String> getCategory() {
		String sql = "SELECT DISTINCT Category FROM Book";
		List<String> list = new ArrayList<>();
		try (
			Connection connection = ds.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			while (rs.next()) {
				String cate = rs.getString(1);
				if (cate != null) {
					list.add(cate);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#getCategory()發生例外: " 
										+ ex.getMessage());
		}
		log.info("list=" + list );
		return list;
	}
	
	@Override
	public String getCategoryTag(String selected) {
		String ans = "";
		List<String> list = getCategory();
		ans += "<SELECT name='category'>";
		for (String cate : list) {
			if (cate.equals(selected)) {
				ans += "<option value='" + cate + "' selected>" + cate + "</option>";
			} else {
				ans += "<option value='" + cate + "'>" + cate + "</option>";
			}
		}
		ans += "</SELECT>";
		log.info("ans=" + ans );
		return ans;
	}
	
	// 修改一筆書籍資料
	@Override
	public void updateBook(BookBean bean, long sizeInBytes) {
		String sql = "UPDATE Book SET " 
				+ " title=?,  author=?,  listPrice=?, discount = ?, coverImage = ?, "
				+ " fileName=?, bookNo=?, stock=?, companyId=? , category = ?, mimeType = ? WHERE bookId = ?";
		if (sizeInBytes == -1) { // 不修改圖片
			updateBook(bean);
			return;
		}
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getListPrice());
			ps.setDouble(4, bean.getDiscount());
			ps.setBlob(5, bean.getCoverImage());
			ps.setString(6, bean.getFileName());
			ps.setString(7, bean.getBookNo());
			ps.setInt(8, bean.getStock());
			ps.setInt(9, bean.getCompanyId());
			ps.setString(10, bean.getCategory());
			ps.setString(11, bean.getMimeType());
			ps.setInt(12, bean.getBookId());
			ps.executeUpdate();
			log.info("updateBook=" + bean + ", sizeInBytes=" + sizeInBytes);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#updateBook(BookBean, long)發生例外: " 
										+ ex.getMessage());
		}
	}

	// 修改一筆書籍資料，不改圖片
	public int updateBook(BookBean bean) {
		int n = 0;
		String sql = "UPDATE Book SET " 
				+ " title=?,  author=?,  listPrice=?, discount=?,  bookNo=?, "
				+ " stock=?,  companyID=?,  category=?  WHERE bookId = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.clearParameters();
			ps.setString(1, bean.getTitle());
			ps.setString(2, bean.getAuthor());
			ps.setDouble(3, bean.getListPrice());
			ps.setDouble(4, bean.getDiscount());
			ps.setString(5, bean.getBookNo());
			ps.setInt(6, bean.getStock());
			ps.setInt(7, bean.getCompanyId());
			ps.setString(8, bean.getCategory());
			ps.setInt(9, bean.getBookId());
			log.info("updateBook=" + bean );
			n = ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#updateBook(BookBean)發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}

	// 依bookId來刪除單筆記錄
	@Override
	public void deleteById(int bookId) {
		log.info("刪除書籍功能之Dao, 書籍主鍵值：" + bookId);
		String sql = "DELETE FROM Book WHERE bookId = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement pStmt = connection.prepareStatement(sql);
		) {
			pStmt.setInt(1, bookId);
			pStmt.executeUpdate();
			log.info("刪除書籍功能之Dao, 書籍主鍵值：" + bookId + ", 刪除成功");
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#deleteBook()發生例外: " 
										+ ex.getMessage());
		}
	}

	// 新增一筆記錄---
	@Override
	public void save(BookBean bean) {

		String sql = "INSERT INTO Book " 
				+ " (title, author, listPrice, discount, "
				+ " companyId, fileName, bookNo, coverImage, stock, category, mimeType) " 
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (
			Connection connection = ds.getConnection();
			PreparedStatement pStmt = connection.prepareStatement(sql);
		) {
			pStmt.setString(1, bean.getTitle());
			pStmt.setString(2, bean.getAuthor());
			pStmt.setDouble(3, bean.getListPrice());
			pStmt.setDouble(4, bean.getDiscount());
			pStmt.setInt(5, bean.getCompanyId());
			pStmt.setString(6, bean.getFileName());
			pStmt.setString(7, bean.getBookNo());
			pStmt.setBlob(8, bean.getCoverImage());
			pStmt.setInt(9, bean.getStock());
			pStmt.setString(10, bean.getCategory());
			pStmt.setString(11, bean.getMimeType());
			pStmt.executeUpdate();
			log.info("維護書籍資料功能之Dao: 資料新增成功, BookBean=" + bean);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#saveBook()發生例外: " 
										+ ex.getMessage());
		}
	}

	@Override
	public BookBean findById(int bookId) {
		BookBean bean = null;
		String sql = "SELECT * FROM Book WHERE bookId = ?";

		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, bookId);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					bean = new BookBean();
					bean.setBookId(rs.getInt("bookId"));
					bean.setTitle(rs.getString("title"));
					bean.setAuthor(rs.getString("author"));
					bean.setListPrice(rs.getDouble("listPrice"));
					bean.setDiscount(rs.getDouble("discount"));
					bean.setCoverImage(rs.getBlob("coverImage"));
					bean.setFileName(rs.getString("fileName"));
					bean.setBookNo(rs.getString("bookNo"));
					bean.setStock(rs.getInt("stock"));
					bean.setCategory(rs.getString("category"));
					bean.setCompanyId(rs.getInt("companyId"));
					bean.setMimeType(rs.getString("mimeType"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc()#queryBook()發生例外: " 
										+ ex.getMessage());
		}
		log.info("更新書籍之前置作業之Dao, 書籍主鍵值：" + bookId  + ", bean=" + bean);
		return bean;
	}

}