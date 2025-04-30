package kr.kh.shoppingmall.dao;

import java.util.List;

import kr.kh.shoppingmall.model.vo.CategoryVO;
import kr.kh.shoppingmall.model.vo.ProductVO;

public interface ProductDAO {

	List<CategoryVO> selectCategoryList();

	CategoryVO selectCategoryByName(String ca_name);

	CategoryVO selectCategoryByCode(String ca_code);

	void insertCategory(CategoryVO category);

	boolean updateCategory(CategoryVO category);

	boolean deleteCategory(int ca_num);

	List<ProductVO> selectProductList(int pr_ca_num);

	boolean insertProduct(ProductVO product);

	boolean updateProduct(ProductVO product);

	String selectNextPrCode(int pr_ca_num);

	ProductVO selectProduct(String pr_code);
	
}
