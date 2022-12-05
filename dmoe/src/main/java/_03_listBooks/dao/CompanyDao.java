package _03_listBooks.dao;

import java.util.List;

import _03_listBooks.model.CompanyBean;

public interface CompanyDao {

	List<CompanyBean> findAll() ;

	CompanyBean findById(Integer id) ;
	
}