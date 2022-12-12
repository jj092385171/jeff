package _04_ShoppingCart.dao;

import java.sql.Connection;
import java.util.List;

import _04_ShoppingCart.model.OrderBean;

public interface OrderDao {

	void save(OrderBean ob);

	OrderBean findById(int orderNo);

	List<OrderBean> findByMemberId(String memberId);

	void setConnection(Connection con);
}