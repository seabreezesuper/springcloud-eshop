package com.bill.eshop.inventory.service.impl;

import javax.annotation.Resource;

import org.springframework.util.StringUtils;

import com.bill.eshop.inventory.dao.RedisDAO;
import com.bill.eshop.inventory.mapper.ProductInventoryMapper;
import com.bill.eshop.inventory.model.ProductInventory;
import com.bill.eshop.inventory.service.ProductInventoryService;

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

	@Override
	public ProductInventory getProductInventoryCache(Integer productId) {
		
		Long inventoryCnt = 0L;
		
		String key = "product:inventory:"+productId;
		String result = redisDAo.get(key);
		
		if(!StringUtils.isEmpty(result)) {
			try {
				inventoryCnt = Long.valueOf(result);
				return new ProductInventory(productId,inventoryCnt);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	

}
