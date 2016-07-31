package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.bean.Product;
import com.test.bean.ProductForm;
import com.test.util.SaveProductAction;
import com.test.validator.ProductValidator;

public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ProductForm productForm = new ProductForm();
		productForm.setName(request.getParameter("name"));
		productForm.setDescription(request.getParameter("description"));
		productForm.setPrice(request.getParameter("price"));
		
		ProductValidator productValidator = new ProductValidator();
		List<String> errors = productValidator.validate(productForm);
		
		if(errors.isEmpty()){
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(Float.parseFloat(productForm.getPrice()));
			
			//模仿后端保存数据的操作
			SaveProductAction savaAction = new SaveProductAction();
			savaAction.save(product);
			
			request.setAttribute("product", product);
			return "/WEB-INF/jsp/ProductDetail.jsp";
		}else{
			request.setAttribute("errors", errors);
			request.setAttribute("form", productForm);
			return "/WEB-INF/jsp/ProductForm.jsp";
		}
		
	}

}
