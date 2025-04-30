package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.AdminService;
import kr.kh.shoppingmall.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/page")
	public String page() {
		return "admin/page";
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		List<CategoryVO> list = productService.getCategory();
		model.addAttribute("list", list);
		return "admin/category";
	}
	@GetMapping("/category/insert")
	@ResponseBody
	public String categoryInsert(CategoryVO category) {
		return productService.insertCategory(category);
	}
	@GetMapping("/category/update")
	@ResponseBody
	public String categoryUpdate(CategoryVO category) {
		return productService.updateCategory(category);
	}
	@GetMapping("/category/delete")
	@ResponseBody
	public String categoryDelete(@RequestParam int num) {
		return productService.deleteCategory(num);
	}
	@GetMapping("/product")
	public String product(Model model, Integer ca_num) {
		List<ProductVO> productList = productService.getProductList(ca_num == null ? 0 : ca_num);
		model.addAttribute("productList", productList);
		return "admin/product_list";
	}
	@GetMapping("/product/insert/{ca_num}")
	public String productInsert(Model model, @PathVariable int ca_num) {
		List<CategoryVO> categoryList = productService.getCategory();
		model.addAttribute("categoryList", categoryList);
		return "admin/product_insert";
	}
	@PostMapping("/product/insert")
	public String productInsertPost(ProductVO product, MultipartFile thumb) {
		if(productService.insertProduct(product, thumb)){
			return "redirect:/admin/product";//+product.getPr_ca_num();
		}
		return "redirect:/admin/product/insert/" +product.getPr_ca_num();
	}
}
