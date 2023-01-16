package tw.spring.order.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.spring.order.model.PurchaseOrder;
import tw.spring.order.model.PurchaseOrderService;

@Controller
@RequestMapping("/order")
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderService poService;
	
	@GetMapping("/queryallproductforpo.controller")
	public String processQueryAllProductForPoAction() {
		return "order/purchaseOrderProductList";
	}
	
	@GetMapping("/purchaseOrderProduct.controller")
	public String processProductOrderAction(@RequestParam("pid") int pid,Model m) {
		m.addAttribute("pid",pid);
		return "order/purchaseOrderProduct";
	}
	
	@PostMapping("/poinsert.controller")
	@ResponseBody
	public PurchaseOrder processPoAction(@RequestBody PurchaseOrder po) {
		po.setOdate(new Date());
		return poService.insert(po);
	}
	
}
