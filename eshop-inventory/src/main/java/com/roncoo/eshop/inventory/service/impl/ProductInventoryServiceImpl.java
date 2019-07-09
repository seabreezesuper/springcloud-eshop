package com.roncoo.eshop.inventory.service.impl;

import javax.annotation.Resource;

import com.roncoo.eshop.inventory.dao.RedisDAO;
import com.roncoo.eshop.inventory.mapper.ProductInventoryMapper;
import com.roncoo.eshop.inventory.model.ProductInventory;
import com.roncoo.eshop.inventory.service.ProductInventoryService;

public class ProductInventoryServiceImpl implements ProductInventoryService{

	@Resource
	private ProductInventoryMapper productInventoryMapper;
	
	@Resource
	private RedisDAO redisDAo;
	
	@Override
	public void updateProductInventory(ProductInventory productInventory) {
		productInventoryMapper.updateProductInventory(productInventory);
		
	}

	@Override
	public void removeProductInventoryCache(ProductInventory productInventory) {
		String key = "product:inventory:"+productInventory.getProductId();
		redisDAo.delete(key);
	}

	@Override
	public ProductInventory findProductInventory(Integer productId) {
		return productInventoryMapper.findProductInventory(productId);
	}

	@Override
	public void setProductInventoryCache(ProductInventory productInventory) {
		String key = "product:inventory:"+productInventory.getProductId();
		redisDAo.set(key, String.valueOf(productInventory.getInventoryCnt()));
	}
	

}
