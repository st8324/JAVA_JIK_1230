package kr.kh.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.shoppingmall.dao.ProductDAO;
import kr.kh.shoppingmall.model.vo.BuyListVO;
import kr.kh.shoppingmall.model.vo.BuyVO;
import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;
import kr.kh.shoppingmall.utils.CustomUser;
import kr.kh.shoppingmall.utils.UploadFileUtils;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

	@Value("${spring.path.upload}")
	String uploadPath;

	public List<CategoryVO> getCategory() {
		return productDAO.selectCategoryList();
	}

	public String insertCategory(CategoryVO category) {
		if(category == null){
			return "넘어온 정보가 없습니다.";
		}
		CategoryVO dbCategory = productDAO.selectCategoryByName(category.getCa_name());
		if(dbCategory != null){
			return "중복된 카테고리명입니다.";
		}
		dbCategory = productDAO.selectCategoryByCode(category.getCa_code());
		if(dbCategory != null){
			return "중복된 카테고리코드입니다.";
		}
		productDAO.insertCategory(category);
		return "카테고리를 등록했습니다.";
	}
	
	public String updateCategory(CategoryVO category) {
		if(category == null){
			return "넘어온 정보가 없습니다.";
		}
		CategoryVO dbCategory = productDAO.selectCategoryByName(category.getCa_name());
		if(dbCategory != null ){
			return "중복된 카테고리명입니다.";
		}
		if(productDAO.updateCategory(category)){
			return "카테고리를 수정했습니다.";
		}
		return "카테고리를 수정하지 못했습니다.";
	}

	public String deleteCategory(int ca_num) {
		try{
			if(productDAO.deleteCategory(ca_num)){
				return "카테고리를 삭제했습니다.";
			}
			return "카테고리를 삭제하지 못했습니다.";
		}catch(Exception e){
			return "제품이 등록된 카테고리는 삭제할 수 없습니다.";
		}
	}

	public List<ProductVO> getProductList(int ca_num) {
		return productDAO.selectProductList(ca_num);
	}

	public boolean insertProduct(ProductVO product, MultipartFile thumb) {
		if(product == null || thumb == null || thumb.getOriginalFilename().isEmpty()){
			return false;
		}
		String pr_code = productDAO.selectNextPrCode(product.getPr_ca_num());
		product.setPr_code(pr_code);
		boolean res = productDAO.insertProduct(product);
		if(!res){
			return false;
		}
		//썸네일 작업
		String fileName = thumb.getOriginalFilename();
		String suffix = getSuffix(fileName);
		String newFileName = product.getPr_code() + suffix;
		String thumbnail;
		try {
			thumbnail = UploadFileUtils.uploadFile(uploadPath, newFileName, thumb.getBytes(),"product");
			product.setPr_thumb(thumbnail);
			productDAO.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	private String getSuffix(String fileName) {
		
		int index = fileName.lastIndexOf(".");
		return index < 0 ? null : fileName.substring(index);
	}

	public void deleteProduct(String pr_code) {
		ProductVO product = productDAO.selectProduct(pr_code);
		if(product == null){
			return;
		}
		product.setPr_del("Y");
		productDAO.updateProduct(product);
	}

	public ProductVO getProduct(String pr_code, boolean isdel) {
		ProductVO product = productDAO.selectProduct(pr_code);
		//삭제된 제품도 OK
		if(isdel){
			return product;
		}
		//삭제 안된 제품만 OK 
		else if(product.getPr_del().equals("N")){
			return product;
		}
		return null;
	}

	public boolean updateProduct(ProductVO product, MultipartFile thumb) {
		if(product == null){
			return false;
		}
		//썸네일 작업
		try {
			String fileName = thumb.getOriginalFilename();
			if(thumb != null && fileName.length() != 0){
				String suffix = getSuffix(fileName);
				String newFileName = product.getPr_code() + suffix;
				String thumbnail;
				thumbnail = UploadFileUtils.uploadFile(uploadPath, newFileName, thumb.getBytes(),"product");
				product.setPr_thumb(thumbnail);
			}
			return productDAO.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAmount(ProductVO product) {
		if(product == null){
			return false;
		}
		ProductVO dbProduct = productDAO.selectProduct(product.getPr_code());
		if(dbProduct == null){
			return false;
		}
		if(product.getPr_amount() < 0 ){
			return false;
		}
		dbProduct.setPr_amount(dbProduct.getPr_amount()+product.getPr_amount());
		return productDAO.updateProduct(dbProduct);
	}

	public boolean buy(BuyVO buy, CustomUser customUser) {
		if(customUser == null || buy == null){
			return false;
		}
		int totalPrice = calclateTotalPrice(buy.getList());
		buy.setBu_total_price(totalPrice);
		buy.setBu_me_id(customUser.getUsername());
		boolean res = productDAO.insertBuy(buy);
		if(!res){
			return false;
		}
		setBu_num(buy.getBu_num(), buy.getList());
		productDAO.insertBuyList(buy.getList());
		//productDAO.updateProductAmount(buy.getList());
		System.out.println(buy);
		return true;
	}

	private void setBu_num(int bu_num, List<BuyListVO> list) {
		if(list == null || list.size() == 0){
			return;
		}
		for(BuyListVO bl : list){
			bl.setBl_bu_num(bu_num);
		}
	}

	private int calclateTotalPrice(List<BuyListVO> list) {
		if(list == null || list.size() == 0){
			return 0;
		}
		int total = 0;
		for(BuyListVO bl : list){
			//제품 정보 가져옴
			ProductVO product = productDAO.selectProduct(bl.getBl_pr_code());
			if(product == null){
				continue;
			}
			//제품 구매 가격 = 제품 가격 * 구매 수량
			bl.setBl_price(product.getPr_price() * bl.getBl_amount());
			//총 가격 = 총가격 + 제품 구매 가격
			total += bl.getBl_price();
		}
		return total;
	}
}
