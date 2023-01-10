package com.campingmapping.team4.spring.t4_01Member.model.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.campingmapping.team4.spring.t4_01Member.model.service.JoinService;

@Service("JoinService")
public class JoinServiceImpl implements JoinService {

	@Override
	public Map<String, Object> accountsame(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int joinNewMember(String account, String password, String email,
			String birthday) {
		// TODO Auto-generated method stub
		return 0;
	}

}
