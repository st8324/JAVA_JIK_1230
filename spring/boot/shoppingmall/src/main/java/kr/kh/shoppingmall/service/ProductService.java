package kr.kh.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.shoppingmall.dao.ProductDAO;
import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDAO;

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
}
