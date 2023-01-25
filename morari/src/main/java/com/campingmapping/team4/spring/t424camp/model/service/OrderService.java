package com.campingmapping.team4.spring.t424camp.model.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t401member.model.dao.repository.UserRepository;
import com.campingmapping.team4.spring.t401member.model.entity.UserProfiles;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.CampRepository;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.OrderRepository;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.OrderitemRepository;
import com.campingmapping.team4.spring.t424camp.model.dao.repository.SiteRepository;
import com.campingmapping.team4.spring.t424camp.model.entity.Camp;
import com.campingmapping.team4.spring.t424camp.model.entity.Order;
import com.campingmapping.team4.spring.t424camp.model.entity.Orderitem;
import com.campingmapping.team4.spring.t424camp.model.entity.Site;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderitemRepository orderitemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CampRepository campRepository;
	
	@Autowired
	private SiteRepository siteRepository;

	public Order insert(Integer uid, Integer[] siteIds, Integer[] nums, Date goingdate, Date leavingdate, Integer campID) {
		
		UserProfiles user = userRepository.findById(uid).get();
		
		Camp camp = campRepository.findById(campID).get();
		
		Date now = new Date();

		Set<Orderitem> orderitems = new HashSet<Orderitem>();
		int totalPrice = 0;
		for (int i=0; i<nums.length; i++) {
			if(nums[i] > 0) {
				int siteId = siteIds[i];
				Site site = siteRepository.findById(siteId).get();
				if(!checkRest(site, campID, goingdate, leavingdate)) {
					return null;
				}
				Integer price = site.getSiteMoney();
				totalPrice += price * nums[i];
				
				orderitems.add(new Orderitem(site, goingdate, leavingdate, nums[i], price)) ;
			}
		}
		
		Order order = new Order(user, now, goingdate, leavingdate, "訂單成立", totalPrice, camp, orderitems);
		
		order =  orderRepository.save(order);
		
		for (Orderitem orderitem: orderitems) {
			orderitem.setCampOrder(order);
			orderitemRepository.save(orderitem);
		}
		
		return order;
	}
	
	private boolean checkRest(Site site, Integer num, Date goingdate, Date leavingdate) {
		int daysBetween = (int) TimeUnit.DAYS.convert(leavingdate.getTime() - goingdate.getTime(), TimeUnit.MILLISECONDS);		
		for(int i=0; i<daysBetween; i++) {
			List<Orderitem> items = orderitemRepository.findBySiteidAndLessThanGoingDate(site.getSiteID(), goingdate);
			long totalNums = items.stream().mapToInt(Orderitem::getNumbers).sum();
			if ((site.getTotalSites() - totalNums) < num) {
				return false;
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(goingdate);
			cal.add(Calendar.DATE, 1);
			goingdate = cal.getTime();
		}
		return true;
	}
}
