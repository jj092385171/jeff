package T4_01.service.impl;

import java.util.HashMap;
import java.util.Map;

import T4_01.beans.License;
import T4_01.beans.Limits;
import T4_01.beans.LoginHistory;
import T4_01.beans.Member;
import T4_01.dao.impl.LicenseDaoImpl;
import T4_01.dao.impl.LimitsDaoImpl;
import T4_01.dao.impl.MemberImpl;
import T4_01.service.JoinService;

public class JoinServiceImpl implements JoinService {

	@Override
	public Map<String, Object> accountsame(String account) {
		MemberImpl memberImpl = new MemberImpl();
		Member select = memberImpl.select(account);
		HashMap<String, Object> res = new HashMap<>();
		if (select != null) {
			res.put("res", 1);
			return res;
		} else {
			res.put("res", 0);
			return res;

		}
	}

	@Override
	public int joinNewMember(String account, String password, String email,
			String birthday, String ip) {
		try {
			Member member = new Member();
			License license = new License();
			Limits limits = new Limits();
			LoginHistory loginHistory = new LoginHistory();
			MemberImpl memberImpl = new MemberImpl();
			member.setAccount(account);
			member.setEmail(email);
			member.setStringBirthday(birthday);;
			Member insertMember = memberImpl.insert(member);
			int uid = memberImpl.select(account).getUID();
			license.setUID(uid);
			license.setAccount(account);
			license.setPassword(password);
			License insertLicense = new LicenseDaoImpl().insert(license);
			limits.setUID(uid);
			limits.setAccount(account);
			Limits insertLimits = new LimitsDaoImpl().insert(limits);
			loginHistory.setUID(uid);
			loginHistory.setAccount(account);
			loginHistory.setIP(ip);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

}
