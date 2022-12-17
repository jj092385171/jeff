package t4_01Member.model.dao;

import java.util.List;

import t4_01Member.model.entity.License;




public interface LicenseDao {
	public License insert(License license);

	public int delete(String account);

	public int update(License license);

	public License select(String account);

	public List<License> selectAll();
}
