package T4_01.dao;

import java.util.List;

import T4_01.beans.License;



public interface LicenseDao {
	public License insert(License license);

	public int delete(String account);

	public int update(License license);

	public License select(String account);

	public List<License> selectAll();
}
