package T4_36.dao;

import java.sql.Connection;

import T4_36.entity.ProductOrderItems;

public interface ProductOrderItemsDao {

	
	double findItemAmount(ProductOrderItems oib);

	void updateProductStock(ProductOrderItems ob);
	
	void setConnection(Connection conn);


}
