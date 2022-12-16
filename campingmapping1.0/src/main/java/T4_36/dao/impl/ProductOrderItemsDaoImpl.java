package T4_36.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import T4_36.dao.ProductOrderDao;
import T4_36.entity.ProductOrder;
import T4_36.entity.ProductOrderItems;

/*
 * 一張訂單須經過下列檢查 
 * 
 * 	1.	檢查訂購之商品的數量是否足夠。
 *      此功能寫在本類別的updateProductStock()方法內，參考該方法的說明。
 */

public abstract class ProductOrderItemsDaoImpl implements ProductOrderDao {
	
	private static Logger log = LoggerFactory.getLogger(ProductOrderItemsDaoImpl.class);
	
	Connection conn;

	public ProductOrderItemsDaoImpl() {
	}
	/*
	 * 計算客戶欲購買之某項商品(以OrderItemBean物件oib來表示)的小計金額(subtotal)， 
	 * 計算公式為: 商品的數量 * 商品的單價  * 商品的折扣
	 */
	public double findItemAmount(ProductOrderItems oib) {
		double subtotal = oib.getQuantity() * oib.getPd_price() * oib.getDiscount();
		return subtotal;
	}
	

	public void updateProductStock(ProductOrderItems productOrderItems) {
		String sql1 = "UPDATE category SET inventory = inventory - ? WHERE Pd_id = ?";
		try (PreparedStatement ps1 = conn.prepareStatement(sql1);) {
				ps1.setInt(1, productOrderItems.getQuantity());
				ps1.setInt(2, productOrderItems.getPd_id());
				ps1.executeUpdate();
				log.info("productOrderItems=" + productOrderItems);
				log.info("處理訂單之Dao: 扣除庫存量，商品編號: getBookId()=" + productOrderItems.getPd_id() + ", 扣除數量: " + productOrderItems.getQuantity() );
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("OrderItemDaoImpl類別#updateProductStock()發生SQL例外: " + ex.getMessage());
		}
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
}