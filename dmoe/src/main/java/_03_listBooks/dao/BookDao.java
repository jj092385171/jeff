package _03_listBooks.dao;

import java.util.List;
import java.util.Map;

import _03_listBooks.model.BookBean;

public interface BookDao {
	// 依bookId來刪除單筆記錄
	void deleteById(int bookId);

	// 依bookId來查詢單筆記錄
	BookBean findById(int bookId);
	
	List<String> getCategory();
	
	String getCategoryTag(String selected);
	
	Map<Integer, BookBean> getPageBooks(int pageNo);

	long getRecordCounts();

	int getTotalPages();
	
	// 新增一筆記錄
	void save(BookBean bean);
	
	void updateBook(BookBean bean, long sizeInBytes) ;

}