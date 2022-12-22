package com.campingmapping.team4.spring.t4_01Member.model.service;

import java.util.List;

import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.CouponWalletDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.LicenseDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.LimitsDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.LoginHistoryDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.dao.impl.MemberDaoImpl;
import com.campingmapping.team4.spring.t4_01Member.model.entity.CouponWallet;
import com.campingmapping.team4.spring.t4_01Member.model.entity.License;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Limits;
import com.campingmapping.team4.spring.t4_01Member.model.entity.LoginHistory;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;

public class Testsc {

	public List<Member> allMember() {
		return new MemberDaoImpl().getAll();
	}
	public List<Limits> allLimits() {
		return new LimitsDaoImpl().getAll();
	}
	public List<License> allLicense() {
		return new LicenseDaoImpl().getAll();
	}
	public List<CouponWallet> allCouponWallet() {
		return new CouponWalletDaoImpl().getAll();
	}
	public List<LoginHistory> allLoginHistory() {
		return new LoginHistoryDaoImpl().getAll();
	}
	public Member getid(Integer id) {
		return new MemberDaoImpl().getById(id);
	}
	
	
}
