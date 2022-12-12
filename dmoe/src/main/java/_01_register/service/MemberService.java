package _01_register.service;

import _01_register.model.MemberBean;
import _04_ShoppingCart.model.OrderBean;

public interface MemberService {
	boolean existsById(String id);
	
	void save(MemberBean mb);
	
	void checkUnpaidAmount(OrderBean ob);
	
	MemberBean findByMemberId(String id);
	
	MemberBean findByMemberIdAndPassword(String memberId, String password) ;
}
