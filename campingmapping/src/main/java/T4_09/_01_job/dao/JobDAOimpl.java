package T4_09._01_job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import T4_09._01_job.model.JobBean;
import utils.DbUtils;

public class JobDAOimpl implements JobDAO {
	private QueryRunner queryRunner = new QueryRunner();

	// 新增資料
	@Override
	public void addJob(JobBean jobBean) throws SQLException {
		String sql = "insert into job values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(DbUtils.getConnection(), sql, jobBean.getuID(), jobBean.getRackID(),jobBean.getJob(), jobBean.getSalary(),
					jobBean.getQuantity(), jobBean.getPlace(), jobBean.getTime(), jobBean.getDate(), jobBean.getImg(),
					jobBean.getRemark(), jobBean.getRackUp(), jobBean.getRackDown());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 搜尋全部
	@Override
	public List<JobBean> selectAll() throws SQLException {
		String sql = "select* from job";

		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		ResultSet rs = pre.executeQuery();

		List<JobBean> list = new ArrayList<JobBean>();
		while (rs.next()) {
			JobBean jb = new JobBean();
			jb.setuID(rs.getInt("uID"));
			jb.setRackID(rs.getInt("rackID"));
			jb.setJob(rs.getString("job"));
			jb.setSalary(rs.getString("salary"));
			jb.setQuantity(rs.getInt("quantity"));
			jb.setPlace(rs.getString("place"));
			jb.setTime(rs.getString("time"));
			jb.setDate(rs.getString("date"));
			jb.setImg(rs.getBlob("img"));
			jb.setRemark(rs.getString("remark"));
			jb.setRackUp(rs.getDate("rackUp"));
			jb.setRackDown(rs.getDate("rackDown"));
			
			System.out.println(jb);
			list.add(jb);
		}
		return list;
	}
	
	//透過rackID找圖片
	@Override
	public JobBean findImgByRackID(int rackID) throws SQLException {
		String sql = "select img from job where rackID = ? ";
		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, rackID);
		ResultSet rs = pre.executeQuery();
		rs.next();
		JobBean jb = new JobBean();
		jb.setImg(rs.getBlob("img"));
	
		return jb;
		
	}


	// 透過rackID刪除資料
	@Override
	public void deleteJob(int rackID) throws SQLException {
		String sql = "delete from job where rackID = ?";	
		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, rackID);
		pre.executeUpdate();
	}
//		try {
//			queryRunner.update(DbUtils.getConnection(),sql, new BeanHandler<JobBean>(JobBean.class), rackID);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	

	// 透過job搜尋全部職缺
	@Override
	public JobBean selectJob(String job) {
		String sql = "select* from job where rackID like ?";
		try {
			JobBean joBean = queryRunner.query(DbUtils.getConnection(), sql, new BeanHandler<JobBean>(JobBean.class),
					job);
			return joBean ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 透過刊登id更改職缺等
	@Override
	public void updateJob(JobBean jobBean) {
		String sql = "update job set job = ?,salary=?,quantity=?,time=?,date=?,img=?,remark=? where rackID = ?";
		try {
			 queryRunner.update(DbUtils.getConnection(), sql, jobBean.getJob(), jobBean.getuID(),
					jobBean.getSalary(), jobBean.getQuantity(), jobBean.getPlace(), jobBean.getTime(),
					jobBean.getDate(), jobBean.getRemark());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}






}
