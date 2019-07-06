package com.roncoo.eshop.inventory.dao.impl;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.roncoo.eshop.inventory.dao.RedisDAO;

@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {

	@Resource
	private RedisTemplate redisTemplate;
	
	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public String get(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

}
