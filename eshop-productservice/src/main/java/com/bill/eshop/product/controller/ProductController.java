package com.bill.eshop.product.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bill.eshop.product.entity.Product;

@RestController
public class ProductController {

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	public Product select(@PathVariable("productId") String productId) {

		Product product = null;

		if (!StringUtils.isEmpty(productId) && "PID0001".equals(productId)) {
			product = new Product();
			product.setProductId("PID0001");
			product.setProductName("华为手机Mate20");
			product.setSpec("麒麟980芯片/6GB RAM/128GB ROM");
			product.setVendor("华为");
			product.setPrice("5000");
		}

		return product;
	}
}