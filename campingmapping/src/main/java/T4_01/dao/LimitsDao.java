package T4_01.dao;

import java.util.List;
import T4_01.beans.Limits;

public interface LimitsDao {
	public int insert(Limits limits);

	public int delete(String account);

	public int update(Limits limits);

	public Limits select(String account);

	public List<Limits> selectAll();
}
