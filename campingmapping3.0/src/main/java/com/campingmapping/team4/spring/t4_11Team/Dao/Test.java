package com.campingmapping.team4.spring.t4_11Team.Dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_11Team.model.Initiating;

import util.HibernateUtils;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Initiating in = new Initiating();
			in.setInitiatingnum(8);//設定號碼
			Date startTime = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(startTime);
			c.add(Calendar.DATE, 7);
			startTime = c.getTime();
			in.setStartdate(startTime);//設定起始日期
			Date endTime = new Date();
			Calendar e = Calendar.getInstance();
			e.setTime(endTime);
			e.add(Calendar.DATE, 14);
			endTime = e.getTime();
			in.setEnddate(endTime);//設定結束日期
			in.setCurrentnum(5);//設定目前人數
			in.setAcceptablenum(3);//設定接受人數
			in.setCamparea("聖德基督學院");//設定地點
			in.setPair(0);//設定配對
			
			InitiatingDaoImpl iDao = new InitiatingDaoImpl(session);
			List<Initiating> result = iDao.selectAllCamparea();
			
			for (Initiating initiating : result) {
				System.out.println(initiating.getCamparea());
			}
//			List<Initiating> result = iDao.selectInitiating(hql);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("顯示失敗");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}
