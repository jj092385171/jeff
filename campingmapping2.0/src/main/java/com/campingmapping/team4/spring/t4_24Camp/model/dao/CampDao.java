package T4_24.dao;

import java.sql.Blob;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import T4_24.model.Camp;
import T4_24.model.City;

public class CampDao {
	
	private Session session;
	
	public CampDao(Session session){
		this.session = session;
	}

	
	//新增營地
	public Camp AddCamp(Camp camp) {
	
			session.save(camp);
			return camp;
	}
	
	//搜尋全部
	public List<Camp> showAll(){
		Query<Camp> query = session.createQuery("from Camp", Camp.class);
		List<Camp> resultList = query.getResultList();
		
		return resultList;
	}	
	
	//透過campID查詢camp
	public Camp findCampByID(Integer campID) {
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			return camp;
		}
		
		return null;
	}
	
	//更新營地
	public Camp updateByCampID(Integer campID , String campName, Integer cityID, String location, Blob campPictures, String description) {
		Camp campBean = session.get(Camp.class, campID);
		
		if(campBean != null) {
			campBean.setCampName(campName);
			campBean.setCity(session.get(City.class, cityID));
			campBean.setLocation(location);
			campBean.setCampPictures(campPictures);
			campBean.setDescription(description);
			
			return campBean;
		}
		
		return null;
	}
	
	//刪除營地, 要先刪除營地的標籤 , 刪除包含的營區位
	public boolean deletdByCampID(int campID){
		Camp camp = session.get(Camp.class, campID);
		
		if(camp != null) {
			session.delete(camp);
			return true;
		}
		
		return false;
	}
	
}
