package com.campingmapping.team4.spring.t4_11Team.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.campingmapping.team4.spring.t4_11Team.model.Initiating;
import com.campingmapping.team4.spring.t4_33Forum.controller.newPostServlet;

public class InitiatingDaoImpl implements InitiatingDao{
	
	private Session session;
	
	public InitiatingDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public String hqlCommand(String startdate, String enddate, String initiatingnum, String postmember,String camparea) {
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
		System.out.println(sqlCommand);
		return sqlCommand;
	}
	
	@Override
	public List<Initiating> selectInitiating(String sql) {
		Query<Initiating> query = session.createQuery(sql,Initiating.class);
		List<Initiating> result = query.getResultList();
		return result;
	}

	@Override
	public Initiating setInitiating(Map<String, String[]> map) {
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
		return initiating;
	}

	@Override
	public Initiating insertInitiating(Initiating initiating) {
		Initiating in = session.get(Initiating.class, initiating.getInitiatingnum());
		if(in == null) {
			Date now = new Date();
			initiating.setPostdate(now);
			session.save(initiating);
			return initiating;
		}
		return null;
	}

	@Override
	public boolean deleteInitiating(int initiatingnum) {
		Initiating in = session.get(Initiating.class,initiatingnum);
		if(in != null) {
			session.delete(in);
			return true;
		}
		return false;
	}

	@Override
	public Initiating updateInitiating(Initiating initiating) {
		Initiating in = session.get(Initiating.class, initiating.getInitiatingnum());
		if(in != null) {
			in.setStartdate(initiating.getStartdate());
			in.setEnddate(initiating.getEnddate());
			in.setCurrentnum(initiating.getCurrentnum());
			in.setAcceptablenum(initiating.getAcceptablenum());
			in.setCamparea(initiating.getCamparea());
			in.setPair(initiating.getPair());
		}
		return in;
	}

	@Override
	public List<Initiating> selectAllInitiating() {
		Query<Initiating> query = session.createQuery("from Initiating",Initiating.class);
		List<Initiating> result = query.getResultList();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Initiating> selectAllCamparea() {
			List<String> list = session.createQuery("select distinct camparea from Initiating").getResultList();
			ArrayList<Initiating> resultlis = new ArrayList<Initiating>();
			for (String string : list) {
				Initiating in = new Initiating();
				in.setCamparea(string);
				resultlis.add(in);
			}
			return resultlis;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Initiating> selectAllMember() {
		List<Integer> list = session.createQuery("select distinct postmember from Initiating").getResultList();
		ArrayList<Initiating> resultlist = new ArrayList<Initiating>();
		for (Integer integer : list) {
			Initiating in = new Initiating();
			in.setPostmember(integer);
			resultlist.add(in);
		}
		
		return resultlist;
	}

}
