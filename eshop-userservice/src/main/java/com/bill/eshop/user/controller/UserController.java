package com.bill.eshop.user.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bill.eshop.user.entity.User;

@RestController
public class UserController {

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public User select(@PathVariable("userId") String userId) {

		User user = null;

		if (!StringUtils.isEmpty(userId) && "UID0001".equals(userId)) {
			user = new User();
			user.setUserId("UID0001");
			user.setUserName("长江");
			user.setSex("男");
			user.setAge("12");
			user.setAddress("银河系地球村101号房");
			user.setPhone("1681388888");
		}

		return user;
	}
}