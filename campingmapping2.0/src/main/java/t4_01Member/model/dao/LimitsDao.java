package t4_01Member.model.dao;

import java.util.List;

import t4_01Member.model.entity.Limits;

public interface LimitsDao {
	public Limits insert(Limits limits);

	public int delete(String account);

	public int update(Limits limits);

	public Limits select(String account);

	public List<Limits> selectAll();
}
