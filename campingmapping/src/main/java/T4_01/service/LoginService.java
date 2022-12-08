package T4_01.service;


import javax.servlet.http.HttpSession;

import T4_01.beans.License;

public interface LoginService {

	public License login(String account,String code );
	public HttpSession loginSession(String account,HttpSession session);
	
	
	
	
}
