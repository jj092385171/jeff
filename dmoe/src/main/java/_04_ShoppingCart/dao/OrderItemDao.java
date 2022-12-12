package _04_ShoppingCart.dao;

import java.sql.Connection;

import _04_ShoppingCart.model.OrderItemBean;

public interface OrderItemDao {
	
	double findItemAmount(OrderItemBean oib);

	void updateProductStock(OrderItemBean ob);
	
	void setConnection(Connection conn);

}
