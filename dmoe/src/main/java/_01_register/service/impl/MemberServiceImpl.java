package _01_register.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.GlobalService;
import _01_register.dao.MemberDao;
import _01_register.dao.impl.MemberDaoImpl_Jdbc;
import _01_register.model.MemberBean;
import _01_register.service.MemberService;
import _04_ShoppingCart.model.OrderBean;
import _04_ShoppingCart.ude.UnpaidOrderAmountExceedingException;

public class MemberServiceImpl implements MemberService {

	MemberDao  memberDao ;
	
	private static Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	public MemberServiceImpl() {
		this.memberDao = new MemberDaoImpl_Jdbc();
	}
	
	public MemberServiceImpl(MemberDao  memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void save(MemberBean mb) {
		log.info("會員註冊功能之Service: 儲存會員資料");
		memberDao.save(mb);
	}

	@Override
	public boolean existsById(String id) {
		log.info("會員註冊功能之Service: 檢查會員輸入的編號是否已被使用");
		return memberDao.existsById(id);
	}

	@Override
	public MemberBean findByMemberId(String id) {
		log.info("會員註冊功能之Service: 由會員編號找出對應的會員");
		return memberDao.findByMemberId(id);
	}
	/* 功能：檢查客戶的未付款訂購金額。
	 * 說明：處理客戶訂單時，[訂單的總金額 + 該客戶的未付款餘額]不能超過限額，
	 * 此限額定義在 GlobalService類別的常數: ORDER_AMOUNT_LIMIT
	 * 步驟：
	 * 1. 取出 OrderBean 內的訂單的總金額
	 * 1. 取出Member表格內的 Member#unpaid_amount欄位(未付款餘額) 
	 * 2. unpaid_amount加上本訂單的總金額後，檢查該數值是否超過限額
	 *    (GlobalService.ORDER_AMOUNT_LIMIT)。 
	 *    如果超過限額， 則
	 *    		該訂單不予處裡， 丟出UnpaidOrderAmountExceedingException，
	 * 	    否則呼叫memberDao#updateUnpaidAmount(ob)：執行更新Member表格的
	 *      unpaid_amount欄位: Member#unpaid_amount += currentAmount;
	 */
	@Override
	public void checkUnpaidAmount(OrderBean ob) {
		log.info("處理訂單會員註冊功能之Service: 由會員編號找出對應的會員");
		double currentAmount = ob.getTotalAmount(); // 取出該訂單的總金額
		double unpaidAmount = findByMemberId(ob.getMemberId()).getUnpaid_amount();
		if (currentAmount + unpaidAmount > GlobalService.ORDER_AMOUNT_LIMIT) {
			log.info("處理訂單之Dao: 未付款金額超過限額: " + (currentAmount + unpaidAmount));
			throw new UnpaidOrderAmountExceedingException("未付款金額超過限額: " 
								       		+ (currentAmount + unpaidAmount));
		} else {
			log.info("處理訂單之Dao: 未付款金額並未超過限額");
			memberDao.updateUnpaidAmount(ob);
		}
	}
	@Override
	public MemberBean findByMemberIdAndPassword(String memberId, String password) {
		MemberBean mb = memberDao.findByMemberIdAndPassword(memberId, password);
		log.info("會員登入功能之Service: 檢查帳號/密碼結果:" 
					+ (mb == null? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return mb;
	}
}
