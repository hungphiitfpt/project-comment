package com.poly.intf;

import org.springframework.data.domain.Page;

import com.poly.model.MstProduct;

// đây là lớp sẽ tạo ra tên và tham số của những phương thức sẽ sử dụng
public interface ProductListService {
	
	//phương thức truy vấn tất cả sản phẩm
	List<MstProduct> findAllProduct();

	// phương thức truy vấn theo ký tự người dùng muốn lọc (tìm theo mô tả, tên, id sản phẩm)
	List<MstProduct> findByKeyWord(String description, String name, String typeid);
	
	/*
	 * phương thức truy vấn theo ký tự người dùng 
	 * muốn lọc (tìm theo mô tả, tên, id sản phẩm, 
	 * Pageable pageable truy vấn có phân trang)
	 * 
	 */
	Page<MstProduct> findProductPagigation(String name, String description, String typeid, Pageable pageable);
}
