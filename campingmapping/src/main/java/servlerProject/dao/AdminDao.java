package servlerProject.dao;

import java.util.List;

import servlerProject.entity.Admin;

public interface AdminDao {
	public int insert(Admin admin);

	public int delete(int UID);

	public int update(Admin admin);

	public Admin select(int UID );
	public List<Admin> selectAll();
}

