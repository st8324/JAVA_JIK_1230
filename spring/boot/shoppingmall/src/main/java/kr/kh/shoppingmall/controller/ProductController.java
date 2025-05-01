package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;




@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/list/{ca_num}")
	public String list(Model model, @PathVariable int ca_num) {
		List<ProductVO> list = productService.getProductList(ca_num);
		model.addAttribute("productList", list);
		return "product/list";
	}
	@GetMapping("/detail")
	public String detail(Model model, String pr_code) {
		System.out.println(pr_code);
		ProductVO product = productService.getProduct(pr_code, false);
		model.addAttribute("product", product);
		return "product/detail";
	}
	
}
