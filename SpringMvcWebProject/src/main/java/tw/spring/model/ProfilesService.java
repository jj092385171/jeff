package tw.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfilesService {
	
	@Autowired
	private ProfilesDao pDao;
	
	public Profiles insert(Profiles pBean) {
		return pDao.insert(pBean);
	}
	
	public Profiles update(Profiles pBean) {
		return pDao.update(pBean);
	}
	
	public Profiles findById(int id) {
		return pDao.findById(id);
	}
	
	public boolean delete(Profiles pBean) {
		return pDao.delete(pBean);
	}
}
