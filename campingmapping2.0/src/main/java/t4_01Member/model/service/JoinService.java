package t4_01Member.model.service;

import java.util.Map;

public interface JoinService {
	public Map<String, Object> accountsame(String account);
	public int joinNewMember(String account, String password, String email,
			String birthday);
}
