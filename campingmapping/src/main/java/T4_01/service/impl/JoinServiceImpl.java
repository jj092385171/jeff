package T4_01.service.impl;

import java.util.HashMap;
import java.util.Map;

import T4_01.beans.Member;
import T4_01.dao.impl.MemberImpl;
import T4_01.service.JoinService;

public class JoinServiceImpl implements JoinService {

	@Override
	public Map<String, Object> accountsame(String account) {
		MemberImpl memberImpl = new MemberImpl();
		Member select = memberImpl.select(account);
		HashMap<String, Object> res = new HashMap<>();
		if (select!=null) {
			res.put("res", 1);
			return res;
		}else {
			res.put("res", 0);
			return res;
			
		}
	}

}
