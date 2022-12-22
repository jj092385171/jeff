package com.campingmapping.team4.spring.t4_36Shop.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.campingmapping.team4.spring.t4_36Shop.model.dao.CategoryDao;
import com.campingmapping.team4.spring.t4_36Shop.model.dao.impl.CategoryDaoImpl;
import com.campingmapping.team4.spring.t4_36Shop.model.entity.Category;

import util.HibernateUtils;

public class T36 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CategoryDao dao = new CategoryDaoImpl(session);
//			MemberDaoImpl testDao = new MemberDaoImpl();
//			Member byId = testDao.getById();
//			System.out.println(byId.toString());
//			List<Member> all = testDao.getAll();
//			ListIterator<Member> listIterator = all.listIterator();
//			listIterator.forEachRemaining(m->System.out.println(m));
			List<Category> result = dao.selectAll();

			for (Category com : result) {
				System.out.println("getPdid:" + com.getPdid());
				System.out.println("getUserID: " + com.getUserID());
				System.out.println("getPdname: " + com.getPdname());
				System.out.println("getPdtitle: " + com.getPdtitle());
				System.out.println("getPdcontent: " + com.getPdcontent());
				System.out.println("getPdtype: " + com.getPdtype());
				System.out.println("getPdpicture: " + com.getPdpicture());
				System.out.println("getPdinventory: " + com.getPdinventory());
				System.out.println("getPddate: " + com.getPddate());
				System.out.println("getPdlastupdate: " + com.getPdlastupdate());
			}

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}