package T4_36.dao;

import java.sql.Connection;
import java.util.List;

import T4_36.entity.ProductOrder;

public interface ProductOrderDao {
	void save(ProductOrder ob);

	ProductOrder findById(int orderNo);

	List<ProductOrder> findByMemberId(String memberId);

	void setConnection(Connection con);

}
