package T4_01.service;

import java.util.List;

import T4_01.beans.Member;

public interface MemberService {
	public List<Member> showMember();
	
	public int delte(String account);
}
