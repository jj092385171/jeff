package _03_listBooks.service;

import java.util.Map;

import _03_listBooks.model.BookBean;

public interface BookService {
	// 依bookId來刪除單筆記錄
	void deleteById(int bookId);
	
	// 依bookId來查詢單筆記錄
	BookBean findById(int bookId);

	String getCategoryTag(String selected);
	// 依照頁碼來讀取一頁的商品資料
	Map<Integer, BookBean> getPageBooks(int pageNo);
	// 讀取的商品總數量
	long getRecordCounts();
	// 讀取的商品總頁數
	int getTotalPages();
	
	// 新增一筆記錄
	void save(BookBean bean);

	// 更新商品資料
	void updateBook(BookBean bean, long sizeInBytes) ;

}
