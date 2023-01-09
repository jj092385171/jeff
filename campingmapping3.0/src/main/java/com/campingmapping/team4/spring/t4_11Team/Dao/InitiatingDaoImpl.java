package com.campingmapping.team4.spring.t4_11Team.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t4_11Team.model.Initiating;

@Repository
@Transactional
public class InitiatingDaoImpl implements InitiatingDao{
	
	@Autowired
	private SessionFactory factory;

	@Override
	public String hqlCommand(String startdate, String enddate, String initiatingnum, String postmember,String camparea) {
		
		Session session = factory.openSession();
		
		String hql = "";
		String numCommand = "";
		String memberCommand = "";
		String areaCommand = "";
		String stdCommand = "";
		String edCommand = "";
		
		if(!initiatingnum.equals("0")) {
			numCommand = numCommand + "initiatingnum = " + initiatingnum + " AND ";
		}else {
			if(!postmember.equals("0")) {
				memberCommand = memberCommand + "postmember = " + postmember + " AND ";
			}
			if(!camparea.equals("0")) {
				areaCommand = areaCommand + "camparea = " + "'" + camparea + "'" + " AND ";
			}
			if(startdate.length()>1) {
				stdCommand = stdCommand + "startdate >= " + "'" + startdate + "'" + " AND ";
			}
			if(enddate.length()>1) {
				edCommand = edCommand + "enddate <=" + "'" + enddate + "'" +" AND ";
			}
		}
		
		hql = hql + "FROM Initiating WHERE " + numCommand + memberCommand + areaCommand + stdCommand + edCommand;
		
		String sqlCommand = hql.substring(0,hql.length()-4);
		session.close();
		return sqlCommand;
	}
	
	@Override
	public List<Initiating> selectInitiating(String sql) {
		Session session = factory.openSession();
		Query<Initiating> query = session.createQuery(sql,Initiating.class);
		List<Initiating> result = query.getResultList();
		session.close();
		return result;
	}

	@Override
	public Initiating setInitiating(Map<String, String[]> map) {
		Session session = factory.openSession();
		Initiating initiating = new Initiating();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String key = entry.getKey();
			String[] val = entry.getValue();
			String result = val[0];
			switch (key) {
			case "initiatingnum":
				initiating.setInitiatingnum(Integer.valueOf(result));
				break;
			case "postmember":
				initiating.setPostmember(Integer.valueOf(result));
				break;
			case "startdate":
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
				try {
					initiating.setStartdate(sd.parse(result));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "enddate":
				SimpleDateFormat ed = new SimpleDateFormat("yyyy-MM-dd");
				try {
					initiating.setEnddate(ed.parse(result));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				break;
			case "currentnum":
				initiating.setCurrentnum(Integer.valueOf(result));
				break;
			case "acceptnum":
				initiating.setAcceptablenum(Integer.valueOf(result));
				break;
			case "camparea":
				initiating.setCamparea(result);
				break;
			case "pair":
				initiating.setPair(Integer.valueOf(result));
				break;
			}
		}
		session.close();
		return initiating;
	}

	@Override
	public Initiating insertInitiating(Initiating initiating) {
		Session session = factory.openSession();
		if(initiating != null) {
			Date now = new Date();
			initiating.setPostdate(now);
			session.save(initiating);
		}
		session.close();
		return initiating;
	}

	@Override
	public boolean deleteInitiating(int initiatingnum) {
		Session session = factory.openSession();
		Initiating in = new Initiating();
		in = (Initiating)session.get(Initiating.class,initiatingnum);
		if(in != null) {
			session.delete(in);
			session.flush();
			session.close();
			return true;
		}
		session.close();
		return false;
	}

	@Override
	public Initiating updateInitiating(Initiating initiating) {
		Session session = factory.openSession();
		if(initiating != null) {
			session.update(initiating);
			session.flush();
		}
		session.close();
		return initiating;
	}

	@Override
	public List<Initiating> selectAllInitiating() {
		Session session = factory.openSession();
		Query<Initiating> query = session.createQuery("from Initiating",Initiating.class);
		List<Initiating> result = query.getResultList();
		session.close();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Initiating> selectAllCamparea() {
		Session session = factory.openSession();
			List<String> list = session.createQuery("select distinct camparea from Initiating").getResultList();
			ArrayList<Initiating> resultlis = new ArrayList<Initiating>();
			for (String string : list) {
				Initiating in = new Initiating();
				in.setCamparea(string);
				resultlis.add(in);
			}
			session.close();
			return resultlis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Initiating> selectAllMember() {
		Session session = factory.openSession();
		List<Integer> list = session.createQuery("select distinct postmember from Initiating").getResultList();
		ArrayList<Initiating> resultlist = new ArrayList<Initiating>();
		for (Integer integer : list) {
			Initiating in = new Initiating();
			in.setPostmember(integer);
			resultlist.add(in);
		}
		session.close();
		return resultlist;
	}

}
