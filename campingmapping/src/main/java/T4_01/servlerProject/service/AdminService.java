package T4_01.servlerProject.service;

import java.util.List;

import T4_01.servlerProject.entity.Admin;





public interface AdminService {
public Admin login (int UID,String password);
public List<Admin> showAllAdmin();
}
