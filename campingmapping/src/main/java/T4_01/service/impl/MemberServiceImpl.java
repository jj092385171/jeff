package T4_01.service.impl;

import java.util.List;

import T4_01.beans.Member;
import T4_01.dao.impl.MemberImpl;
import T4_01.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Override
	public List<Member> showMember() {
		MemberImpl memberImpl = new MemberImpl();
		List<Member> selectAll = memberImpl.selectAll();
		return selectAll;
	}

}
