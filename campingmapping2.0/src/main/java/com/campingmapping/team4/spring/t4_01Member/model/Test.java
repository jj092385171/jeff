package com.campingmapping.team4.spring.t4_01Member.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

		
//			MemberDaoImpl testDao = new MemberDaoImpl();
//			Member byId = testDao.getById();
//			System.out.println(byId.toString());
//			List<Member> all = testDao.getAll();
//			ListIterator<Member> listIterator = all.listIterator();
//			listIterator.forEachRemaining(m->System.out.println(m));

			

			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtils.closeSessionFactory();
		}

	}

}
