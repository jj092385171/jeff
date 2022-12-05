package _04_ShoppingCart.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.DBService;
import _01_register.dao.MemberDao;
import _01_register.dao.impl.MemberDaoImpl_Jdbc;
import _01_register.service.MemberService;
import _01_register.service.impl.MemberServiceImpl;
import _03_listBooks.dao.BookDao;
import _03_listBooks.dao.impl.BookDaoImpl_Jdbc;
import _04_ShoppingCart.dao.OrderDao;
import _04_ShoppingCart.dao.OrderItemDao;
import _04_ShoppingCart.dao.impl.OrderDaoImpl;
import _04_ShoppingCart.dao.impl.OrderItemDaoImpl;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.model.OrderItemBean;
import _04_ShoppingCart.model.ShoppingCart;
import _04_ShoppingCart.service.OrderService;
import _04_ShoppingCart.ude.ProductStockException;

public class OrderServiceImpl implements OrderService {

	private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private DataSource ds;
	private BookDao bookDao;
	private OrderItemDao orderItemDao;
	private OrderDao orderDao;
	private MemberDao memberDao;
	private MemberService memberService;

	public OrderServiceImpl() {
		try {
			Context ctx = new InitialContext();
			ds 	  = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
			bookDao = new BookDaoImpl_Jdbc(); 
			orderItemDao = new OrderItemDaoImpl();
			orderDao  = new OrderDaoImpl();
			memberDao  = new MemberDaoImpl_Jdbc();
			memberService = new MemberServiceImpl(memberDao);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	// 這是一個交易
	public void persistOrder(OrderBean ob) {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
		try {
			log.info("處理訂單之Service:交易開始");
			// 交易開始
			con.setAutoCommit(false);
			// 檢查未付款餘額是否超過限額，並更新未付款餘額
			memberDao.setConnection(con);
			log.info("處理訂單之Service: 1. 準備處理會員之未付款餘額");
			memberService.checkUnpaidAmount(ob);
			 
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
			// 檢查所有訂單明細所訂購之商品的庫存數量是否足夠
			checkStock(ob, con);
			
			// 儲存訂單
			log.info("處理訂單之Service: 3. 準備儲存訂單");
			orderDao.setConnection(con);
			orderDao.save(ob);
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("發生異常，交易回滾.....,原因: " + e.getMessage());
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				con.setAutoCommit(true);
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public void checkStock(OrderBean ob, Connection con) {
		Set<OrderItemBean> items = ob.getItems();
		orderItemDao.setConnection(con);
		
		log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量");
		for (OrderItemBean oib : items) {
			int stock = bookDao.findById(oib.getBookId()).getStock(); 
			log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + oib.getBookId() );
			if (stock < oib.getQuantity()) {
				log.info("處理訂單之Service: 2. 準備再次檢查並調整每項商品的庫存量, 商品編號: " + oib.getBookId() + " 庫存不足" );
				throw new ProductStockException("庫存數量不足: BookId: " 
						+ oib.getBookId() + ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
			} else {
				log.info("處理訂單之Service: 2. 準備調整每項商品的庫存量, 商品編號: " + oib.getBookId() + " 庫存足夠" );
				orderItemDao.updateProductStock(oib);
			}
		}
	}
	
	public void preCheckStock(ShoppingCart shoppingCart) {
		log.info("訂單前期檢查之Service, 開始"); 
		Connection con = null;
		try { 
			con = ds.getConnection();
		} catch(Exception ex ) {
			log.error(ex.getMessage());
			throw new RuntimeException(ex);
		}	
		orderItemDao.setConnection(con);
		Set<Integer> set = shoppingCart.getContent().keySet();
		
		for(Integer i : set) {
			OrderItemBean oib = shoppingCart.getContent().get(i);
			int stock = bookDao.findById(oib.getBookId()).getStock();
			if (stock < oib.getQuantity()) {
				log.info("訂單前期檢查之Service preCheckStock(): 庫存數量不足, " +
						oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
				throw new ProductStockException("庫存數量不足: 商品: " 
						+ oib.getDescription()+ ", 在庫量: " + stock+ ", 訂購量: " + oib.getQuantity());
			} 
			log.info("訂單前期檢查之Service preCheckStock(): 未發現任何商品數量不足");
		}
	}

	@Override
	public OrderBean findById(int orderNo) {
		log.info("依照orderNo編號讀取特定一筆訂單的所有資料之Service, orderNo=" + orderNo);
		return orderDao.findById(orderNo);
	}

	@Override
	public List<OrderBean> findByMemberId(String memberId) {
		log.info("依照memberId編號讀取某位會員所有訂單之Service: memberId=" + memberId);
		return orderDao.findByMemberId(memberId);
	}

}
