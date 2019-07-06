package com.bill.eshop.order.hystirx.command;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.bill.eshop.order.entity.Order;
import com.bill.eshop.order.entity.Product;
import com.bill.eshop.order.entity.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetOrderInfoCommand extends HystrixCommand<Order>{

	private RestTemplate restTemplate;
	
	private String orderId;

	public GetOrderInfoCommand(RestTemplate restTemplate,String orderId) {
		super(HystrixCommandGroupKey.Factory.asKey("GetOrderInfoCommandGroup"));
		this.restTemplate = restTemplate;
		this.orderId = orderId;
	}

	@Override
	protected Order run() throws Exception {
		// 获取order对象。（本应从数据库或缓存中获取订单信息，为简化逻辑，订单在构造环境中生成，通过getOrder()方法取得。）
		Order order = this.getOrder(orderId);
		
		System.out.println("user:"+order.getUserId()+",product:"+order.getProductId());

		// 调用用户服务，获得user对象
		User user = restTemplate.getForObject("http://ESHOP-USERSERVICE/user/" + order.getUserId(), User.class);
		order.setUser(user);

		// 调用产品服务，获得product对象
		Product product = restTemplate.getForObject("http://ESHOP-PRODUCTSERVICE/product/" + order.getProductId(),
				Product.class);
		order.setProduct(product);
		return order;
	}
	
	protected Order getFallback() {
		System.out.println("订单服务发生熔断！");
		return null;
	}
	
	
	
	private Order getOrder(String orderId) {
		Order order = null;
		
		if (!StringUtils.isEmpty(orderId) && "OID0001".equals(orderId)) {
			// 生成一个订单，该订单的用户为UID001,购买的产品为PID001
			order = new Order();
			order.setOrderId("OID0001");
			order.setUserId("UID0001");
			order.setProductId("PID0001");
			order.setOrderDateTime("2019-01-01 00:00:00");
		}

		return order;
	}

}
