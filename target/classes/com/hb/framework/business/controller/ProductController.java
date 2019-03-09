package com.hb.framework.business.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.business.entity.Order;
import com.hb.framework.business.service.ProductService;

@Controller
@RequestMapping("/background/system/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Order> getProducts(HttpServletRequest request, String productCd) throws JSONException{
		return productService.getProducts(request, productCd);
	}
	
	@RequestMapping("/queryMer")
	@ResponseBody
	public List<Order> getMerchant() throws JSONException{
		return productService.getMerchant();
	}
}
