package T4_36.dao;

import java.sql.Connection;

import T4_36.entity.ProductOrderItems;

public interface ProductOrderItemsDao {

	//	計算公式為: 商品的數量 * 商品的單價  * 商品的折扣
	double findItemAmount(ProductOrderItems oib);
	// 處理訂單之Dao: 扣除庫存量
	void updateProductStock(ProductOrderItems ob);
	//	
	void setConnection(Connection conn);


}
