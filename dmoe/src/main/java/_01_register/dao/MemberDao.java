package _01_register.dao;

import java.sql.Connection;

import _01_register.model.MemberBean;
import _04_ShoppingCart.model.OrderBean;

public interface MemberDao {
	
	boolean existsById(String id);

	void save(MemberBean mb) ;
	
	MemberBean findByMemberId(String id);
	
	MemberBean findByMemberIdAndPassword(String memberId, String password);	
	
	void updateUnpaidAmount(OrderBean ob);

	void setConnection(Connection con);
}