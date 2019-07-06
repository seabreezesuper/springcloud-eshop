package com.bill.eshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bill.eshop.order.entity.Order;
import com.bill.eshop.order.entity.Product;
import com.bill.eshop.order.entity.User;
import com.bill.eshop.order.hystirx.command.GetOrderInfoCommand;
import com.netflix.hystrix.HystrixCommand;

@RestController
public class OrderController {

	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("hello!");
		return "hello";
	}

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET)
	public Order select(@PathVariable("orderId") String orderId) {

		HystrixCommand<Order> command = new GetOrderInfoCommand(restTemplate,orderId);

		Order order = command.execute();
		return order;
	}
	
//	public Order selectError(@PathVariable("orderId") String orderId) {
//		System.out.println("服务熔断！");
//		return null;
//	}


	
//	@RequestMapping(value = "/test/01", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test01Error")
//	public void test01() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test01Error() {
//		System.out.println("短路01！");
//	}
//	
//	@RequestMapping(value = "/test/02", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test02Error")
//	public void test02() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test02Error() {
//		System.out.println("短路02！");
//	}
//	
//	@RequestMapping(value = "/test/03", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test03Error")
//	public void test03() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test03Error() {
//		System.out.println("短路03！");
//	}
//	
//	@RequestMapping(value = "/test/04", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test04Error")
//	public void test04() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test04Error() {
//		System.out.println("短路04！");
//	}
//	
//	@RequestMapping(value = "/test/05", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test05Error")
//	public void test05() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test05Error() {
//		System.out.println("短路05！");
//	}
//	
//	@RequestMapping(value = "/test/06", method = RequestMethod.GET)
//	@HystrixCommand(fallbackMethod = "test06Error")
//	public void test06() {
//		User user = restTemplate.getForObject("http://ESHOP-USERSERIVICE/user/" + order.getUserId(), User.class);
//	}
//	
//	public void test06Error() {
//		System.out.println("短路06！");
//	}
	
}