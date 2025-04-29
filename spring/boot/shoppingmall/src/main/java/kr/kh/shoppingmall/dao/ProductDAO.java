package kr.kh.shoppingmall.dao;

import java.util.List;

import kr.kh.shoppingmall.model.vo.CategoryVO;

public interface ProductDAO {

	List<CategoryVO> selectCategoryList();

	CategoryVO selectCategoryByName(String ca_name);

	CategoryVO selectCategoryByCode(String ca_code);

	void insertCategory(CategoryVO category);

	boolean updateCategory(CategoryVO category);

	boolean deleteCategory(int ca_num);
	
}
