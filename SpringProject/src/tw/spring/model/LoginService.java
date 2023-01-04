package tw.spring.model;

public class LoginService {
	
	private LoginDao loginDao;
	
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public LoginService() {
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public boolean checkLogin(String user, String pwd) {
		return loginDao.checkLogin(user, pwd);
	}
}
