package com.campingmapping.team4.spring.t4_01Member.controller.servlet;

import java.util.List;

import com.campingmapping.team4.spring.t4_01Member.model.entity.CouponWallet;
import com.campingmapping.team4.spring.t4_01Member.model.entity.License;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Limits;
import com.campingmapping.team4.spring.t4_01Member.model.entity.LoginHistory;
import com.campingmapping.team4.spring.t4_01Member.model.entity.Member;
import com.campingmapping.team4.spring.t4_01Member.model.service.Testsc;

public class Test {

	public static void main(String[] args) {

Testsc testsc = new Testsc();
//List<CouponWallet> allCouponWallet = testsc.allCouponWallet();
//List<License> allLicense = testsc.allLicense();
//List<Limits> allLimits = testsc.allLimits();
//List<LoginHistory> allLoginHistory = testsc.allLoginHistory();
//List<Member> allMember = testsc.allMember();
//allCouponWallet.forEach(s->System.out.println(s.toString()));
//allLicense.forEach(l -> System.out.println(l.toString()));
//allLimits.forEach(l -> System.out.println(l.toString()));
//allLoginHistory.forEach(l -> System.out.println(l.toString()));
Member getid = testsc.getid(2);
System.out.println(getid.toString());
//allMember.forEach(l -> System.out.println(l.toString()));

		
		
		
	}

}
