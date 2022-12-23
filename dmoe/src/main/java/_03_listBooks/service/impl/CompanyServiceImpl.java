package _03_listBooks.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _03_listBooks.dao.CompanyDao;
import _03_listBooks.dao.impl.CompanyDaoImpl_Jdbc;
import _03_listBooks.model.CompanyBean;
import _03_listBooks.service.CompanyService;

// 本類別負責讀取資料庫內eBookCompany表格內的紀錄
// 
public class CompanyServiceImpl implements Serializable, CompanyService {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);
	
	CompanyDao companyDao;

	// Constructor
	public CompanyServiceImpl() {
		companyDao = new CompanyDaoImpl_Jdbc();
	}
	// --------------------------------------------
	@Override
	public List<CompanyBean> findAll() {
		List<CompanyBean> companyBeans = companyDao.findAll();
		log.info("新增與更新書籍之前置作業之Service#findAll() companyBeans=" + companyBeans);
		return companyBeans;
	}

	@Override
	public CompanyBean findById(Integer id) {
		CompanyBean companyBean = companyDao.findById(id);
		log.info("List<CompanyBean> companyBean=" + companyBean);
		return companyBean;
	}

	@Override
	public String getSelectTag(String tagName, int selected) {
		String ans = "";
		List<CompanyBean> cb = findAll();
		ans += "<SELECT name='" + tagName + "'>";
		for (CompanyBean bean : cb) {
			int id = bean.getId();
			String name = bean.getName().substring(0, 4);
			if (id == selected) {
				ans += "<option value='" + id + "' selected>" + name + "</option>";
			} else {
				ans += "<option value='" + id + "'>" + name + "</option>";
			}
		}
		ans += "</SELECT>";
		log.info("新增與更新書籍之前置作業之Service#getSelectTag(), getSelectTag=" + ans);
		return ans;
	}

}