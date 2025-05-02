package kr.kh.shoppingmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import kr.kh.shoppingmall.model.vo.BuyVO;
import kr.kh.shoppingmall.model.vo.CartVO;
import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.service.ProductService;
import kr.kh.shoppingmall.utils.CustomUser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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
	@PostMapping("/amount/check")
	@ResponseBody
	public int amountCheck(@RequestParam String code) {
		ProductVO product = productService.getProduct(code, false);
		return product.getPr_amount();
	}

	@PostMapping("/buy")
	public String buy(Model model, BuyVO buy, @AuthenticationPrincipal CustomUser customUser, HttpServletRequest request) {
		String prevUrl = request.getHeader("Referer");
		if(productService.buy(buy, customUser)){
			return "redirect:/product/buy/complete/"+buy.getBu_num();
		}
		//실패하면 이전 URL로
		return "redirect:"+prevUrl;
	}
	@GetMapping("/buy/complete/{bu_num}")
	public String buyComplete(@PathVariable int bu_num) {
		return "product/complete";
	}
	@PostMapping("/final/complete")
	@ResponseBody
	public boolean productFinalComplete(@RequestParam int num, @AuthenticationPrincipal CustomUser customUser) {
		return productService.updateBuy(num, customUser);
	}
	
	@PostMapping("/cart/insert")
	@ResponseBody
	public boolean cartInsert(@RequestBody CartVO cart, @AuthenticationPrincipal CustomUser customUser) {
		return productService.insertCart(cart, customUser);
	}
	@GetMapping("/cart")
	public String cart(Model model, @AuthenticationPrincipal CustomUser customUser) {
		List<CartVO> cartList = productService.getCartList(customUser);
		System.out.println(cartList);
		model.addAttribute("cartList", cartList);
		return "product/cart";
	}
	@PostMapping("/cart/update")
	@ResponseBody
	public String cartUPdate(@RequestBody CartVO cart, @AuthenticationPrincipal CustomUser customUser) {
		return productService.updateCart(cart, customUser);
	}
	
	
}
