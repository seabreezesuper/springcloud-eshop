package com.bill.eshop.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bill.eshop.product.entity.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ProductController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod="selectErr")
	public Product select(@PathVariable("productId") String productId) {

//		// 调用一个不存在的服务，使其熔断
//		restTemplate.getForObject("http://ESHOP-NOSERIVICE/", String.class);
		
		Product product = null;

		if (!StringUtils.isEmpty(productId) && "PID0001".equals(productId)) {
			product = new Product();
			product.setProductId("PID0001");
			product.setProductName("华为手机Mate20");
			product.setSpec("麒麟980芯片/6GB RAM/128GB ROM");
			product.setVendor("华为");
			product.setPrice("5000");
		}
		
		System.out.println(product.toString());

		return product;
	}
	
	public Product selectErr(@PathVariable("productId") String productId) {

		System.out.println("产品服务熔断！");
		return null;
	}
}