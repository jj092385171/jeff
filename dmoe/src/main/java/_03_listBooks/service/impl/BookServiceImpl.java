package _03_listBooks.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_listBooks.dao.BookDao;
import _03_listBooks.dao.impl.BookDaoImpl_Jdbc;
import _03_listBooks.model.BookBean;
import _03_listBooks.service.BookService;
 
public class BookServiceImpl implements BookService {
	
	private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
    BookDao bookDao;
    
	public BookServiceImpl() {
		this.bookDao = new BookDaoImpl_Jdbc();
	}

	@Override
	public int getTotalPages() {
		log.info("BookServiceImpl#getTotalPages");
		return bookDao.getTotalPages();
	}

	@Override
	public Map<Integer, BookBean> getPageBooks(int pageNo) { 
		log.info("維護書籍資料之顯示書籍功能之Service，讀取一頁商品資料之 pageNo=" + pageNo);
		return bookDao.getPageBooks(pageNo);
	}

	@Override
	public long getRecordCounts() {
		log.info("BookServiceImpl#getRecordCounts");
		return bookDao.getRecordCounts();
	}

	@Override
	public BookBean findById(int bookId) {
		log.info("更新書籍資料之前置作業之Service, 書籍主鍵值：" + bookId);
		return bookDao.findById(bookId);
	}

	@Override
	public void updateBook(BookBean bean, long sizeInBytes) {
		log.info("更新書籍資料之Service, bean=" + bean + ", sizeInBytes=" + sizeInBytes);
		bookDao.updateBook(bean, sizeInBytes);
	}
	
	@Override
	public void deleteById(int bookId) {
		log.info("刪除書籍功能之Service, 書籍主鍵值：" + bookId);
		bookDao.deleteById(bookId);
	}

	@Override
	public void save(BookBean bean) {
		 bookDao.save(bean);
		 log.info("新增書籍功能之Service: 資料新增成功, BookBean=" + bean);
	}

	@Override
	public String getCategoryTag(String selected) {
		log.info("新增與更新書籍之前置作業之Service, 參數selected=" + selected + "*****");
		return bookDao.getCategoryTag(selected);
	}
}
