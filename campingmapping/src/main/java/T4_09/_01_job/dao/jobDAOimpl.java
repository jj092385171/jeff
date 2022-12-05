package T4_09._01_job.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import T4_09._01_job.model.JobBean;
import utils.DbUtils;

public class jobDAOimpl implements jobDAO {
	private QueryRunner queryRunner = new QueryRunner();


	
	@Override
	public void addJob(JobBean jobBean) {
		//新增資料
		String sql = "insert into job values(?,?,?,?,?,?,?,?,?,?)";
		try {
			int row= queryRunner.update(sql, jobBean.getuID(), jobBean.getSalary(), jobBean.getQuantity(),
					jobBean.getPlace(), jobBean.getTime(), jobBean.getDate(), jobBean.getRemark(), jobBean.getRackUp(),
					jobBean.getRackDown(), jobBean.getImg());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//透過職缺搜尋
	@Override
	public JobBean selectJob(String blank) {
		String sql = "select* from job where blank like ?";
		try {
			JobBean jobean = queryRunner.query(sql, new BeanHandler<JobBean>(JobBean.class), blank);
			return jobean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteJob(String blank) {
		//透過職缺刪除資料
		String sql = "delete from job where blank = ?";
	 try {
		 int row= queryRunner.update(sql,new BeanHandler<JobBean>(JobBean.class), blank);
		 
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}

	@Override
	public void updateJob(JobBean jobBean) {
		//透過id更改職缺
		String sql = "update job set blank = ? where uID = ?";
		try {
			int row = queryRunner.update(sql,jobBean.getBlank(),jobBean.getuID());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public List<JobBean> selectAll() {
		//搜尋全部
		String sql = "select* from job";
		try {
			List<JobBean> li = queryRunner.query(sql, new ResultSetHandler<List<JobBean>>(){
				public List<JobBean>handle(ResultSet rs) throws SQLException {
					List<JobBean>list=new ArrayList<JobBean>();
					while(rs.next()) {
						JobBean jb = new JobBean();
						jb.setBlank(rs.getString("blank"));
						jb.setDate(rs.getString("date"));
						jb.setImg(rs.getBlob("img"));
						jb.setPlace(rs.getString("place"));
						jb.setQuantity(rs.getInt("quantity"));
						jb.setRackDown(rs.getDate("rackDown"));
						jb.setRemark(rs.getString("remark"));
						jb.setSalary(rs.getInt("salary"));
						jb.setTime(rs.getString("time"));
						jb.setuID(rs.getInt("uID"));
						jb.setRackUp(rs.getDate("rackUp"));
						list.add(jb);
					}
					return list;
					
				}
			});
			
		} catch (Exception e) {
		}
		
		return null;
	}


}
