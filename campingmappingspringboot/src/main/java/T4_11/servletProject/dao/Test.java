package T4_11.servletProject.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import T4_11.bean.InitiatingBean;

public class Test {

	public static void main(String[] args) {
		
		InitiatingBean initiatingBean = new InitiatingBean();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("請輸入會員");
			initiatingBean.setPostmember(scanner.nextInt());
			Date now = new Date();
			initiatingBean.setPostdate(now);
			Date startTime = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(startTime);
			c.add(Calendar.DATE, 7);
			startTime = c.getTime();
			initiatingBean.setStartdate(startTime);
			Date endTime = new Date();
			Calendar e = Calendar.getInstance();
			e.setTime(endTime);
			e.add(Calendar.DATE, 14);
			endTime = e.getTime();
			initiatingBean.setEnddate(endTime);
			System.out.println("請輸入現有人數");
			initiatingBean.setCurrentnum(scanner.nextInt());
			System.out.println("請輸入可接受人數");
			initiatingBean.setAcceptablenum(scanner.nextInt());
			System.out.println("請輸入露營地點");
			initiatingBean.setCamparea(scanner.next());
			initiatingBean.setPair(0);
			
			InitiatingDaoImpl iDao = new InitiatingDaoImpl();
			iDao.insertInitiating(initiatingBean);
		}
		
	}

}
