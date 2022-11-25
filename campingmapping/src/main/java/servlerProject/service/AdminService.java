package servlerProject.service;

import java.util.List;



import servlerProject.entity.Admin;

public interface AdminService {
public Admin login (int UID,String password);
public List<Admin> showAllAdmin();
}
