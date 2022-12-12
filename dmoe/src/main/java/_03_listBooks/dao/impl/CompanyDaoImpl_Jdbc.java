package _03_listBooks.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import _00_init.util.DBService;
import _03_listBooks.dao.CompanyDao;
import _03_listBooks.model.CompanyBean;

// 本類別負責讀取資料庫內BookCompany表格內的紀錄
// 
public class CompanyDaoImpl_Jdbc implements Serializable, CompanyDao {
	private static final long serialVersionUID = 1L;

	private static Logger log = LoggerFactory.getLogger(CompanyDaoImpl_Jdbc.class);
	
	DataSource dataSource = null;

	public CompanyDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup(DBService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("CompanyDaoImpl_Jdbc()#建構子發生例外: " 
					  + ex.getMessage());
		}
	}

	@Override
	public CompanyBean findById(Integer id) {
		CompanyBean companyBean = null;

		String sql = "SELECT * FROM BookCompany WHERE id = ?";
		try (
			Connection connection = dataSource.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					companyBean = new CompanyBean(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getString(4));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("CompanyDaoImpl_Jdbc()#getCompanyById()發生例外: " 
					+ ex.getMessage());
		}
		log.info("CompanyBean=" + companyBean);
		return companyBean;
	}

	@Override
	public List<CompanyBean> findAll() {
		List<CompanyBean> list = new ArrayList<>();
		String sql = "SELECT * FROM BookCompany";
		try (
			Connection connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		) {
			while (rs.next()) {
				CompanyBean cb = new CompanyBean(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
				list.add(cb);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("CompanyDaoImpl_Jdbc()#getCompany()發生例外: " 
					+ ex.getMessage());
		}
		log.info("新增與更新書籍之前置作業之Dao#findAll(), List<CompanyBean>=" + list); 
		return list;
	}
}