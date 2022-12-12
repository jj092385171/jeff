package T4_09._01_job.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import T4_09._01_job.model.JobBean;
import utils.DbUtils;

public class JobDAOimpl implements JobDAO {
	private QueryRunner queryRunner = new QueryRunner();

	// 新增資料
	@Override
	public void addJob(JobBean jobBean) throws SQLException {
		String sql = "insert into job values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			queryRunner.update(DbUtils.getConnection(), sql, jobBean.getuID(), jobBean.getRackID(), jobBean.getJob(),
					jobBean.getSalary(), jobBean.getQuantity(), jobBean.getPlace(), jobBean.getTime(),
					jobBean.getDate(), jobBean.getImg(), jobBean.getRemark(), jobBean.getRackUp(),
					jobBean.getRackDown());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 搜尋全部
	@Override
	public List<JobBean> selectAll() throws SQLException {
		String sql = "select* from job order by uID ASC";

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

			list.add(jb);
		}
		return list;
	}

	// 透過rackID找圖片
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

	// 透過job搜尋全部職缺
	@Override
	public List<JobBean> findJobByJobLike(String job) throws SQLException {
		String sql = "select* from job where job like ?";
		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		System.out.println(job);
		pre.setString(1, "%" + job + "%");
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
			list.add(jb);
		}
		return list;
	}

	// 透過刊登id更改職缺等
	@Override
	public void updateJob(JobBean jobBean) {
		String sql = "update job set uID=?,job=?,salary=?,quantity=?,place=?,time=?,date=?,img=?,remark=?,rackUp=?,rackDown=? where rackID=?";
		try {
			queryRunner.update(DbUtils.getConnection(), sql, jobBean.getuID(), jobBean.getJob(), jobBean.getSalary(),
					jobBean.getQuantity(), jobBean.getPlace(), jobBean.getTime(), jobBean.getDate(), jobBean.getImg(),
					jobBean.getRemark(), jobBean.getRackUp(), jobBean.getRackDown(), jobBean.getRackID());

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// 透過刊登編號找一筆資料
	@Override
	public JobBean findBeanByRackID(int rackID) throws SQLException {
		String sql = "select* from job where rackID= ?";

		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
		pre.setInt(1, rackID);
		ResultSet rs = pre.executeQuery();

		JobBean j = new JobBean();
		while (rs.next()) {
			j.setuID(rs.getInt("uID"));
			j.setRackID(rs.getInt("rackID"));
			j.setJob(rs.getString("job"));
			j.setSalary(rs.getString("salary"));
			j.setQuantity(rs.getInt("quantity"));
			j.setPlace(rs.getString("place"));
			j.setTime(rs.getString("time"));
			j.setDate(rs.getString("date"));
			j.setImg(rs.getBlob("img"));
			j.setRemark(rs.getString("remark"));
			j.setRackUp(rs.getDate("rackUp"));
			j.setRackDown(rs.getDate("rackDown"));
		}
		return j;
	}

	@Override
	public List<JobBean> findBeanByuID(int uID) throws SQLException {
		String sql = "select* from job where uID=?";
		
		Connection connection = DbUtils.getConnection();
		PreparedStatement pre = connection.prepareStatement(sql);
	
		pre.setInt(1,uID );
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
			list.add(jb);
		}
		return list;
	}

}
