package T4_01.dao;

import java.util.List;

import T4_01.beans.Member;

public interface MemberDao {
	public Member insert(Member member);

	public int delete(String account);

	public int update(Member member);

	public Member select(String account);
	
	public List<Member> selectAll();
}
