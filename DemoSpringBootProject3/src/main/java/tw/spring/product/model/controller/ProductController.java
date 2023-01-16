package tw.spring.product.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.spring.product.model.Product;
import tw.spring.product.model.ProductService;

@Controller
@RequestMapping("/product")
@SessionAttributes(names = {"totalPages","totalElements"})
public class ProductController {
		
	@Autowired
	private ProductService pService;
	
	@GetMapping("/productqueryallmain.controller")
	public String processQueryAllAction() {
		return "product/productQueryAll";
	}
	
	@PostMapping("/query/{pid}")
	@ResponseBody
	public Product processQueryByIdAction(@PathVariable("pid") int pid) {
		return pService.findById(pid);
	}
	
	@PostMapping("/query")
	@ResponseBody
	public List<Product> processQueryAllProductAction(){
		return pService.findAll();
	}
	
	@PostMapping("/queryByPage/{pageNo}")
	@ResponseBody
	public List<Product> processQueryByPageAction(@PathVariable("pageNo") int pageNo,Model m){
		int pageSize = 3;
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		Page<Product> page = pService.findAllByPage(pageable);
		
		m.addAttribute("totalPages",page.getTotalPages());
		m.addAttribute("totalElements", page.getTotalElements());
		return page.getContent();
	}
}
