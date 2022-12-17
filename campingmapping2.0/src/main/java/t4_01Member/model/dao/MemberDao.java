package t4_01Member.model.dao;

import java.util.List;

import t4_01Member.model.entity.Member;



public interface MemberDao {
	public Member insert(Member member);

	public int delete(String account);

	public int update(Member member);

	public Member select(String account);
	
	public List<Member> selectAll();
}
