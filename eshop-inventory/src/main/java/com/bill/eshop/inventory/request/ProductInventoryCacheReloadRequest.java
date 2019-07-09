package com.bill.eshop.inventory.request;

import com.bill.eshop.inventory.model.ProductInventory;
import com.bill.eshop.inventory.service.ProductInventoryService;

/**
 * 重新加载商品库存到缓存的请求
 * @author seabreeze
 *
 */
public class ProductInventoryCacheReloadRequest implements Request {

	/*
	 * 商品ID
	 */
	private Integer productId;
	
	/*
	 * 商品库存Service
	 */
	private ProductInventoryService productInventoryService;
	
	public ProductInventoryCacheReloadRequest(Integer productId,ProductInventoryService productInventoryService){
		this.productId = productId;
		this.productInventoryService = productInventoryService;
	}
	
	@Override
	public void process() {
		// 从数据库中查询最新的商品库存数量
		ProductInventory productInventory = productInventoryService.findProductInventory(productId);
		
		// 将以上商品库存数量，刷新到缓存
		productInventoryService.setProductInventoryCache(productInventory);
	}

	@Override
	public Integer getProductId() {
		return this.productId;
	}

}
