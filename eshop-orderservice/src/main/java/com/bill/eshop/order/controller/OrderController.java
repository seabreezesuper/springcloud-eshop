package com.bill.eshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bill.eshop.order.entity.Order;
import com.bill.eshop.order.entity.Product;
import com.bill.eshop.order.entity.User;

@RestController
public class OrderController {

	@Autowired
	RestTemplate restTemplate;

	private Order order;

	OrderController() {

		// 生成一个订单，该订单的用户为UID001,购买的产品为PID001
		order = new Order();
		order.setOrderId("OID0001");
		order.setUserId("UID0001");
		order.setProductId("PID0001");
		order.setOrderDateTime("2019-01-01 00:00:00");
	}

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public Order select(@PathVariable("orderId") String orderId) {

		// 获取order对象。（本应从数据库或缓存中获取订单信息，为简化逻辑，订单在构造环境中生成，通过getOrder()方法取得。）
		Order order = this.getOrder(orderId);

		// 调用用户服务，获得user对象
		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
		order.setUser(user);

		// 调用产品服务，获得product对象
		Product product = restTemplate.getForObject("http://ESHOP-PRODUCTSERIVICE/product/" + order.getProductId(),
				Product.class);
		order.setProduct(product);

		return order;
	}

	private Order getOrder(String orderId) {
		Order order = null;

		if (!StringUtils.isEmpty(orderId) && "OID0001".equals(orderId)) {
			order = this.order;
		}

		return order;
	}
}