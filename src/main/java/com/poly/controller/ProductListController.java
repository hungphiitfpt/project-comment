package com.poly.controller;

/*
* Copyright(c) Fujinet Co., Ltd.
* All rights reserved.
*
* $Id: ProductListController.java,v 1.6 2022/09/09 09:21:23 phi-nph Exp $
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.co.fjs.shoppingsys.repository.ProductRepository;
import vn.co.fjs.shoppingsys.service.ProductListService;
import vn.co.fjs.shoppingsys.service.ProductTypeService;

// Anotation này chú thích lớp này sẽ trả dữ liệu về view
@Controller
public class ProductListController {

	// tiêm inject bean tương ứng vào vị trí được đánh dấu.
	@Autowired
	ProductListService productservice;
	// tiêm inject bean tương ứng vào vị trí được đánh dấu.
	@Autowired
	ProductTypeService productTypeService;
	// tiêm inject bean tương ứng vào vị trí được đánh dấu.
	@Autowired
	ProductRepository productRepository;

	//đánh dấu cho một controller
	@GetMapping("/getAllProduct")
	public String findPanigation(
			// truyền vào giá trị mặc định của page là 0, khi chuyển đến controller này sẽ hiển thị page thứ 0
			@RequestParam(name = "page", defaultValue = "0") int page,
			// truyền vào giá trị mặc định của size là 5, khi chuyển đến controller này sẽ hiển thị tối đa 5 phần tử 1 trang
			@RequestParam(name = "size", defaultValue = "5") int size, 
			Model model) {
		
		//truy vấn tất cả sản phẩm theo số page và size đã comment ở trên
		model.addAttribute("listProducts", productRepository.findAll(PageRequest.of(page, size)));
		// sau khi truy vấn đến sẽ trả về view 
		return "product/index";
		
	}
	
	//đánh dấu cho một controller
	@RequestMapping("/buyCart")
	public String CartController(Model model) {

		return "cart/index";

	}

}