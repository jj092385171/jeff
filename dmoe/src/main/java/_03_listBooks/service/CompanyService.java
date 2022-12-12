package _03_listBooks.service;

import java.util.List;

import _03_listBooks.model.CompanyBean;

public interface CompanyService {

	List<CompanyBean> findAll() ;

	CompanyBean findById(Integer id) ;

	String getSelectTag(String tagName, int selected);
	
}