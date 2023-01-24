package com.campingmapping.team4.spring.t436mall.model.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductOrderDetailRepository;
import com.campingmapping.team4.spring.t436mall.model.dao.repository.ProductOrderRepository;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductCartVoRequest;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrder;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderDetail;
import com.campingmapping.team4.spring.t436mall.model.entity.ProductOrderVo;
import com.campingmapping.team4.spring.t436mall.model.service.ProductOrderService;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	public ProductOrderRepository pDao;

	@Autowired
	public ProductOrderDetailRepository pODDao;

	@Autowired
	public ProductOrderDetailServiceImpl pODServ;

	@Autowired
	public ProductCartServiceImpl pCarServ;

	// 根據購物車新增一筆訂單
	@Override
	public ProductOrder create(List<ProductCartVoRequest> productcartvorequest,
			String odrecipient, String odrecipientphone,
			String odshippingaddress, Integer money) {
		ProductOrder order = new ProductOrder();
		Date now = new Date();
		order.setDatetime(now);
		order.setId(UUID.randomUUID().toString());
		order.setOdstatus("未出貨");
		order.setUserid(productcartvorequest.get(0).getUserid());
		order.setOdrecipient(odrecipient);
		order.setOdrecipientphone(odrecipientphone);
		order.setOdshippingaddress(odshippingaddress);
		order.setMoney(money);
		pDao.save(order);

		for (ProductCartVoRequest pVoRequest : productcartvorequest) {
			ProductOrderDetail pODetail = new ProductOrderDetail();
			pODetail.setPdid(pVoRequest.getPdid());
			pODetail.setPdqty(pVoRequest.getCtqty());
			pODetail.setPdorderid(order.getId());
			pODServ.create(pODetail);
		}
		pCarServ.deleteAllByUserId(order.getUserid());
		return order;
	}
	// 依orderID來搜尋單筆訂單
	@Override
	public List<ProductOrderVo> selectById(String id) {
		return pDao.findById(id);
	}
	// 依userID來搜尋所有訂單
	@Override
	public List<ProductOrder> selectAllByUserId(Integer userid) {
		return pDao.findByUserid(userid);
	}
	// 搜尋所有訂單(只有後臺能使用)
	@Override
	public List<ProductOrder> selectAll() {
		return pDao.findAll();
	}
	// 修改訂單狀態
	@Override
	public void updateProductOrderSatusById(String orderStatus, Date newDate,
			String orderId) {
		Date now = new Date();
		newDate = now;
		pDao.updateProductOrderSatusById(orderStatus, newDate, orderId);
	}
	// 修改訂單出貨地址、收件人、手機號(只有後臺能使用)
	@Override
	public ProductOrder updateById(ProductOrder productorder) {
		return pDao.save(productorder);
	}
	// 依userID來修改單筆產品(只有後臺能使用)
}
